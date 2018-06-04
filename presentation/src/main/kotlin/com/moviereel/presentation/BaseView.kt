package com.moviereel.presentation

/**
 * @author lusinabrian on 04/06/18.
 * @Notes Interface class to act as a base for any class that is to take the role of the BaseView
 */
interface BaseView{

    /**
     * shows the connection error snackbar. If there is no connection to any internet connection
     * @param message message to displaye
     * @param length how long to display this message
     */
    fun showNetworkErrorSnackbar(message: String = "No Internet connection", length: Int = 0)

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
     * @param message the message to display in the snackbar
     */
    fun onErrorSnackBar(message: String, length: Int)
}