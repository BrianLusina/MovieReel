package com.moviereel.data.repositories

import com.moviereel.data.source.movies.MovieDataStoreFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.FilterFactory
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MovieDataRepositoryImplTest {

    private lateinit var movieDataRepositoryImpl : MovieDataRepositoryImpl

    @Mock lateinit var factory: MovieDataStoreFactory

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun clearAllMovies() {
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