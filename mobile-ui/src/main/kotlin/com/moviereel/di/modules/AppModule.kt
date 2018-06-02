package com.moviereel.di.modules

import android.app.Application
import android.content.Context
import com.moviereel.data.DataManager
import com.moviereel.data.DataManagerImpl
import com.moviereel.di.qualifiers.AppContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author lusinabrian on 27/03/17
 */

@Module
class AppModule(private val mApplication: Application) {

    @Provides
    @AppContext
    fun provideContext(): Context {
        return mApplication
    }

    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManagerImpl): DataManager {
        return dataManager
    }
}

