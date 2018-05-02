package com.moviereel.data.source.movies

import com.moviereel.data.models.movies.MovieNowPlayingEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Interface defining methods for the caching of Movies.
 * This is to be implemented by the cache layer, using this interface as a way of communicating.
 */
interface MovieCache {
    /**
     * Clear all Bufferoos from the cache
     */
    fun clearMoviesNowPlaying(): Completable

    /**
     * Save a given list of MovieNowPlaying to the cache
     */
    fun saveMoviesNowPlaying(moviesNowPlayingEntity: List<MovieNowPlayingEntity>): Completable

    /**
     * Retrieve a list of Movies now playing from the cache
     */
    fun getMoviesNowPlaying(): Single<List<MovieNowPlayingEntity>>

    /**
     * Checks if an element (User) exists in the cache.
     * @return true if the element is cached, otherwise false.
     */
    fun isCached(): Boolean

    /**
     * Checks if an element (User) exists in the cache.
     * @param userId The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    fun setLastCacheTime(lastCache: Long)

    /**
     * Checks if the cache is expired.
     * @return true, the cache is expired, otherwise false.
     */
    fun isExpired(): Boolean

}