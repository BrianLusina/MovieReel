package com.moviereel.ui.entertain.base

import android.view.View
import com.moviereel.ui.base.BaseViewHolder

/**
 * @author lusinabrian on 16/09/17.
 * @Notes base view holder for movies and series adapters
 * Type V is the element we want this view holder to display
 */
abstract class EntertainPageBaseViewHolder<V>(itemView : View) : BaseViewHolder<V>(itemView){

    constructor(itemView: View, objectList: ArrayList<V>) : this(itemView)

    override fun onBind(position: Int) {
        super.onBind(position)
    }
}