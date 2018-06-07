package com.moviereel.presentation.view.intro

import com.moviereel.domain.DomainManager
import com.moviereel.presentation.view.splash.SplashPresenter
import com.moviereel.presentation.view.splash.SplashPresenterImpl
import com.moviereel.presentation.view.splash.SplashView
import org.junit.After
import org.junit.Before
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

    @Mock lateinit var mockSplashView: SplashView
    @Mock lateinit var mockDomainManager: DomainManager
    lateinit var splashPresenter: SplashPresenter<SplashView>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        splashPresenter = SplashPresenterImpl(mockDomainManager)
        splashPresenter.onAttach(mockSplashView)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        splashPresenter.onDetach()
    }

    @Test
    fun testSplashScreenShouldOpenIntroActivityOnFirstStart() {
        verify<SplashView>(mockSplashView).openMainActivity()
    }

    @Test
    fun testSplashScreenShouldOpenMainActivityOnSecondStart() {
        mockSplashView.openAppIntroductionActivity()

        verify<SplashView>(mockSplashView).openMainActivity()
    }

    @Test
    fun testSplashScreenStartsSyncService() {
        verify<SplashView>(mockSplashView).startSyncService()
    }
}