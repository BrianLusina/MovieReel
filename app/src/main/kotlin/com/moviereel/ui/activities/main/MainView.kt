package com.moviereel.ui.activities.main

import com.moviereel.ui.base.BaseView

/**
 * @author lusinabrian on 12/04/17
 */

interface MainView : BaseView {

    // MOVIE
    /**
     * Shows the movies that are now playing
     */
    fun showNowPlayingMoviesFragment()

    /**
     * Fragment Show the shows that are most popular
     */
    fun showPopularMoviesFragment()

    /**
     * Fragment to show the movies that are top rated
     */
    fun showTopRatedMoviesFragment()

    /**
     * Fragment to show upcoming movies
     */
    fun showUpcomingMoviesFragment()

    // TV

    /**
     * Show the series that are the latest
     */
    fun showLatestSeriesFragment()

    /**
     * Show the tv series that are on the air currently
     */
    fun showOnTheAirSeriesFragment()

    /**
     * Display the tv series that are airing today
     */
    fun showAiringTodaySeriesFragment()

    /**
     * Display the top rated series
     */
    fun showTopRatedSeriesFragment()

    /**
     * Displays the popular series fragment
     */
    fun showPopularSeriesFragment()

    /**
     * Display a help section
     */
    fun showHelpSection()

    /**
     * Displays the setting screen */
    fun showSettingsScreen()

    /**
     * displays an about fragment
     */
    fun showAboutFragment()
}
