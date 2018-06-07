package com.moviereel.presentation.view.entertain.base

import com.moviereel.presentation.BaseView

/**
 * @author lusinabrian on 13/09/17.
 * @Notes base view for movie pages
 */
interface EntertainPageBaseView : BaseView {

    /**
     * Show API Error snackbar. this will display an error message on the snackbar in case
     * the API call has encountered an issue and can prompt user to retry connection
     */
    fun showApiErrorSnackbar()

    /**
     * In case of any error, display a message to the user
     */
    fun displayToast()

    /**
     * stop swipe refresh
     * */
    fun stopSwipeRefresh()
}