package com.moviereel.ui.entertain.movie.toprated

import android.view.LayoutInflater
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseAdapter
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import javax.inject.Inject

/**
 * @author lusinabrian on 18/09/17.
 * @Notes Top rated adapter for movies
 */
class MovieTopRatedAdapter
@Inject
constructor(val movieTopRatedEntityList: ArrayList<MovieTopRatedEntity>) : EntertainPageBaseAdapter<MovieTopRatedEntity>(movieTopRatedEntityList) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EntertainPageBaseViewHolder<MovieTopRatedEntity> {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_entertainment_layout,
                        parent, false)
                MovieTopRatedViewHolder(v, movieTopRatedEntityList)
            }
            else -> {
                return super.onCreateViewHolder(parent, viewType)
            }
        }
    }
}