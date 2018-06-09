package com.moviereel.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * @author lusinabrian on 27/03/17
 */

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(context: Context): Context

    @Binds
    abstract fun bindsApplication(app: Application): Application
}

