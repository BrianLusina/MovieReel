package com.moviereel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.crashlytics.android.Crashlytics
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import javax.inject.Inject


class MovieReelApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

//       DaggerAppComponent.builder()
//                .appModule(AppModule(this))
//                .apiModule(RemoteModule())
//                .databaseModule(CacheModule())
//                .repositoryModule(DataModule())
//                .build()
//                .inject(this)

        // installCustomCrash()
        setAppCenter()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
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
