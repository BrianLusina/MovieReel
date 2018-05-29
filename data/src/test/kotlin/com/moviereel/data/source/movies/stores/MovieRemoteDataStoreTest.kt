package com.moviereel.data.source.movies.stores

import com.moviereel.data.factory.MovieDataFactory
import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.data.source.movies.repo.MovieRemote
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MovieRemoteDataStoreTest {

    private fun stubMovieRemoteGetMoviesNowPlaying(page: Int, lang: String,single: Single<List<MovieNowPlayingDataEntity>>) {
        whenever(movieRemote.getMoviesNowPlaying(page, lang))
                .thenReturn(single)
    }

    private lateinit var movieRemoteDataStore: MovieRemoteDataStore
    @Mock lateinit var movieRemote: MovieRemote

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieRemoteDataStore = MovieRemoteDataStore(movieRemote)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveMovieNowPlaying() {
        movieRemoteDataStore.saveMovieNowPlaying(MovieDataFactory.makeMovieNowPlayingEntity()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearMoviesNowPlaying() {
        movieRemoteDataStore.clearMoviesNowPlaying().test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearAllMovies() {
        movieRemoteDataStore.clearAllMovies().test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveMoviesNowPlaying() {
        movieRemoteDataStore.saveMoviesNowPlaying(MovieDataFactory.makeMoviesNowPlayingEntityList(4))
    }

    @Test
    fun getMoviesNowPlaying() {
        val page = 1
        val lang = "eng"
        stubMovieRemoteGetMoviesNowPlaying(page, lang, Single.just(MovieDataFactory.makeMoviesNowPlayingEntityList(3)))
        val testObserver = movieRemoteDataStore.getMoviesNowPlaying(page, lang).test()
        testObserver.assertComplete()
    }

}