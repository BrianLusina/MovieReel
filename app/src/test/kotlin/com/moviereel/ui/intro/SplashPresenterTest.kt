package com.moviereel.ui.intro

import com.moviereel.TestSchedulerProvider
import com.moviereel.data.DataManager
import com.moviereel.ui.intro.splash.SplashPresenter
import com.moviereel.ui.intro.splash.SplashPresenterImpl
import com.moviereel.ui.intro.splash.SplashView
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
 * @author lusinabrian
 */
@RunWith(MockitoJUnitRunner::class)
class SplashPresenterTest {

    @Mock lateinit var mMockSplashView: SplashView
    @Mock lateinit var mMockDataManager: DataManager
    lateinit var mTestScheduler: TestScheduler

    lateinit var mSplashPresenter: SplashPresenter<SplashView>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val compositeDisposable = CompositeDisposable()
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)

        mSplashPresenter = SplashPresenterImpl(mMockDataManager, testSchedulerProvider, compositeDisposable)
        mSplashPresenter.onAttach(mMockSplashView)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        RxAndroidPlugins.reset()
        mSplashPresenter.onDetach()
    }

    @Test
    fun testSplashScreenShouldOpenIntroActivityOnFirstStart() {
        verify<SplashView>(mMockSplashView).openMainActivity()
    }

    @Test
    fun testSplashScreenShouldOpenMainActivityOnSecondStart() {
        mMockSplashView.openAppIntroductionActivity()

        verify<SplashView>(mMockSplashView).openMainActivity()
    }

    @Test
    fun testSplashScreenStartsSyncService() {
        verify<SplashView>(mMockSplashView).startSyncService()
    }

    companion object {

        @BeforeClass
        @Throws(Exception::class)
        fun onlyOnce() {
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        }
    }
}