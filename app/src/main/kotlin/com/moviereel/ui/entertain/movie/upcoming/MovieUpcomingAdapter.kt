package com.moviereel.ui.entertain.movie.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieUpcomingEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseAdapter
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import javax.inject.Inject

/**
 * @author lusinabrian on 26/09/17.
 * @Notes upcoming adapter to store upcoming movies for recycler to use
 */
class MovieUpcomingAdapter
@Inject
constructor(val movieUpcomingEntityList: ArrayList<MovieUpcomingEntity>)
    : EntertainPageBaseAdapter<MovieUpcomingEntity>(movieUpcomingEntityList) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EntertainPageBaseViewHolder<MovieUpcomingEntity> {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_entertainment_layout, parent, false)
                MovieUpcomingViewHolder(v, movieUpcomingEntityList)
            }
            else -> {
                return super.onCreateViewHolder(parent, viewType)
            }
        }
    }
}