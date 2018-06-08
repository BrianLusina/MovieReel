package com.moviereel.di.components

import android.app.Application
import android.content.Context
import com.moviereel.MovieReelApp
import com.moviereel.di.modules.RemoteModule
import com.moviereel.di.modules.AppModule
import com.moviereel.di.modules.CacheModule
import com.moviereel.di.modules.SplashActivityModule
import com.moviereel.di.qualifiers.AppContext
import dagger.Component
import javax.inject.Singleton

/**
 * @author lusinabrian on 27/03/17
 */
@Singleton
@Component(modules = [(AppModule::class), (RemoteModule::class), (CacheModule::class),
    SplashActivityModule::class
])
interface AppComponent {

    fun inject(movieReelApp: MovieReelApp)

    @AppContext
    fun context(): Context

    fun application(): Application

}
