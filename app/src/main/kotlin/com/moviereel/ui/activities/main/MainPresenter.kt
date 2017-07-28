package com.moviereel.ui.activities.main

import com.moviereel.di.PerActivity
import com.moviereel.ui.base.BasePresenter

/**
 * @author lusinabrian on 12/04/17
 */

@PerActivity
interface MainPresenter<in V : MainView> : BasePresenter<V> {

    /**
     * Callback for when the now playing movies drawer option is clicked
     */
    fun onDrawerOptionNowPlayingMoviesClicked()

    /**
     * Callback for when popular movies drawer option is clicked
     */
    fun onDrawerOptionPopularMoviesClicked()

    /**
     * Callback for when top rated movies is clicked
     */
    fun onDrawerOptionTopRatedMoviesClicked()

    /**
     * Callback for when upcoming movies drawer option is clicked
     */
    fun onDrawerOptionUpcomingMoviesClicked()

    /**
     * Callback for when the latest series drawer option is clicked
     */
    fun onDrawerOptionLatestSeriesClicked()

    /**
     * Callback for when the series on the air drawer option is clicked
     */
    fun onDrawerOptionOnTheAirSeriesClicked()

    /**
     * Callback for airing today drawer option is clicked
     */
    fun onDrawerOptionAiringTodaySeriesClicked()

    /**
     * Drawer option callback for when the top rated series option is clicked
     */
    fun onDrawerOptionTopRatedSeriesClicked()

    /**
     * Callback for when the popular series drawer options is clicked
     */
    fun onDrawerOptionPopularSeriesClicked()

    /**
     * Callback for when the help drawer option is clicked
     */
    fun onDrawerOptionHelpClicked()

    /**
     * Callback to display the settings screen option is clicked
     */
    fun onDrawerOptionSettingsClicked()

    /**
     * Callback that is responsible for displaying the about screen/fragment
     */
    fun onDrawerOptionAboutClicked()
}
