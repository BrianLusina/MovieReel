package com.moviereel.data.source.movies.stores

import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.data.source.movies.repo.MovieCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes
 */
class MovieCacheDataStore @Inject constructor(private val movieCache: MovieCache) : MovieDataStore {

    override fun clearMovies(): Completable {
        return movieCache.clearMoviesNowPlaying()
    }

    override fun saveMoviesNowPlaying(moviesNowPlaying: List<MovieNowPlayingEntity>): Completable {
        return movieCache.saveMoviesNowPlaying(moviesNowPlaying)
    }

    override fun getMoviesNowPlaying(): Single<List<MovieNowPlayingEntity>> {
        return movieCache.getMoviesNowPlaying()
    }

}