package com.moviereel.data.source.movies

import com.moviereel.data.source.movies.repo.MovieCache
import com.moviereel.data.source.movies.stores.MovieCacheDataStore
import com.moviereel.data.source.movies.stores.MovieDataStore
import com.moviereel.data.source.movies.stores.MovieRemoteDataStore
import javax.inject.Inject

/**
 * @author lusinabrian on 02/05/18.
 * @Notes Factory that creates different implementations of [MovieDataStore]
 */
open class MovieDataStoreFactory @Inject constructor(
        private val cache: MovieCache,
        private val cacheDataStore: MovieCacheDataStore,
        private val remoteDataStore: MovieRemoteDataStore
) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): MovieDataStore {
        if (cache.isCached() && !cache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveCacheDataStore(): MovieDataStore {
        return cacheDataStore
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveRemoteDataStore(): MovieDataStore {
        return remoteDataStore
    }
}