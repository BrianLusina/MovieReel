package com.moviereel.domain.repositories

import com.moviereel.domain.models.movies.*
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface MoviesRepository {

    /**
     * Clear all movies from cache
     * @return [Completable]
     */
    fun clearAllMovies() : Completable

    /**
     * Get a list of now playing movies
     * @param page [Int] Page request
     * @param language [String] Language, defaults to english
     * @return [Flowable]
     */
    fun getMoviesNowPlayingList(page : Int = 1, language: String = "en-US") : Flowable<List<MovieNowPlayingDomainModel>>

    /**
     * get a now playing movie detail
     * @param id [Int] Id of the Now playing movie
     * @return [Flowable]
     */
    fun getMovieNowPlaying(id : Long) : Flowable<MovieNowPlayingDomainModel>

    /**
     * Save movies now playing to cache
     * @param moviesNowPlaying A list of movies that are now playing
     * @return [Completable]
     */
    fun saveMoviesNowPlaying(moviesNowPlayingCache : List<MovieNowPlayingDomainModel>) : Completable

    /**
     * Clear movies now playing, returns a Completable to allow us to determine if the operation
     * was successful or a failure
     * @return [Completable]
     */
    fun clearMoviesNowPlaying() : Completable


    fun getMoviesLatest(language: String) : Flowable<MovieLatestModel>

    fun getMoviesPopular(page : Int, language: String) : Flowable<List<MoviePopularModel>>

    fun getMoviesTopRated(page : Int, language: String, region: String) : Flowable<List<MovieTopRatedModel>>

    fun getMoviesUpcoming(page : Int, language: String, region: String) : Flowable<List<MovieUpcomingModel>>
}
