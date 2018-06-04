package com.moviereel.presentation.view.splash


import com.moviereel.presentation.view.base.BasePresenterImpl

import javax.inject.Inject

import io.reactivex.disposables.CompositeDisposable

import java.lang.Thread.sleep

/**
 * @author lusinabrian on 01/04/17
 */

class SplashPresenterImpl<V : SplashView> @Inject
constructor(
        compositeDisposable: CompositeDisposable
) : BasePresenterImpl<V>(compositeDisposable), SplashPresenter<V> {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
        baseView!!.startSyncService()
        decideNextActivity()
    }

    /**
     * This decides the next activity for the application
     * Will check the shared preferences file if the app has started for the first time
     * and will start the app introduction, else will open the main activity */
    private fun decideNextActivity() {
        if (dataManager.getFirstStart()) {
            baseView!!.openAppIntroductionActivity()
            dataManager.setFirstStart(false)
        } else {
            try {
                sleep(2000)
                baseView!!.openMainActivity()
            } catch (e: InterruptedException) {
                e.printStackTrace()
                Log.e(SPLASH_PRESENTER_IMPL, "onAttach: " + e.message, e.cause)
            }

        }
    }

    companion object {

        private val SPLASH_PRESENTER_IMPL = SplashPresenterImpl::class.java.simpleName
    }
}
