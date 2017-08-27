package com.moviereel.di.modules

import android.app.Application
import android.content.Context
import com.moviereel.data.DataManager
import com.moviereel.data.DataManagerImpl
import com.moviereel.data.files.FileHelper
import com.moviereel.data.files.FileHelperImpl
import com.moviereel.data.prefs.PreferencesHelper
import com.moviereel.data.prefs.PreferencesHelperImpl
import com.moviereel.di.qualifiers.AppContext
import com.moviereel.di.qualifiers.PreferenceInfo
import com.moviereel.utils.MOVIE_PREFS_FILE_NAME
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
    @PreferenceInfo
    fun providePreferenceName(): String {
        return MOVIE_PREFS_FILE_NAME
    }

    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManagerImpl): DataManager {
        return dataManager
    }

    @Provides
    @Singleton
    fun providePreferenceHelper(preferencesHelper: PreferencesHelperImpl): PreferencesHelper {
        return preferencesHelper
    }

    @Provides
    @Singleton
    fun provideFileHelper(fileHelper: FileHelperImpl): FileHelper {
        return fileHelper
    }
}

