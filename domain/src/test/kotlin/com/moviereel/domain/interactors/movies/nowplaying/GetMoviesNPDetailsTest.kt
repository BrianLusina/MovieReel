package com.moviereel.domain.interactors.movies.nowplaying

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.moviereel.domain.factory.MovieDataFactory
import com.moviereel.domain.models.movies.MovieNowPlayingDomainModel
import com.moviereel.domain.repositories.MoviesDomainRepository
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMoviesNPDetailsTest {
    private lateinit var getMoviesNPDetails: GetMoviesNPDetails

    private var movieId = 3L

    @Mock
    lateinit var mockThreadExecutor: ThreadExecutor
    @Mock
    lateinit var mockPostExecutionThread: PostExecutionThread
    @Mock
    lateinit var mockMoviesDomainRepository: MoviesDomainRepository

    @Rule
    @JvmField
    var expectedException = ExpectedException.none()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMoviesNPDetails = GetMoviesNPDetails(mockMoviesDomainRepository, mockThreadExecutor, mockPostExecutionThread)
    }

    private fun stubMoviesRepositoryGetMoviesNowPlaying(flowable: Flowable<MovieNowPlayingDomainModel>) {
        whenever(mockMoviesDomainRepository.getMovieNowPlaying(movieId)).thenReturn(flowable)
    }

    @Test
    fun testBuildUseCaseSingleCompletes(){
        stubMoviesRepositoryGetMoviesNowPlaying(Flowable.just(MovieDataFactory.makeMovieNowPlaying()))

        getMoviesNPDetails.buildUseCaseSingle(GetMoviesNPDetails.Params.forMovies(movieId))
        verify(mockMoviesDomainRepository).getMovieNowPlaying(movieId)
        verifyNoMoreInteractions(mockMoviesDomainRepository)
        verifyZeroInteractions(mockPostExecutionThread)
        verifyZeroInteractions(mockThreadExecutor)
    }

    @Test
    fun testShouldFailWhenNoOrEmptyParameters() {
        expectedException.expect(NullPointerException::class.java)
        getMoviesNPDetails.buildUseCaseSingle(null)
    }
}