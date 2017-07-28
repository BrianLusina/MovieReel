package com.moviereel.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author lusinabrian on 01/06/17.
 * @Notes BaseViewHolder to be used on all view holders
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var mCurrentPosition: Int = 0

    protected abstract fun clear()

    open fun onBind(position: Int) {
        mCurrentPosition = position
        clear()
    }

    fun getCurrentPosition(): Int {
        return mCurrentPosition
    }
}