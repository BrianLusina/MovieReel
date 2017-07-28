package com.moviereel.ui.activities.intro.splash

import com.moviereel.ui.base.BaseView

/**
 * @author lusinabrian on 01/04/17
 */

interface SplashView : BaseView {

    /**
     * opens the main actiivity
     */
    fun openMainActivity()

    /**
     * opens the app introduction acitivyt
     * this will be opened if this is the first time this application is being opened
     */
    fun openAppIntroductionActivity()

    /**
     * Starts sync service which will be used to update the data that will be used in the application
     */
    fun startSyncService()
}
