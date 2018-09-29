package com.moviereel.ui.entertain.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.ui.base.BaseRecyclerAdapter
import com.moviereel.ui.base.BaseViewHolder

/**
 * @author lusinabrian on 13/09/17.
 * @Notes base adapter for entertainment
 */
abstract class EntertainPageBaseAdapter<E>(objectList: ArrayList<E>) : BaseRecyclerAdapter<E>(objectList) {
    val VIEW_TYPE_LOADING = 0
    val VIEW_TYPE_NORMAL = 1

    lateinit var mCallback: Callback

    fun setCallback(callback: Callback) {
        mCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntertainPageBaseViewHolder<E> {
        return when (viewType) {
            VIEW_TYPE_LOADING -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.progress_dialog, parent, false)
                LoadingViewHolder(v)
            }
            else -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_empty_view, parent, false)
                EmptyViewHolder(v)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (objectList.size > 0) {
            VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_LOADING
        }
    }

    override fun getItemCount() = objectList.size

    interface Callback {
        fun onViewEmptyViewRetryClick()
    }

    inner class EmptyViewHolder(itemView: View) : BaseViewHolder<E>(itemView) {

        fun onRetryClick() {
            // btn_retry
            mCallback.onViewEmptyViewRetryClick()
        }
    }

    inner class LoadingViewHolder(itemView: View) : BaseViewHolder<E>(itemView)

}