package com.moviereel.presentation.view.movie.nowplaying

import com.moviereel.domain.interactors.movies.nowplaying.GetMoviesNowPlayingList
import com.moviereel.domain.models.movies.MovieNowPlayingDomainModel
import com.moviereel.presentation.factory.MovieDataFactory
import com.moviereel.presentation.factory.randomIntNumber
import com.moviereel.presentation.factory.randomOriginalLang
import com.moviereel.presentation.mapper.movies.NowPlayingPresenterMapper
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenter
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingPresenterImpl
import com.moviereel.presentation.view.entertain.movie.nowplaying.NowPlayingView
import com.nhaarman.mockito_kotlin.KArgumentCaptor
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import io.reactivex.observers.DisposableSingleObserver
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

    private lateinit var nowPlayingPresenter: NowPlayingPresenter<NowPlayingView>
    private lateinit var captor: KArgumentCaptor<DisposableSingleObserver<List<MovieNowPlayingDomainModel>>>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        captor = argumentCaptor()
        MockitoAnnotations.initMocks(this)
        nowPlayingPresenter = NowPlayingPresenterImpl(mockGetMoviesNowPlaying, mockMoviesMapper)
        nowPlayingPresenter.onAttach(mockNowPlayingView)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        nowPlayingPresenter.onDetach()
    }

    @Test
    fun testRetrieveMoviesNowPlayingUpdatesList(){
        val page = randomIntNumber()
        val lang = randomOriginalLang()
        val moviesNowPlaying = MovieDataFactory.makeMoviesNowPlayingList(5)

        nowPlayingPresenter.getMoviesNowPlaying(page, lang)

        verify(mockGetMoviesNowPlaying).execute(captor.capture(), eq(GetMoviesNowPlayingList.Params(page, lang)))
        captor.firstValue.onSuccess(moviesNowPlaying)
        verify(mockNowPlayingView).updateMoviesNowPlaying(
                moviesNowPlaying.map {
                    mockMoviesMapper.mapToView(it)
                }
        )
        verify(mockNowPlayingView).stopSwipeRefresh()
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
