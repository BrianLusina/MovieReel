package com.moviereel.ui.entertain.movie.nowplaying

import android.view.LayoutInflater
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNowPlayingEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseAdapter
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import javax.inject.Inject

/**
 * @author lusinabrian on 01/06/17.
 * @Notes movie now playing adapter
 */

class MovieNPAdapter
@Inject
constructor(val movieNowPlayingEntityList: ArrayList<MovieNowPlayingEntity>) : EntertainPageBaseAdapter<MovieNowPlayingEntity>(movieNowPlayingEntityList) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EntertainPageBaseViewHolder<MovieNowPlayingEntity> {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_entertainment_layout, parent, false)
                MovieNpViewHolder(v, movieNowPlayingEntityList)
            }
            else -> {
                return super.onCreateViewHolder(parent, viewType)
            }
        }
    }
}
