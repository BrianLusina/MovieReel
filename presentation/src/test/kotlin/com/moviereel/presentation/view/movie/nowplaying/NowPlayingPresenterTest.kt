package com.moviereel.presentation.view.movie.nowplaying

import com.moviereel.domain.interactors.movies.nowplaying.GetMoviesNowPlayingList
import com.moviereel.presentation.mapper.movies.NowPlayingPresenterMapper
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenter
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenterImpl
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author lusinabrian on 19/04/17.
 */
@RunWith(MockitoJUnitRunner::class)
class NowPlayingPresenterTest {

    @Mock lateinit var mockNowPlayingView: NowPlayingView
    @Mock lateinit var mockGetMoviesNowPlaying : GetMoviesNowPlayingList
    @Mock lateinit var mockMoviesMapper : NowPlayingPresenterMapper

    lateinit var nowPlayingPresenter: NowPlayingPresenter<NowPlayingView>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        nowPlayingPresenter = NowPlayingPresenterImpl(mockGetMoviesNowPlaying, mockMoviesMapper)
        nowPlayingPresenter.onAttach(mockNowPlayingView)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        nowPlayingPresenter.onDetach()
    }

    /**
     * Test that the API error snackbar is called upon, should there be an error
     */
    @Test
    fun testShouldDisplayApiErrorSnackBar() {
        mockNowPlayingView.showApiErrorSnackbar()

        verify<NowPlayingView>(mockNowPlayingView).showApiErrorSnackbar()
    }
}
