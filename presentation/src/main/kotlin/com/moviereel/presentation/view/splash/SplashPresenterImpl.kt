package com.moviereel.presentation.view.splash

import com.moviereel.domain.DomainManager
import com.moviereel.presentation.view.base.BasePresenterImpl
import java.lang.Thread.sleep
import javax.inject.Inject

/**
 * @author lusinabrian on 01/04/17
 */

class SplashPresenterImpl<V : SplashView>
@Inject
constructor(val domainManager: DomainManager) : BasePresenterImpl<V>(domainManager), SplashPresenter<V> {

    override fun onAttach(baseView: V) {
        super.onAttach(baseView)
        baseView.startSyncService()
        decideNextActivity()
    }

    /**
     * This decides the next activity for the application
     * Will check the shared preferences file if the app has started for the first time
     * and will start the app introduction, else will open the main activity */
    private fun decideNextActivity() {
        if (domainManager.getFirstStart()) {
            baseView.openAppIntroductionActivity()
            domainManager.setFirstStart(false)
        } else {
            try {
                sleep(2000)
                baseView.openMainActivity()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}
