package com.moviereel.ui.views.viewholders

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.moviereel.R
import com.moviereel.ui.base.BaseViewHolder

/**
 * @author lusinabrian on 10/06/17.
 * @Notes
 */
class EmptyViewHolder(itemView: View) : BaseViewHolder(itemView) {

    lateinit var retryButton: Button

    lateinit var messageTextView: TextView

    override fun clear() {

    }

//    @OnClick(R.id.btn_retry)
//    fun onRetryClick() {
//        if (mCallback != null)
//            mCallback.onViewEmptyViewRetryClick()
//    }
}