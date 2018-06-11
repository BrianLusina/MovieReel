package com.moviereel.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * @author lusinabrian on 27/03/17
 */

@Module
class AppModule {

    @Provides
    fun provideAppContext(app: Application): Context{
        return app
    }
}

