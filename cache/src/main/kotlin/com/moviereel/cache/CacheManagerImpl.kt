package com.moviereel.cache

import com.moviereel.cache.movies.MovieCache
import com.moviereel.cache.movies.nowplaying.NowPlaying
import com.moviereel.cache.prefs.PreferencesHelper
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author lusinabrian on 03/06/18.
 * @Notes Cache Manager implementation will be used to implement the CacheManager responsibilities
 * as passed down from the Data layer
 */
class CacheManagerImpl
@Inject
constructor(
        private val movieCache: MovieCache,
        private val preferencesHelper: PreferencesHelper
): CacheManager{

    companion object {
        private const val EXPIRATION_TIME = (60 * 10 * 1000).toLong()
    }

    override fun clearAllMovies(): Completable {
        return movieCache.clearAllMovies()
    }

    override fun clearMoviesNowPlaying(): Completable {
        return movieCache.clearMoviesNowPlaying()
    }

    override fun saveMoviesNowPlaying(moviesNowPlayingDataEntities: List<MovieNowPlayingDataEntity>): Completable {
        return movieCache.saveMoviesNowPlaying(moviesNowPlayingDataEntities)
    }

    override fun saveMovieNowPlaying(movieNowPlayingDataEntity: MovieNowPlayingDataEntity): Completable {
        return movieCache.saveMovieNowPlaying(movieNowPlayingDataEntity)
    }

    override fun getMoviesNowPlaying(page: Int, language: String): Single<List<MovieNowPlayingDataEntity>> {
        return movieCache.getMoviesNowPlaying()
    }

    override fun getMovieNowPlaying(id: Long): Single<MovieNowPlayingDataEntity> {
        return movieCache.getMovieNowPlaying(id)
    }

    // TODO: implement the isCached, checking the database for cached items
    override fun isCached(): Boolean {
        return false
    }

    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.setLastCache(lastCache)
    }

    override fun setLastCacheTimeMoviesNowPlaying(lastCache: Long) {
        movieCache.setLastCache(lastCache)
    }

    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    private fun getLastCacheUpdateTimeMillis() = preferencesHelper.getLastCache()

    override fun getFirstStart(): Boolean {
        return preferencesHelper.getFirstStart()
    }

    override fun setFirstStart(setFirstStart: Boolean) {
        preferencesHelper.setFirstStart(setFirstStart)
    }
}