package com.moviereel.cache.movies

import com.moviereel.cache.movies.nowplaying.NowPlayingCacheMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MovieCacheImplTest {
    @Mock private lateinit var mockMovieNowPlayingMapper: NowPlayingCacheMapper
    private lateinit var movieCacheImpl: MovieCacheImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        // movieCacheImpl = MovieCacheImpl(mockMovieNowPlayingMapper, )
    }

    @Test
    fun clearAllMovies() {
    }

    @Test
    fun clearMoviesNowPlaying() {
    }

    @Test
    fun saveMoviesNowPlaying() {
    }

    @Test
    fun saveMovieNowPlaying() {
    }

    @Test
    fun getMoviesNowPlaying() {
    }

    @Test
    fun getMovieNowPlaying() {
    }
}