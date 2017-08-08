package com.moviereel.ui.main

import android.support.design.widget.Snackbar

import com.moviereel.R
import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable

/**
 * @author lusinabrian on 12/04/17
 */

class MainPresenterImpl<V : MainView>
@Inject
constructor(
        mDataManager: DataManager,
        schedulerProvider: SchedulerProvider,
        mCompositeDisposable: CompositeDisposable)
    : BasePresenterImpl<V>(mDataManager, schedulerProvider, mCompositeDisposable), MainPresenter<V> {

    /**
     * When the view is first attached, check if the device is online
     * Display a snack bar to notify the user that they are offline
     */
    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)

        // if not online, display snack bar
        if (!baseView!!.isNetworkConnected) {
            baseView?.showNetworkErrorSnackbar(R.string.snackbar_warning_no_internet_conn, Snackbar.LENGTH_INDEFINITE)
        }
    }

    override fun onDetach() {

    }

    /**
     * Callback for when the now playing movies drawer option is clicked
     */
    override fun onDrawerOptionNowPlayingMoviesClicked() {
        baseView?.showNowPlayingMoviesFragment()
    }

    /**
     * Callback for when popular movies drawer option is clicked
     */
    override fun onDrawerOptionPopularMoviesClicked() {
        baseView?.showPopularMoviesFragment()
    }

    /**
     * Callback for when top rated movies is clicked
     */
    override fun onDrawerOptionTopRatedMoviesClicked() {
        baseView?.showTopRatedMoviesFragment()
    }

    /**
     * Callback for when upcoming movies drawer option is clicked
     */
    override fun onDrawerOptionUpcomingMoviesClicked() {
        baseView?.showUpcomingMoviesFragment()
    }

    /**
     * Callback for when the latest series drawer option is clicked
     */
    override fun onDrawerOptionLatestSeriesClicked() {
        baseView?.showLatestSeriesFragment()
    }

    /**
     * Callback for when the series on the air drawer option is clicked
     */
    override fun onDrawerOptionOnTheAirSeriesClicked() {
        baseView?.showOnTheAirSeriesFragment()
    }

    /**
     * Callback for airing today drawer option is clicked
     */
    override fun onDrawerOptionAiringTodaySeriesClicked() {
        baseView?.showAiringTodaySeriesFragment()
    }

    /**
     * Drawer option callback for when the top rated series option is clicked
     */
    override fun onDrawerOptionTopRatedSeriesClicked() {
        baseView?.showTopRatedSeriesFragment()
    }

    /**
     * Callback for when the popular series drawer options is clicked
     */
    override fun onDrawerOptionPopularSeriesClicked() {
        baseView?.showPopularSeriesFragment()
    }

    /**
     * Callback for when the help drawer option is clicked
     */
    override fun onDrawerOptionHelpClicked() {
        baseView?.showHelpSection()
    }

    /**
     * Callback to display the settings screen option is clicked
     */
    override fun onDrawerOptionSettingsClicked() {
        baseView?.showSettingsScreen()
    }

    /**
     * Callback that is responsible for displaying the about screen/fragment
     */
    override fun onDrawerOptionAboutClicked() {
        baseView?.showAboutFragment()
    }
}
