package com.moviereel.domain.interactors.movies.nowplaying

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.moviereel.domain.repositories.MoviesRepository
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMoviesNPDetailsTest {
    private lateinit var getMoviesNPDetails: GetMoviesNPDetails

    private var movieId = 3

    @Mock
    lateinit var mockThreadExecutor: ThreadExecutor
    @Mock
    lateinit var mockPostExecutionThread: PostExecutionThread
    @Mock
    lateinit var mockMoviesRepository: MoviesRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMoviesNPDetails = GetMoviesNPDetails(mockMoviesRepository, mockThreadExecutor, mockPostExecutionThread)
    }

    private fun stubMoviesRepositoryGetMoviesNowPlaying(flowable: Flowable<MovieNowPlayingModel>) {
        whenever(mockMoviesRepository.getMovieNowPlaying(movieId)).thenReturn(flowable)
    }

    @Test
    fun testBuildUseCaseSingleCompletes(){
        stubMoviesRepositoryGetMoviesNowPlaying(Flowable.just(MovieNowPlayingModel()))

        getMoviesNPDetails.buildUseCaseSingle(GetMoviesNPDetails.Params.forMovies(movieId))
        verify(mockMoviesRepository).getMovieNowPlaying(movieId)
        verifyNoMoreInteractions(mockMoviesRepository)
        verifyZeroInteractions(mockPostExecutionThread)
        verifyZeroInteractions(mockThreadExecutor)
    }

}