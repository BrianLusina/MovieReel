package com.moviereel.ui.base

import android.os.Handler
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import com.moviereel.utils.toolbox.MovieReelDiffUtilCallback
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import java.util.*

/**
 * @author lusinabrian on 27/07/17.
 * @Notes Base recyclerAdapter
 */
abstract class BaseRecyclerAdapter<T>(var objectList: ArrayList<T>) : RecyclerView.Adapter<BaseViewHolder<T>>(), AnkoLogger {

    private val pendingUpdates = ArrayDeque<ArrayList<T>>()

    override val loggerTag: String get() = this::class.java.simpleName

    /**
     * Replaces the content in the views that make up the menu item view and the
     * Ad view. This method is invoked by the layout manager.
     * Gets the item view type and determine what position to display
     * */
    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = objectList.size

    /**
     * Adds items to the adapter the normal way by notifying the adapter the data has changed
     * @param newObjectList object list to add*/
    fun addItems(newObjectList: ArrayList<T>){
        objectList.addAll(newObjectList)
        notifyDataSetChanged()
    }

    /**
     * Add items to the list
     * Will check if the trending list items has a given item and only add items that are not
     * in the adapter
     * Uses [DiffUtil] to calculate whether this adapter should be updated
     * This allows us to perform quicker operations and not keep updating the same items over and
     * over again
     * Calculation of diffs is done on a background thread to avoid blocking operations,
     * hence the reason for a [doAsync] callback
     * @param newObjectList Trending list with trending items
     * */
    fun addItemsUsingDiff(newObjectList: ArrayList<T>) {
        pendingUpdates.add(newObjectList)

        if (pendingUpdates.size > 1) {
            return
        }

        updateItemsInternal(newObjectList)
    }


    /**
     * Updates items in adapter and calls a background thread to process
     * the diff and return it before updating the adapter of the change
     * */
    private fun updateItemsInternal(newObjectList: ArrayList<T>) {
        val handler = Handler()
        Thread(Runnable {
            val diff = MovieReelDiffUtilCallback(objectList, newObjectList)
            val diffResult = DiffUtil.calculateDiff(diff)

            handler.post({
                applyDiffResult(newObjectList, diffResult)
            })
        }).start()
    }

    /**
     * Applyes the diff result to the new items which will apply th dispatch
     * to the adapter
     * @param newItemList
     * @param diffResult, result from Diffing of new and old items
     * */
    private fun applyDiffResult(newItemList: java.util.ArrayList<T>, diffResult: DiffUtil.DiffResult) {
        pendingUpdates.remove()

        // dispatch updates
        dispatchUpdates(newItemList, diffResult)

        if (pendingUpdates.size > 0) {
            updateItemsInternal(pendingUpdates.peek())
        }
    }


    /**
     * Dispatches updates to adapter with new items and diff result
     * @param newItems new items to add to adapter
     * @param diffResult diff result from callback
     * */
    private fun dispatchUpdates(newItems: ArrayList<T>, diffResult: DiffUtil.DiffResult) {
        diffResult.dispatchUpdatesTo(this)
        objectList.clear()
        objectList.addAll(newItems)
    }

}