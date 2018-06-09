package com.moviereel.di.components

import android.app.Application
import com.moviereel.MovieReelApp
import com.moviereel.di.modules.*
import com.moviereel.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

/**
 * @author lusinabrian on 27/03/17
 */

@PerApplication
@Component(modules = [
    AppModule::class, RemoteModule::class, CacheModule::class, DomainModule::class,
    ActivityBindingModule::class, AndroidSupportInjectionModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(movieReelApp: MovieReelApp)
}
