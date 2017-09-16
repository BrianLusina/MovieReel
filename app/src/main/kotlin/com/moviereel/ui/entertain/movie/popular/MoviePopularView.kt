package com.moviereel.ui.entertain.movie.popular

import com.moviereel.data.db.entities.movie.MoviePEntity
import com.moviereel.ui.entertain.base.EntertainPageBaseView

/**
 * @author lusinabrian on 27/08/17.
 * @Notes View interface for [MoviePopularFrag]
 */
interface MoviePopularView : EntertainPageBaseView {

    /**
     * Adds a list of popular movies to the adapter
     * @param popularMovieList Popular movie list
     * */
    fun updatePopularMovies(popularMovieList: List<MoviePEntity>)
}