package com.moviereel.cache.movies.nowplaying

import com.moviereel.cache.db.models.movie.MovieNowPlayingCacheModel
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author lusinabrian on 03/06/18.
 * @Notes Interface defining how to access movies that are now playing
 */
interface NowPlaying {

    fun clearMoviesNowPlaying() : Completable

    fun saveMoviesNowPlaying(moviesNowPlayingDataEntities: List<MovieNowPlayingDataEntity>): Completable

    fun saveMovieNowPlaying(movieNowPlayingDataEntity: MovieNowPlayingDataEntity): Completable

    fun getMoviesNowPlaying() : Single<List<MovieNowPlayingDataEntity>>

    fun getMovieNowPlaying(id: Long): Single<MovieNowPlayingDataEntity>

    fun setLastCache(lastCache: Long)
}