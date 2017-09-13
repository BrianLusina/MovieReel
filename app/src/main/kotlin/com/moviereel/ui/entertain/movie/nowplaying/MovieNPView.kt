package com.moviereel.ui.entertain.movie.nowplaying

import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseView

/**
 * MovieReel
 * com.moviereel.com.moviereel.ui.fragments.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description: View Interface for [MovieNPFragment]
 */

interface MovieNPView : EntertainPageBaseView {
    /**
     * Sets adapter for the recycler view
     * @param movieResultsResponseList data to use to update movie list
     * *
     */
    fun updateMoviesNowPlaying(movieResultsResponseList: List<MovieNPEntity>)

}
