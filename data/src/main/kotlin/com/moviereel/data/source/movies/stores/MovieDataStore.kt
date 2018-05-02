package com.moviereel.data.source.movies.stores

import com.moviereel.data.models.movies.MovieNowPlayingEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Interface defining methods for the data operations related to Movies.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface MovieDataStore {
    fun clearMovies(): Completable

    fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingEntity>): Completable

    fun getMoviesNowPlaying(): Single<List<MovieNowPlayingEntity>>
}