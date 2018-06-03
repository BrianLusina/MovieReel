package com.moviereel.cache.movies.nowplaying

import com.moviereel.cache.db.dao.movies.MovieNowPlayingDao
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 03/06/18.
 * @Notes Implementation for [NowPlaying]
 */
class NowPlayingImpl
@Inject
constructor(
        private val movieNowPlayingCacheMapper: NowPlayingCacheMapper,
        private val movieNowPlayingDao : MovieNowPlayingDao
): NowPlaying{

    override fun clearMoviesNowPlaying(): Completable {
        return Completable.defer {

            Completable.complete()
        }
    }

    override fun getMoviesNowPlaying(): Single<List<MovieNowPlayingDataEntity>> {
        val movieDataEntities = arrayListOf<MovieNowPlayingDataEntity>()

        // get all movies from cache
        val moviesNowPlayingFlowable = movieNowPlayingDao.getAllMoviesNowPlaying()

        // map these movies to data entities
        moviesNowPlayingFlowable.forEach {
            it.forEach {
                movieDataEntities.add(movieNowPlayingCacheMapper.mapFromCached(it))
            }
        }

        // return a Single with the data entities
        return Single.just(movieDataEntities)
    }

    override fun getMovieNowPlaying(id: Long): Single<MovieNowPlayingDataEntity> {
        return movieNowPlayingDao.getMovieNpById(id).map {
            movieNowPlayingCacheMapper.mapFromCached(it)
        }.singleOrError()
    }

    override fun saveMovieNowPlaying(movieNowPlayingDataEntity: MovieNowPlayingDataEntity): Completable {
        return Completable.defer{
            movieNowPlayingDao.insertMovieNp(movieNowPlayingCacheMapper.mapToCached(movieNowPlayingDataEntity))

            Completable.complete()
        }
    }

    override fun saveMoviesNowPlaying(moviesNowPlayingDataEntities: List<MovieNowPlayingDataEntity>): Completable {
        return Completable.defer {
            moviesNowPlayingDataEntities.forEach{
                movieNowPlayingDao.insertMovieNpList(movieNowPlayingCacheMapper.mapToCached(it))
            }

            Completable.complete()
        }
    }

    override fun setLastCache(lastCache: Long) {

    }
}