package com.moviereel.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.crashlytics.android.Crashlytics
import com.moviereel.BuildConfig
import com.moviereel.di.components.AppComponent
import com.moviereel.di.modules.ApiModule
import com.moviereel.di.modules.AppModule
import com.moviereel.di.modules.DatabaseModule
import com.moviereel.di.modules.RepositoryModule
import io.fabric.sdk.android.Fabric


class MovieReelApp : Application() {
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

        // installCustomCrash()
        setAppCenter()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun setAppCenter() {
        AppCenter.start(this,
                BuildConfig.APP_CENTER_KEY,
                Analytics::class.java, Crashes::class.java)
    }

    /**
     * Install custom crash to remove ANRs, because no one likes them :D
     * This will not display a logcat in production/release builds only in debug builds
     */
//    private fun installCustomCrash() {
//
//        // do not start this error launcher when in the background
//        CustomActivityOnCrash.setLaunchErrorActivityWhenInBackground(false)
//
//        // set the default icon
//        CustomActivityOnCrash.setDefaultErrorActivityDrawable(R.mipmap.ic_launcher)
//
//        //setting the activity to start when the application crashes
//        CustomActivityOnCrash.setRestartActivityClass(MainActivity::class.java)
//
//        //install the Custom Activity on crash
//        CustomActivityOnCrash.install(this)
//        CustomActivityOnCrash.setShowErrorDetails(BuildConfig.DEBUG)
//        CustomActivityOnCrash.setEnableAppRestart(true)
//
//        // report to Fabric!
//        Fabric.with(this, Crashlytics())
//    }
}
