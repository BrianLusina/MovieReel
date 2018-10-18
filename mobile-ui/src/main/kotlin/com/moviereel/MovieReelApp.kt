package com.moviereel

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.crashlytics.android.Crashlytics
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.moviereel.di.*
import io.fabric.sdk.android.Fabric
import org.koin.android.ext.android.startKoin


class MovieReelApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

        startKoin(this, listOf(remoteModule, domainModule, dataModule, cacheModule,
                activitiesModules, applicationModule
        ))
        installCustomCrash()
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
    private fun installCustomCrash() {
        // TODO: change the errorDrawable
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
                .enabled(true)
                .showErrorDetails(BuildConfig.DEBUG)
                .showRestartButton(true)
                .logErrorOnRestart(true)
                .trackActivities(true)
                .errorDrawable(R.mipmap.ic_launcher)
    }
}
