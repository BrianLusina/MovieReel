package com.moviereel.ui.movie.nowplaying

import android.support.annotation.StringRes
import com.moviereel.data.api.model.BaseResultsResponse

import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.ui.base.BaseView

/**
 * MovieReel
 * com.moviereel.com.moviereel.ui.fragments.movienowplaying
 * Created by lusinabrian on 26/10/16.
 * Description: View Interface for [MovieNPFragment]
 */

interface MovieNPView : BaseView {

    /**
     * Show API Error snackbar. this will display an error message on the snackbar in case
     * the API call has encountered an issue and can prompt user to retry connection
     * @param length how long to display this snackbar
     * *
     * @param message message to display to user about this error
     * *
     * @param actionMessage the message to display on the action button
     */
    fun showApiErrorSnackbar(message: String, actionMessage: String, length: Int)

    /**
     * Override of [.showApiErrorSnackbar]
     */
    fun showApiErrorSnackbar(@StringRes resId: Int, @StringRes actionId: Int, length: Int)

    /**In case of any error, display a message to the user
     * @param message The message to display to the user
     * *
     * @param messageType The message type to display, whether an error or informative
     */
    fun displayToast(message: String, messageType: Int)

    /**picks the data of the item clicked in the RecyclerView
     * start activity for the clicked movie item */
    fun startActivityForClickedItem(bundleKey: String, movieList: List<MovieNPEntity>)

    fun onRecyclerItemClicked(bundleKey: String, movieList: List<MovieNPEntity>)

    /**
     * Sets adapter for the recycler view
     * @param movieResultsResponseList data to use to update movie list
     * *
     */
    fun updateMoviesNowPlaying(movieResultsResponseList: List<BaseResultsResponse.MovieResultsResponse>)
}
