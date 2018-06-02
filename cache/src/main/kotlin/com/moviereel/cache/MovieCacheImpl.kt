package com.moviereel.cache

import com.moviereel.cache.db.dao.movies.MovieNowPlayingDao
import com.moviereel.cache.db.dao.movies.MoviePopularDao
import com.moviereel.cache.db.dao.movies.MovieTopRatedDao
import com.moviereel.cache.db.dao.movies.MovieUpcomingDao
import com.moviereel.cache.mapper.movies.MovieNowPlayingCacheMapper
import com.moviereel.cache.prefs.PreferencesHelper
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.data.source.movies.repo.MovieCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 17/04/18.
 * @Notes Cached implementation for retrieving and saving Movie data. This class implements the [MovieCache]
 * methods, as it is that class that defines the responsibilities that this layer should carry out when
 * communicating with the Cache
 */
class MovieCacheImpl
@Inject
constructor(
        private val movieNowPlayingCacheMapper: MovieNowPlayingCacheMapper,
        private val movieNowPlayingDao : MovieNowPlayingDao,
        private val moviePopularDao: MoviePopularDao,
        private val movieTopRatedDao: MovieTopRatedDao,
        private val movieUpcomingDao: MovieUpcomingDao,
        private val preferencesHelper: PreferencesHelper) : MovieCache{

    companion object {
        private const val EXPIRATION_TIME = (60 * 10 * 1000).toLong()
    }

    override fun clearAllMovies(): Completable {
        return Completable.defer {

            Completable.complete()
        }
    }

    override fun clearMoviesNowPlaying(): Completable {
        return Completable.defer{

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

    override fun saveMovieNowPlaying(movieNowPlayingDataEntity: MovieNowPlayingDataEntity): Completable {
        return Completable.defer{
            movieNowPlayingDao.insertMovieNp(movieNowPlayingCacheMapper.mapToCached(movieNowPlayingDataEntity))

            Completable.complete()
        }
    }

    override fun getMoviesNowPlaying(page: Int, language: String): Single<List<MovieNowPlayingDataEntity>> {
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

    // TODO: implement the isCached, checking the database for cached items
    override fun isCached(): Boolean {
        return false
    }

    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.setLastCache(lastCache)
    }

    override fun setLastCacheTimeMoviesNowPlaying(lastCache: Long) {
    }

    private fun getLastCacheUpdateTimeMillis() = preferencesHelper.getLastCache()

    /**
     * Check whether the current cached data exceeds the defined [EXPIRATION_TIME] time
     */
    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }
}