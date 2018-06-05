package com.moviereel.presentation.view.entertain.movie.toprated

import com.moviereel.data.db.entities.movie.MovieTopRatedEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseView

/**
 * @author lusinabrian on 27/08/17.
 * @Notes View interface
 */
interface MovieTopRatedView : EntertainPageBaseView{
    fun updateTopRatedMovies(movieTopRatedArrList : List<MovieTopRatedEntity>)
}