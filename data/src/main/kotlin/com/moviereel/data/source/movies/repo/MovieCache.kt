package com.moviereel.data.source.movies.repo

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Interface defining methods for the caching of Movies.
 * This is to be implemented by the cache layer, using this interface as a way of communicating.
 */
interface MovieCache {

    fun clearAllMovies() : Completable

    /**
     * Clear all Movies now playing from the cache
     */
    fun clearMoviesNowPlaying(): Completable

    /**
     * Save a given list of MovieNowPlaying to the cache
     */
    fun saveMoviesNowPlaying(moviesNowPlayingEntity: List<MovieNowPlayingDataEntity>): Completable

    /**
     * Save a movie now playing
     */
    fun saveMovieNowPlaying(moviesNowPlayingEntity: MovieNowPlayingDataEntity) : Completable

    /**
     * Retrieve a list of Movies now playing from the cache
     */
    fun getMoviesNowPlaying(page : Int, language: String): Single<List<MovieNowPlayingDataEntity>>

    fun getMovieNowPlaying(id : Long) : Single<MovieNowPlayingDataEntity>

    /**
     * Checks if an element exists in the cache.
     * @return true if the element is cached, otherwise false.
     */
    fun isCached(): Boolean

    /**
     * sets the last cache time
     */
    fun setLastCacheTime(lastCache: Long)

    /**
     * Sets the last cache time for movies now playing
     */
    fun setLastCacheTimeMoviesNowPlaying(lastCache: Long)

    /**
     * Checks if the cache is expired.
     * @return true, the cache is expired, otherwise false.
     */
    fun isExpired(): Boolean
}