package com.moviereel.ui.intro.splash

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.moviereel.R
import com.moviereel.presentation.view.splash.SplashPresenter
import com.moviereel.presentation.view.splash.SplashView
import com.moviereel.ui.base.BaseActivity
import com.moviereel.ui.intro.AppIntroduction
import com.moviereel.ui.main.MainActivity
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashView {

    val splashPresenter: SplashPresenter<SplashView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_layout)

        splashPresenter.onAttach(this)
    }

    /**
     * Abstract method that will be implemented by child activity classes
     * used to setup the views in the activity
     */
    override fun setUp() {

    }

    /*kill this splash screen to save memory*/
    override fun onPause() {
        super.onPause()
        finish()
    }

    /**
     * opens the main activity
     */
    override fun openMainActivity() {
        startActivity<MainActivity>()
        finish()
    }

    /**
     * opens the app introduction activity
     * this will be opened if this is the first time this application is being opened
     */
    override fun openAppIntroductionActivity() {
        startActivity<AppIntroduction>()
        finish()
    }

    /**
     * Starts sync service which will be used to update the data that will be used in the application
     */
    override fun startSyncService() {
        // TODO: 01/04/17: start sync service to fetch today's latest movies/series/shows
    }

    override fun onDestroy() {
        splashPresenter.onDetach()
        super.onDestroy()
    }
}
