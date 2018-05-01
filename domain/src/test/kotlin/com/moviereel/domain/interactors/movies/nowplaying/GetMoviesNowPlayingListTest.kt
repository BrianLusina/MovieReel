package com.moviereel.domain.interactors.movies.nowplaying

import com.moviereel.domain.executor.PostExecutionThread
import com.moviereel.domain.executor.ThreadExecutor
import com.moviereel.domain.factory.MovieDataFactory
import com.moviereel.domain.models.movies.MovieNowPlayingModel
import com.moviereel.domain.repositories.MoviesRepository
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Flowable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMoviesNowPlayingListTest {

    private lateinit var getMoviesNpList: GetMoviesNowPlayingList
    private var page = 1
    private var language = "en-US"

    @Mock lateinit var mockThreadExecutor: ThreadExecutor
    @Mock lateinit var mockPostExecutionThread: PostExecutionThread
    @Mock lateinit var mockMoviesRepository: MoviesRepository

    private fun stubMoviesRepositoryGetMoviesNowPlaying(flowable: Flowable<List<MovieNowPlayingModel>>) {
        whenever(mockMoviesRepository.getMoviesNowPlayingList(page, language))
                .thenReturn(flowable)
    }
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getMoviesNpList = GetMoviesNowPlayingList(mockMoviesRepository, mockThreadExecutor, mockPostExecutionThread)
        // Unnecessary Mockito stubbing
        // given(mockPostExecutionThread.scheduler).willReturn(TestScheduler())
    }

    @Test
    fun testUseCaseSingleCallsRepository(){
        stubMoviesRepositoryGetMoviesNowPlaying(Flowable.just(MovieDataFactory.makeMoviesNowPlayingList(2)))
        val params = GetMoviesNowPlayingList.Params.forMovies(page, language)
        getMoviesNpList.buildUseCaseSingle(params)
        verify(mockMoviesRepository).getMoviesNowPlayingList(page, language)
    }

    @Test
    fun buildUseCaseSingleCompletes() {
        stubMoviesRepositoryGetMoviesNowPlaying(Flowable.just(MovieDataFactory.makeMoviesNowPlayingList(2)))
        val testObserver = getMoviesNpList.buildUseCaseSingle(null).test()
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseSingleReturnsData() {
        val moviesNowPlaying = MovieDataFactory.makeMoviesNowPlayingList(2)
        stubMoviesRepositoryGetMoviesNowPlaying(Flowable.just(moviesNowPlaying))
        val testObserver = getMoviesNpList.buildUseCaseSingle(null).test()
        testObserver.assertValue(moviesNowPlaying)
    }

}