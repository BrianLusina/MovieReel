package com.moviereel.data.repositories

import com.moviereel.data.mapper.movies.MovieNowPlayingMapper
import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.data.source.movies.MovieDataStoreFactory
import com.moviereel.data.source.movies.stores.MovieCacheDataStore
import com.moviereel.data.source.movies.stores.MovieDataStore
import com.moviereel.data.source.movies.stores.MovieRemoteDataStore
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MovieDataRepositoryImplTest {

    private lateinit var movieDataRepositoryImpl : MovieDataRepositoryImpl

    @Mock lateinit var factory: MovieDataStoreFactory
    @Mock lateinit var movieNowPlayingMapper :MovieNowPlayingMapper
    @Mock lateinit var movieCacheDataStore: MovieCacheDataStore
    @Mock lateinit var movieRemoteDataStore: MovieRemoteDataStore

    private fun stubMovieCacheSaveMoviesNowPlaying(completable: Completable) {
        whenever(movieCacheDataStore.saveMoviesNowPlaying(any()))
                .thenReturn(completable)
    }

    private fun stubMovieCacheSaveMovieNowPlaying(completable: Completable) {
        whenever(movieCacheDataStore.saveMovieNowPlaying(any()))
                .thenReturn(completable)
    }

    private fun stubMovieCacheDataStoreGetMoviesNowPlaying(page: Int, lang:String,
                                                           single: Single<List<MovieNowPlayingEntity>>) {
        whenever(movieCacheDataStore.getMoviesNowPlaying(page, lang))
                .thenReturn(single)
    }

    private fun stubMovieCacheDataStoreGetMovieNowPlaying(id: Long, single: Single<MovieNowPlayingEntity>) {
        whenever(movieCacheDataStore.getMovieNowPlaying(id))
                .thenReturn(single)
    }

    private fun stubMovieRemoteDataStoreGetMoviesNowPlaying(page : Int, lang: String,
                                                            single: Single<List<MovieNowPlayingEntity>>) {
        whenever(movieRemoteDataStore.getMoviesNowPlaying(page, lang))
                .thenReturn(single)
    }

    private fun stubMovieRemoteDataStoreGetMovieNowPlaying(id : Long, single: Single<MovieNowPlayingEntity>) {
        whenever(movieRemoteDataStore.getMovieNowPlaying(id))
                .thenReturn(single)
    }

    private fun stubMovieCacheClearAllMovies(completable: Completable) {
        whenever(movieCacheDataStore.clearAllMovies())
                .thenReturn(completable)
    }

    private fun stubMovieCacheClearAllMoviesNowPlaying(completable: Completable) {
        whenever(movieCacheDataStore.clearMoviesNowPlaying())
                .thenReturn(completable)
    }

    private fun stubMovieDataStoreFactoryRetrieveCacheDataStore() {
        whenever(factory.retrieveCacheDataStore())
                .thenReturn(movieCacheDataStore)
    }

    private fun stubMovieDataStoreFactoryRetrieveRemoteDataStore() {
        whenever(factory.retrieveRemoteDataStore())
                .thenReturn(movieRemoteDataStore)
    }

    private fun stubMovieDataStoreFactoryRetrieveDataStore(dataStore: MovieDataStore) {
        whenever(factory.retrieveDataStore())
                .thenReturn(dataStore)
    }

    private fun stubMovieMapperMapFromEntity(movieNowPlayingEntity: MovieNowPlayingEntity,
                                             movieNowPlayingModel: MovieNowPlayingModel) {
        whenever(movieNowPlayingMapper.mapFromEntity(movieNowPlayingEntity))
                .thenReturn(movieNowPlayingModel)
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieDataRepositoryImpl = MovieDataRepositoryImpl(factory, movieNowPlayingMapper)
        stubMovieDataStoreFactoryRetrieveCacheDataStore()
        stubMovieDataStoreFactoryRetrieveRemoteDataStore()
    }

    @Test
    fun clearAllMoviesCompletes() {
        stubMovieCacheClearAllMovies(Completable.complete())
        val testObserver = movieDataRepositoryImpl.clearAllMovies().test()
        testObserver.assertComplete()
    }

    @Test
    fun saveMoviesNowPlaying() {

    }

    @Test
    fun clearMoviesNowPlaying() {
    }

    @Test
    fun getMoviesNowPlayingList() {
    }

    @Test
    fun getMovieNowPlaying() {
    }

    @Test
    fun getMoviesLatest() {
    }

    @Test
    fun getMoviesPopular() {
    }

    @Test
    fun getMoviesTopRated() {
    }

    @Test
    fun getMoviesUpcoming() {
    }

    @Test
    fun getFactory() {
    }

    @Test
    fun getMovieNowPlayingMapper() {
    }
}