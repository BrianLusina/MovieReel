package com.moviereel.di.components

import android.app.Application
import android.content.Context
import com.moviereel.app.MovieReelApp
import com.moviereel.data.DataManager
import com.moviereel.di.qualifiers.AppContext
import com.moviereel.di.modules.ApiModule
import com.moviereel.di.modules.AppModule
import com.moviereel.di.modules.DatabaseModule
import com.moviereel.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author lusinabrian on 27/03/17
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, DatabaseModule::class,
        RepositoryModule::class))
interface AppComponent {

    fun inject(movieReelApp: MovieReelApp)

    @AppContext
    fun context(): Context

    fun application(): Application

    val dataManager: DataManager
}
