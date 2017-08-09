package com.moviereel.utils.toolbox

import android.support.v7.util.DiffUtil

/**
 * @author lusinabrian on 27/07/17.
 * @Notes Diff Util callback for managing data updates to adapters in the application
 */
class MovieReelDiffUtilCallback<T>(var oldItemList: ArrayList<T>, var newItemList: ArrayList<T>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemList[oldItemPosition] == newItemList[newItemPosition]
    }

    override fun getOldListSize() = oldItemList.size

    override fun getNewListSize() = newItemList.size

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newItemList[newItemPosition] == oldItemList[oldItemPosition]
    }
}