package com.moviereel.ui.entertain.movie.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MoviePopularEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseAdapter
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import javax.inject.Inject

/**
 * @author lusinabrian on 16/09/17.
 * @Notes adapter for popular movies
 */
class MoviePopularAdapter
@Inject
constructor(val moviePopularList: ArrayList<MoviePopularEntity>) : EntertainPageBaseAdapter<MoviePopularEntity>(moviePopularList) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EntertainPageBaseViewHolder<MoviePopularEntity> {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_entertainment_layout, parent, false)
                MoviePopularViewHolder(v, moviePopularList)
            }
            else -> {
                return super.onCreateViewHolder(parent, viewType)
            }
        }
    }
}