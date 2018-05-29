package com.moviereel.data.source.movies.stores

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Interface defining methods for the data operations related to Movies.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface MovieDataStore {
    fun clearAllMovies(): Completable

    fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingDataEntity>): Completable

    fun saveMovieNowPlaying(movieNowPlaying: MovieNowPlayingDataEntity): Completable

    fun clearMoviesNowPlaying() : Completable

    /**
     * Get movies now playing given the page and
     */
    fun getMoviesNowPlaying(page : Int, language: String): Single<List<MovieNowPlayingDataEntity>>

    /**
     * Gets a movie that is now playing given its id
     * @param id MovieNowPlaying
     * @return [Single]
     */
    fun getMovieNowPlaying(id: Long) : Single<MovieNowPlayingDataEntity>
}