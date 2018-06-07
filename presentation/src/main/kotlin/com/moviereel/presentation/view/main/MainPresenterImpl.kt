package com.moviereel.presentation.view.main

import com.moviereel.presentation.view.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author lusinabrian on 12/04/17
 */

class MainPresenterImpl<V : MainView>
@Inject
constructor() : BasePresenterImpl<V>(), MainPresenter<V> {

    /**
     * When the view is first attached, check if the device is online
     * Display a snack bar to notify the user that they are offline
     */
    override fun onAttach(baseView: V) {
        super.onAttach(baseView)
        // if not online, display snack bar
        if (!baseView.isNetworkConnected) {
            baseView.showNetworkErrorSnackbar()
        }
    }

    override fun onDetach() {

    }

    /**
     * Callback for when the now playing movies drawer option is clicked
     */
    override fun onDrawerOptionMoviesClicked() {
        baseView.showMoviesFragment()
    }


    /**
     * Callback for when the latest series drawer option is clicked
     */
    override fun onDrawerOptionLatestSeriesClicked() {
        baseView.showLatestSeriesFragment()
    }

    /**
     * Callback for when the series on the air drawer option is clicked
     */
    override fun onDrawerOptionOnTheAirSeriesClicked() {
        baseView.showOnTheAirSeriesFragment()
    }

    /**
     * Callback for airing today drawer option is clicked
     */
    override fun onDrawerOptionAiringTodaySeriesClicked() {
        baseView.showAiringTodaySeriesFragment()
    }

    /**
     * Drawer option callback for when the top rated series option is clicked
     */
    override fun onDrawerOptionTopRatedSeriesClicked() {
        baseView.showTopRatedSeriesFragment()
    }

    /**
     * Callback for when the popular series drawer options is clicked
     */
    override fun onDrawerOptionPopularSeriesClicked() {
        baseView.showPopularSeriesFragment()
    }

    /**
     * Callback for when the help drawer option is clicked
     */
    override fun onDrawerOptionHelpClicked() {
        baseView.showHelpSection()
    }

    /**
     * Callback to display the settings screen option is clicked
     */
    override fun onDrawerOptionSettingsClicked() {
        baseView.showSettingsScreen()
    }

    /**
     * Callback that is responsible for displaying the about screen/fragment
     */
    override fun onDrawerOptionAboutClicked() {
        baseView.showAboutFragment()
    }
}
