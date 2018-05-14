package com.moviereel.data.repositories

import com.moviereel.data.factory.DataFactory
import com.moviereel.data.factory.MovieDataFactory
import com.moviereel.data.mapper.movies.MovieNowPlayingMapper
import com.moviereel.data.models.movies.MovieNowPlayingEntity
import com.moviereel.data.source.movies.MovieDataStoreFactory
import com.moviereel.data.source.movies.stores.MovieCacheDataStore
import com.moviereel.data.source.movies.stores.MovieDataStore
import com.moviereel.data.source.movies.stores.MovieRemoteDataStore
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Ignore
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
        stubMovieCacheSaveMoviesNowPlaying(Completable.complete())
        val testObserver = movieDataRepositoryImpl.saveMoviesNowPlaying(MovieDataFactory.makeMoviesNowPlayingModelList(5)).test()
        testObserver.assertComplete()
    }

    @Test
    fun clearMoviesNowPlaying() {
        stubMovieCacheClearAllMoviesNowPlaying(Completable.complete())
        val testObserver = movieDataRepositoryImpl.clearMoviesNowPlaying().test()
        testObserver.assertComplete()
    }

    @Test
    fun getMoviesNowPlayingListFromRemoteCompletes() {
        val page = 1
        val lang = "eng"
        stubMovieDataStoreFactoryRetrieveDataStore(movieRemoteDataStore)
        stubMovieRemoteDataStoreGetMoviesNowPlaying(page, lang,
                Single.just(MovieDataFactory.makeMoviesNowPlayingEntityList(2)))
        val testObserver = movieDataRepositoryImpl.getMoviesNowPlayingList(page, lang).test()
        testObserver.assertComplete()
    }

    @Test
    fun getMoviesNowPlayingListFromCacheCompletes() {
        val page = 1
        val lang = "eng"
        stubMovieDataStoreFactoryRetrieveDataStore(movieCacheDataStore)
        stubMovieCacheDataStoreGetMoviesNowPlaying(page, lang,
                Single.just(MovieDataFactory.makeMoviesNowPlayingEntityList(2)))
        val testObserver = movieDataRepositoryImpl.getMoviesNowPlayingList(page, lang).test()
        testObserver.assertComplete()
    }

    @Test
    fun getMoviesNowPlayingListFromCacheReturnsData(){
        val page = 1
        val lang = "eng"
        stubMovieDataStoreFactoryRetrieveDataStore(movieCacheDataStore)
        val moviesNowPlayingModels = MovieDataFactory.makeMoviesNowPlayingModelList(5)
        val moviesNowPlayingEntities = MovieDataFactory.makeMoviesNowPlayingEntityList(5)

        moviesNowPlayingModels.forEachIndexed { index, movie ->
            stubMovieMapperMapFromEntity(moviesNowPlayingEntities[index], movie)
        }

        stubMovieCacheDataStoreGetMoviesNowPlaying(page, lang, Single.just(moviesNowPlayingEntities))
        val testObserver = movieDataRepositoryImpl.getMoviesNowPlayingList(page, lang).test()
        testObserver.assertValue(moviesNowPlayingModels)
    }

    @Test
    fun getMoviesNowPlayingListFromRemoteReturnsData(){
        val page = 1
        val lang = "eng"
        stubMovieDataStoreFactoryRetrieveDataStore(movieRemoteDataStore)
        val moviesNowPlayingModels = MovieDataFactory.makeMoviesNowPlayingModelList(5)
        val moviesNowPlayingEntities = MovieDataFactory.makeMoviesNowPlayingEntityList(5)

        moviesNowPlayingModels.forEachIndexed { index, movie ->
            stubMovieMapperMapFromEntity(moviesNowPlayingEntities[index], movie)
        }

        stubMovieRemoteDataStoreGetMoviesNowPlaying(page, lang, Single.just(moviesNowPlayingEntities))
        val testObserver = movieDataRepositoryImpl.getMoviesNowPlayingList(page, lang).test()
        testObserver.assertValue(moviesNowPlayingModels)
    }

    @Test
    fun getMoviesNowPlayingSavesWhenFromCacheDataStore(){
        stubMovieDataStoreFactoryRetrieveDataStore(movieCacheDataStore)
        stubMovieCacheSaveMoviesNowPlaying(Completable.complete())
        movieDataRepositoryImpl.saveMoviesNowPlaying(MovieDataFactory.makeMoviesNowPlayingModelList(3)).test()
        verify(movieCacheDataStore).saveMoviesNowPlaying(any())
    }

    @Test
    fun getMoviesNowPlayingNeverSavesWhenFromRemoteDataStore(){
        stubMovieDataStoreFactoryRetrieveDataStore(movieRemoteDataStore)
        stubMovieCacheSaveMoviesNowPlaying(Completable.complete())
        movieDataRepositoryImpl.saveMoviesNowPlaying(MovieDataFactory.makeMoviesNowPlayingModelList(3)).test()
        verify(movieRemoteDataStore, never()).saveMoviesNowPlaying(any())
    }

    @Test
    fun getMovieNowPlayingGetsMovieWhenFromCacheDataStore() {
        val id = DataFactory.randomId()
        stubMovieDataStoreFactoryRetrieveDataStore(movieCacheDataStore)
        stubMovieCacheDataStoreGetMovieNowPlaying(id, Single.just(MovieDataFactory.makeMovieNowPlayingEntity()))
        val testObserver = movieDataRepositoryImpl.getMovieNowPlaying(id).test()
        testObserver.assertComplete()
    }

    @Test
    fun getMovieNowPlayingGetsMovieWhenFromRemoteDataStore() {
        val id = DataFactory.randomId()
        stubMovieDataStoreFactoryRetrieveDataStore(movieRemoteDataStore)
        stubMovieRemoteDataStoreGetMovieNowPlaying(id, Single.just(MovieDataFactory.makeMovieNowPlayingEntity()))
        val testObserver = movieDataRepositoryImpl.getMovieNowPlaying(id).test()
        testObserver.assertComplete()
    }

    @Ignore
    @Test
    fun getMoviesLatest() {
    }

    @Ignore
    @Test
    fun getMoviesPopular() {
    }

    @Ignore
    @Test
    fun getMoviesTopRated() {
    }

    @Ignore
    @Test
    fun getMoviesUpcoming() {
    }
}