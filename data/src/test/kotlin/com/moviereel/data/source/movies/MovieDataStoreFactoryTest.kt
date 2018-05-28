package com.moviereel.data.source.movies

import com.moviereel.data.source.movies.repo.MovieCache
import com.moviereel.data.source.movies.stores.MovieCacheDataStore
import com.moviereel.data.source.movies.stores.MovieRemoteDataStore
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MovieDataStoreFactoryTest {

    private lateinit var movieDataStoreFactory: MovieDataStoreFactory
    @Mock lateinit var movieCache: MovieCache
    @Mock lateinit var movieCacheDataStore: MovieCacheDataStore
    @Mock lateinit var movieCacheRemoteDataStore: MovieRemoteDataStore

    private fun stubMovieCacheIsCached(isCached: Boolean) {
        whenever(movieCache.isCached())
                .thenReturn(isCached)
    }

    private fun stubMovieCacheIsExpired(isExpired: Boolean) {
        whenever(movieCache.isExpired())
                .thenReturn(isExpired)
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieDataStoreFactory = MovieDataStoreFactory(movieCache, movieCacheDataStore, movieCacheRemoteDataStore)
    }

    @Test
    fun retrieveDataStoreWhenNotCachedReturnsRemoteDataStore() {
        stubMovieCacheIsCached(false)
        val dataStore = movieDataStoreFactory.retrieveDataStore()
        assert(dataStore is MovieRemoteDataStore)
    }

    @Test
    fun retrieveDataStoreWhenCacheExpiredReturnsRemoteDataStore() {
        stubMovieCacheIsExpired(true)
        stubMovieCacheIsCached(true)
        val dataStore = movieDataStoreFactory.retrieveDataStore()
        assert(dataStore is MovieRemoteDataStore)
    }

    @Test
    fun retrieveCacheDataStoreReturnsCacheDataStore() {
        stubMovieCacheIsCached(true)
        stubMovieCacheIsExpired(false)
        val dataStore = movieDataStoreFactory.retrieveDataStore()
        assert(dataStore is MovieCacheDataStore)
    }

    @Test
    fun retrieveCacheDataStore() {
        val dataStore = movieDataStoreFactory.retrieveCacheDataStore()
        assert(dataStore is MovieCacheDataStore)
    }

    @Test
    fun retrieveRemoteDataStore() {
        val dataStore = movieDataStoreFactory.retrieveRemoteDataStore()
        assert(dataStore is MovieRemoteDataStore)
    }
}