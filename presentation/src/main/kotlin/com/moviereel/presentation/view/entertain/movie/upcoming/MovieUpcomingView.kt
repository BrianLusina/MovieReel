package com.moviereel.presentation.view.entertain.movie.upcoming

import com.moviereel.data.db.entities.movie.MovieUpcomingEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseView

/**
 * @author lusinabrian on 27/08/17.
 * @Notes View interface
 */
interface MovieUpcomingView : EntertainPageBaseView{
    /**
     * Sets adapter for the recycler view
     * @param movieUpcomingList data to use to update movie list
     */
    fun updateMoviesUpcoming(movieUpcomingList: List<MovieUpcomingEntity>)

}