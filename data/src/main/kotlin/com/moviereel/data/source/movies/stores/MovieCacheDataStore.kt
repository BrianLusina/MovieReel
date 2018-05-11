package com.moviereel.data.source.movies.stores

import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.data.source.movies.repo.MovieCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Implementation of the [MovieDataStore] interface to provide a means of communicating
 * with the local data source
 */
open class MovieCacheDataStore @Inject constructor(private val movieCache: MovieCache) : MovieDataStore {

    override fun saveMovieNowPlaying(movieNowPlaying: MovieNowPlayingEntity): Completable {
        return movieCache.saveMovieNowPlaying(movieNowPlaying)
    }

    override fun clearAllMovies(): Completable {
        return movieCache.clearAllMovies()
    }

    override fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingEntity>): Completable {
        return movieCache.saveMoviesNowPlaying(moviesNowPlaying).doOnComplete{
            movieCache.setLastCacheTime(System.currentTimeMillis())
            movieCache.setLastCacheTimeMoviesNowPlaying(System.currentTimeMillis())
        }
    }

    override fun clearMoviesNowPlaying(): Completable {
        return movieCache.clearMoviesNowPlaying()
    }

    override fun getMoviesNowPlaying(page: Int, language: String): Single<List<MovieNowPlayingEntity>> {
        return movieCache.getMoviesNowPlaying(page, language)
    }

    override fun getMovieNowPlaying(id: Long): Single<MovieNowPlayingEntity> {
        return movieCache.getMovieNowPlaying(id)
    }
}