package com.moviereel.di.components

import android.app.Application
import android.content.Context

import com.moviereel.app.MovieReelApp
import com.moviereel.data.DataManager
import com.moviereel.di.ApplicationContext
import com.moviereel.di.modules.ApiModule
import com.moviereel.di.modules.ApplicationModule

import javax.inject.Singleton

import dagger.Component

/**
 * @author lusinabrian on 27/03/17
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ApiModule::class))
interface ApplicationComponent {

    fun inject(movieReelApp: MovieReelApp)

    // TODO: 27/03/17 inject services

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    val dataManager: DataManager
}
