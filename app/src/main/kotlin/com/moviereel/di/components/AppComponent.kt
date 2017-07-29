package com.moviereel.di.components

import android.app.Application
import android.content.Context

import com.moviereel.app.MovieReelApp
import com.moviereel.data.DataManager
import com.moviereel.di.AppContext
import com.moviereel.di.modules.ApiModule
import com.moviereel.di.modules.AppModule

import javax.inject.Singleton

import dagger.Component

/**
 * @author lusinabrian on 27/03/17
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {

    fun inject(movieReelApp: MovieReelApp)

    @AppContext
    fun context(): Context

    fun application(): Application

    val dataManager: DataManager
}
