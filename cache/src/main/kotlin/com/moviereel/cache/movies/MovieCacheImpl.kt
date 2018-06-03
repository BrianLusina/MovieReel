package com.moviereel.cache.movies

import com.moviereel.cache.movies.nowplaying.NowPlaying
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 03/06/18.
 * @Notes Movie Cache implementation
 */
class MovieCacheImpl
@Inject
constructor(
        private val nowPlaying: NowPlaying): MovieCache{

    override fun clearAllMovies(): Completable {
        return Completable.defer {

            Completable.complete()
        }
    }

    override fun clearMoviesNowPlaying(): Completable {
        return nowPlaying.clearMoviesNowPlaying()
    }

    override fun getMoviesNowPlaying(): Single<List<MovieNowPlayingDataEntity>> {
        return nowPlaying.getMoviesNowPlaying()
    }

    override fun getMovieNowPlaying(id: Long): Single<MovieNowPlayingDataEntity> {
        return nowPlaying.getMovieNowPlaying(id)
    }

    override fun saveMovieNowPlaying(movieNowPlayingDataEntity: MovieNowPlayingDataEntity): Completable {
        return nowPlaying.saveMovieNowPlaying(movieNowPlayingDataEntity)
    }

    override fun saveMoviesNowPlaying(moviesNowPlayingDataEntities: List<MovieNowPlayingDataEntity>): Completable {
        return nowPlaying.saveMoviesNowPlaying(moviesNowPlayingDataEntities)
    }

    override fun setLastCache(lastCache: Long) {
    }
}