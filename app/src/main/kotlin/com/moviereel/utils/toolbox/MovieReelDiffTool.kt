package com.moviereel.utils.toolbox

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

/**
 * @author lusinabrian on 27/07/17.
 * @Notes Does diffing for adapters in class
 * This is a utility that allows all adapters to update their data in a background thread and
 * perform asynchronous updates
 * @param oldItemList old items
 * @param newItemList new item list
 * @param adapter adapter to update
 */
class MovieReelDiffTool<T, VH : RecyclerView.ViewHolder>(
        var oldItemList: ArrayList<T>,
        var pendingUpdates: ArrayDeque<ArrayList<T>>,
        var adapter: RecyclerView.Adapter<VH>) {

    /**
     * This performs a diff on the adapter
     * */
    fun performDiff(newItemList: ArrayList<T>) {
        pendingUpdates.add(newItemList)
        if (pendingUpdates.size > 1) {
            return
        }
        updateItemsInternal(newItemList)
    }

    fun updateItemsInternal(newItemList: ArrayList<T>) {
        doAsync {
            val diff = MovieReelDiffUtilCallback(oldItemList, newItemList)
            val diffResult = DiffUtil.calculateDiff(diff)

            uiThread {
                applyDiffResult(newItemList, diffResult)
            }
        }

//        val handler = Handler()
//        Thread(Runnable {
//            val diff = MovieReelDiffUtilCallback(oldItemList, newItemList)
//            val diffResult = DiffUtil.calculateDiff(diff)
//
//            handler.post({
//                applyDiffResult(newItemList, diffResult)
//            })
//        }).start()
    }

    /**
     * Applyes the diff result to the new items which will apply th dispatch
     * to the adapter
     * @param newItemList
     * @param diffResult, result from Diffing of new and old items
     * */
    fun applyDiffResult(newItemList: ArrayList<T>, diffResult: DiffUtil.DiffResult) {
        pendingUpdates.remove()

        // dispatch updates
        dispatchUpdates(newItemList, diffResult)

        if (pendingUpdates.size > 0) {
            performDiff(pendingUpdates.peek())
        }
    }


    /**
     * Dispatches updates to adapter with new items and diff result
     * @param newItems new items to add to adapter
     * @param diffResult diff result from callback
     * */
    fun dispatchUpdates(newItems: ArrayList<T>, diffResult: DiffUtil.DiffResult) {
        diffResult.dispatchUpdatesTo(adapter)
        oldItemList.clear()
        oldItemList.addAll(newItems)
    }

}