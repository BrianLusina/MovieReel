package com.moviereel.ui.entertain.movie.nowplaying

import android.view.LayoutInflater
import android.view.ViewGroup
import com.moviereel.R
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseAdapter
import com.moviereel.ui.entertain.base.EntertainPageBaseViewHolder
import javax.inject.Inject

/**
 * @author lusinabrian on 01/06/17.
 * @Notes movie now playing adapter
 */

class MovieNPAdapter
@Inject
constructor(val movieNPEntityList: ArrayList<MovieNPEntity>) : EntertainPageBaseAdapter<MovieNPEntity>(movieNPEntityList) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EntertainPageBaseViewHolder<MovieNPEntity> {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> {
                val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_entertainment_layout, parent, false)
                MovieNpViewHolder(v, movieNPEntityList)
            }
            else -> {
                return super.onCreateViewHolder(parent, viewType)
            }
        }
    }
}
