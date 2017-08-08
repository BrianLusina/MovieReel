package com.moviereel.app

import android.app.Application

import com.crashlytics.android.Crashlytics
import com.moviereel.BuildConfig
import com.moviereel.R
import com.moviereel.data.DataManager
import com.moviereel.di.components.AppComponent
import com.moviereel.di.modules.AppModule
import com.moviereel.ui.main.MainActivity
import com.moviereel.utils.ClassPreamble

import javax.inject.Inject

import cat.ereza.customactivityoncrash.CustomActivityOnCrash
import com.moviereel.di.components.DaggerAppComponent
import com.moviereel.di.modules.ApiModule
import com.moviereel.di.modules.DatabaseModule
import com.moviereel.di.modules.RepositoryModule
import io.fabric.sdk.android.Fabric


@ClassPreamble(author = "Brian Lusina", currentRevision = 2, date = "04/03/17", lastModified = "17/3/17", lastModifiedBy = "Brian Lusina", briefDescription = "Application Singleton object that will configure and install components for " + "the application to use. This will start up before the main activity is set up", reviewers = arrayOf("Brian Lusina"))
class MovieReelApp : Application() {
    @Inject lateinit var mDataManager: DataManager

    // Needed to replace the component with a test specific one
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule())
                .databaseModule(DatabaseModule())
                .repositoryModule(RepositoryModule())
                .build()

        component.inject(this)

        // installCustomCrash();
    }

    /**
     * Install custom crash to remove ANRs, because no one likes them :D
     * This will not display a logcat in production/release builds only in debug builds
     */
    private fun installCustomCrash() {

        // do not start this error launcher when in the background
        CustomActivityOnCrash.setLaunchErrorActivityWhenInBackground(false)

        // set the default icon
        CustomActivityOnCrash.setDefaultErrorActivityDrawable(R.mipmap.ic_launcher)

        //setting the activity to start when the application crashes
        CustomActivityOnCrash.setRestartActivityClass(MainActivity::class.java)

        //install the Custom Activity on crash
        CustomActivityOnCrash.install(this)
        CustomActivityOnCrash.setShowErrorDetails(BuildConfig.DEBUG)
        CustomActivityOnCrash.setEnableAppRestart(true)

        // report to Fabric!
        Fabric.with(this, Crashlytics())
    }
}
