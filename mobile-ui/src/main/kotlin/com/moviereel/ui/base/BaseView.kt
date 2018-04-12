package com.moviereel.ui.base

import android.support.annotation.StringRes

/**
 * @author lusinabrian on 01/04/17
 * * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * * pattern must implement. Generally this interface will be extended by a more specific interface
 * * that then usually will be implemented by an Activity or Fragment.
 */

interface BaseView {

    /**
     * shows the connection error snackbar. If there is no connection to any internet connection
     * @param message message to displaye
     * *
     * @param length how long to display this message
     */
    fun showNetworkErrorSnackbar(message: String, length: Int)

    fun showNetworkErrorSnackbar(@StringRes message: Int, length: Int)

    /**
     * Checks if there is network connected
     * Returns True if the device is connected to a network, false otherwise
     * @return [Boolean]
     */
    val isNetworkConnected: Boolean

    /**
     * Hides keyboard */
    fun hideKeyboard()

    /**
     * Shows a snackbar if an error has been encountered
     * @param length how long the snack bar should be displayed
     * *
     * @param message the message to display in the snackbar
     */
    fun onErrorSnackBar(message: String, length: Int)

    /**
     * Override of [.onErrorSnackBar] */
    fun onErrorSnackBar(@StringRes resId: Int, length: Int)

}
