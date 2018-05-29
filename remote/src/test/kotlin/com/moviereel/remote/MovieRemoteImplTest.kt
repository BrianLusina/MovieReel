package com.moviereel.remote

import com.moviereel.data.models.movies.MovieNowPlayingDataEntity
import com.moviereel.remote.api.ApiService
import com.moviereel.remote.factory.MovieFactory
import com.moviereel.remote.mapper.movies.MovieNowPlayingRemoteMapper
import com.moviereel.remote.models.movie.MovieNowPlayingApiResponse
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MovieRemoteImplTest {

    @Mock private lateinit var mockMovieNowPlayingRemoteMapper : MovieNowPlayingRemoteMapper
    @Mock private lateinit var mockApiService: ApiService
    private lateinit var movieRemoteImpl: MovieRemoteImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieRemoteImpl = MovieRemoteImpl(mockApiService, mockMovieNowPlayingRemoteMapper)
    }

    @Test
    fun getMoviesNowPlayingCompletes() {
        val movieNowPlayingResponses = MovieFactory.makeMovieNowPlayingResponseCollection().toList()
        stubApiServiceGetMoviesNowPlaying(Single.just(movieNowPlayingResponses))
        val testObserver = movieRemoteImpl.getMoviesNowPlaying(1, "eng").test()
        testObserver.assertComplete()
    }

    @Test
    fun getMoviesNowPlayingReturnsData() {
        val movieNowPlayingApiResponses = MovieFactory.makeMovieNowPlayingResponseCollection().toList()
        stubApiServiceGetMoviesNowPlaying(Single.just(movieNowPlayingApiResponses))

        val movieNowPlayingDataEntities = mutableListOf<MovieNowPlayingDataEntity>()

        mockMovieNowPlayingRemoteMapper.mapResponseListFromRemote(movieNowPlayingApiResponses)
                .forEach {
                    movieNowPlayingDataEntities.add(it)
                }

        val testObserver = movieRemoteImpl.getMoviesNowPlaying(1, "eng").test()
        testObserver.assertValue(movieNowPlayingDataEntities)
    }

    private fun stubApiServiceGetMoviesNowPlaying(single: Single<List<MovieNowPlayingApiResponse>>,
                                                  language: String = "eng", page: Int = 1) {
        whenever(mockApiService.getMoviesNowPlaying(language, page))
                .thenReturn(single)
    }
}