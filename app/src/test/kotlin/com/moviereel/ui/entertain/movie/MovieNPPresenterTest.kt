package com.moviereel.ui.entertain.movie

import android.support.design.widget.Snackbar
import com.moviereel.R
import com.moviereel.TestSchedulerProvider
import com.moviereel.data.DataManager
import com.moviereel.ui.entertain.movie.nowplaying.MovieNPPresenter
import com.moviereel.ui.entertain.movie.nowplaying.MovieNPPresenterImpl
import com.moviereel.ui.entertain.movie.nowplaying.MovieNPView
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
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
class MovieNPPresenterTest {

    @Mock lateinit var mMockMovieNPView: MovieNPView
    lateinit var mTestScheduler: TestScheduler

    @Mock lateinit var mMockDataManager: DataManager

    lateinit var movieNPPresenter: MovieNPPresenter<MovieNPView>

    companion object {
        @BeforeClass
        @Throws(Exception::class)
        fun onlyOnce() {
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        }
    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val compositeDisposable = CompositeDisposable()
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        movieNPPresenter = MovieNPPresenterImpl(mMockDataManager,testSchedulerProvider, compositeDisposable)
        movieNPPresenter.onAttach(mMockMovieNPView)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        RxAndroidPlugins.reset()
        movieNPPresenter.onDetach()
    }

    /**
     * Test that the API error snackbar is called upon, should there be an error
     */
    @Test
    fun testShouldDisplayApiErrorSnackBar() {
        mMockMovieNPView.showApiErrorSnackbar(R.string.snackbar_api_error,
                R.string.snackbar_api_error_retry,
                Snackbar.LENGTH_SHORT)

        verify<MovieNPView>(mMockMovieNPView).showApiErrorSnackbar(R.string.snackbar_api_error,
                R.string.snackbar_api_error_retry,
                Snackbar.LENGTH_SHORT)
    }
}
