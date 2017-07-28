package com.moviereel.ui.views.viewholders

import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.moviereel.R
import com.moviereel.ui.base.BaseViewHolder

/**
 * @author lusinabrian on 10/06/17.
 * @Notes
 */
class EmptyViewHolder(itemView: View) : BaseViewHolder(itemView) {

    @BindView(R.id.btn_retry)
    lateinit var retryButton: Button

    @BindView(R.id.tv_message)
    lateinit var messageTextView: TextView

    override fun clear() {

    }

//    @OnClick(R.id.btn_retry)
//    fun onRetryClick() {
//        if (mCallback != null)
//            mCallback.onViewEmptyViewRetryClick()
//    }
}