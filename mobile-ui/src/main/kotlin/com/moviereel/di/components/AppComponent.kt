package com.moviereel.di.components

import android.app.Application
import android.content.Context
import com.moviereel.MovieReelApp
import com.moviereel.di.modules.RemoteModule
import com.moviereel.di.modules.AppModule
import com.moviereel.di.modules.CacheModule
import com.moviereel.di.modules.SplashActivityModule
import com.moviereel.di.qualifiers.AppContext
import com.moviereel.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author lusinabrian on 27/03/17
 */

@PerApplication
@Component(modules = [
    AppModule::class, RemoteModule::class, CacheModule::class,
    SplashActivityModule::class, AndroidSupportInjectionModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(movieReelApp: MovieReelApp)

    @AppContext
    fun context(): Context
}
