package com.moviereel.data.source.movies.stores

import com.moviereel.data.factory.MovieDataFactory
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.data.source.movies.repo.MovieLocalRepo
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
class MovieCacheDataStoreTest {
    private lateinit var movieCacheDataStore: MovieCacheDataStore
    @Mock lateinit var movieLocalRepo: MovieLocalRepo

    private fun stubMovieCacheSaveMoviesNowPlaying(completable: Completable) {
        whenever(movieLocalRepo.saveMoviesNowPlaying(any()))
                .thenReturn(completable)
    }

    private fun stubMovieCacheSaveMovieNowPlaying(completable: Completable){
        whenever(movieLocalRepo.saveMovieNowPlaying(any()))
                .thenReturn(completable)
    }

    private fun stubMovieCacheGetMoviesNowPlaying(page : Int, language: String,
                                                  single: Single<List<MovieNowPlayingDataEntity>>) {
        whenever(movieLocalRepo.getMoviesNowPlaying(page, language))
                .thenReturn(single)
    }

    private fun stubMovieCacheGetMovieNowPlaying(id: Long, single: Single<MovieNowPlayingDataEntity>){
        whenever(movieLocalRepo.getMovieNowPlaying(id)).thenReturn(single)
    }

    private fun stubMovieCacheClearMoviesNowPlaying(completable: Completable) {
        whenever(movieLocalRepo.clearMoviesNowPlaying())
                .thenReturn(completable)
    }

    private fun stubMovieCacheClearAllMovies(completable: Completable){
        whenever(movieLocalRepo.clearAllMovies())
                .thenReturn(completable)
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieCacheDataStore = MovieCacheDataStore(movieLocalRepo)
    }

    @Test
    fun saveMovieNowPlayingCompletes() {
        stubMovieCacheSaveMovieNowPlaying(Completable.complete())
        val testObserver = movieCacheDataStore.saveMovieNowPlaying(
                MovieDataFactory.makeMovieNowPlayingEntity()
        ).test()
        testObserver.assertComplete()
    }

    @Test
    fun clearAllMoviesCompletes() {
        stubMovieCacheClearAllMovies(Completable.complete())
        val testObserver = movieCacheDataStore.clearAllMovies().test()
        testObserver.assertComplete()
    }

    @Test
    fun saveMoviesNowPlayingCompletes() {
        stubMovieCacheSaveMoviesNowPlaying(Completable.complete())
        val testObserver = movieCacheDataStore.saveMoviesNowPlaying(
                MovieDataFactory.makeMoviesNowPlayingEntityList(5)
        ).test()
        testObserver.assertComplete()
    }

    @Test
    fun clearMoviesNowPlaying() {
        stubMovieCacheClearMoviesNowPlaying(Completable.complete())
        val testObserver = movieCacheDataStore.clearMoviesNowPlaying().test()
        testObserver.assertComplete()
    }

    @Test
    fun getMoviesNowPlayingCompletes() {
        val page = 1
        val lang = "eng"
        stubMovieCacheGetMoviesNowPlaying(page, lang,
                Single.just(MovieDataFactory.makeMoviesNowPlayingEntityList(3))
        )
        val testObserver = movieCacheDataStore.getMoviesNowPlaying(page, lang).test()
        testObserver.assertComplete()
    }

    @Test
    fun getMovieNowPlaying() {
        val id = 8L
        stubMovieCacheGetMovieNowPlaying(id, Single.just(MovieDataFactory.makeMovieNowPlayingEntity()))
        val testObserver = movieCacheDataStore.getMovieNowPlaying(id).test()
        testObserver.assertComplete()
    }
}