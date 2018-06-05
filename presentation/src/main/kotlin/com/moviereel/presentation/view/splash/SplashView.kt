package com.moviereel.presentation.view.splash

import com.moviereel.presentation.BaseView

/**
 * @author lusinabrian on 01/04/17
 */

interface SplashView : BaseView {

    /**
     * opens the main activity
     */
    fun openMainActivity()

    /**
     * opens the app introduction activity
     * this will be opened if this is the first time this application is being opened
     */
    fun openAppIntroductionActivity()

    /**
     * Starts sync service which will be used to update the data that will be used in the application
     */
    fun startSyncService()
}
