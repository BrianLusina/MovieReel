package com.moviereel.data.source.movies.repo

import com.moviereel.data.models.movies.MovieNowPlayingEntity
import io.reactivex.Single

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Interface defining methods for the retrieving Movies from. This is to be implemented by the
 * remote layer, using this interface as a way of communicating.
*/
interface MovieRemote {

    /**
     * Retrieve a list of MoviesNowPlaying, from api
     */
    fun getMoviesNowPlaying(page : Int, language: String): Single<List<MovieNowPlayingEntity>>

    fun getMovieNowPlaying(id : Long) : Single<MovieNowPlayingEntity>

}