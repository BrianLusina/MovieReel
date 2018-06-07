package com.moviereel.presentation.view.main

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
 * * Tests for [MainPresenterImpl]. Checks if the methods set out are actually being called
 */

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTests {
    @Mock lateinit var mockMainView: MainView
    lateinit var mainPresenter: MainPresenter<MainView>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val compositeDisposable = CompositeDisposable()
        mainPresenter = MainPresenterImpl()
        mainPresenter.onAttach(mockMainView)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        mainPresenter.onDetach()
    }

    @Test
    fun testShouldDisplayNowPlayingMoviesFragment() {
        mockMainView.showMoviesFragment()

        verify<MainView>(mockMainView).showMoviesFragment()
    }

    @Test
    fun testShouldShowLatestSeriesFragment() {
        mockMainView.showLatestSeriesFragment()

        verify<MainView>(mockMainView).showLatestSeriesFragment()
    }

    @Test
    fun testShouldShowOnTheAirSeriesFragment() {
        mockMainView.showOnTheAirSeriesFragment()

        verify<MainView>(mockMainView).showOnTheAirSeriesFragment()
    }

    @Test
    fun testShouldShowAiringTodaySeriesFragment() {
        mockMainView.showAiringTodaySeriesFragment()

        verify<MainView>(mockMainView).showAiringTodaySeriesFragment()
    }

    @Test
    fun testShouldShowTopRatedSeriesFragment() {
        mockMainView.showTopRatedSeriesFragment()

        verify<MainView>(mockMainView).showTopRatedSeriesFragment()
    }

    @Test
    fun testShouldShowPopularSeriesFragment() {
        mockMainView.showPopularSeriesFragment()

        verify<MainView>(mockMainView).showPopularSeriesFragment()
    }

    @Test
    fun testShouldShowHelpSection() {
        mockMainView.showHelpSection()

        verify<MainView>(mockMainView).showHelpSection()
    }

    @Test
    fun testShouldShowSettingsScreen() {
        mockMainView.showSettingsScreen()

        verify<MainView>(mockMainView).showSettingsScreen()
    }

    @Test
    fun testShouldShowAboutFragment() {
        mockMainView.showAboutFragment()

        verify<MainView>(mockMainView).showAboutFragment()
    }
}
