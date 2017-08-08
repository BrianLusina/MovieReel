package com.moviereel.di.modules

import android.app.Application
import android.content.Context

import com.moviereel.BuildConfig
import com.moviereel.data.DataManager
import com.moviereel.data.DataManagerImpl
import com.moviereel.data.api.ApiHeader
import com.moviereel.data.api.ApiHelper
import com.moviereel.data.api.ApiHelperImpl
import com.moviereel.data.db.DbHelper
import com.moviereel.data.db.DbHelperImpl
import com.moviereel.data.files.FileHelper
import com.moviereel.data.files.FileHelperImpl
import com.moviereel.data.prefs.PreferencesHelper
import com.moviereel.data.prefs.PreferencesHelperImpl
import com.moviereel.di.ApiInfo
import com.moviereel.di.AppContext
import com.moviereel.di.DatabaseInfo
import com.moviereel.di.PreferenceInfo
import com.moviereel.utils.Constants

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import javax.inject.Named

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
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.MOVIE_DB_KEY
    }

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl() : String{
        // return BuildConfig.BASE_URL
        return "https://api.themoviedb.org/3/"
    }

    @Provides
    @Singleton
    @Named("posterPath")
    fun provideBasePosterPath() : String{
        return "http://image.tmdb.org/t/p/w500"
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return Constants.MOVIE_PREFS_FILE_NAME
    }


    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManagerImpl): DataManager {
        return dataManager
    }

    @Provides
    @Singleton
    fun provideDbHelper(dbHelper: DbHelperImpl): DbHelper {
        return dbHelper
    }

    @Provides
    @Singleton
    fun providePreferenceHelper(preferencesHelper: PreferencesHelperImpl): PreferencesHelper {
        return preferencesHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper {
        return apiHelper
    }

    @Provides
    @Singleton
    fun provideFileHelper(fileHelper: FileHelperImpl): FileHelper {
        return fileHelper
    }

    @Provides
    @Singleton
    fun provideProtectedApiHeader(@ApiInfo apiKey: String): ApiHeader.ProtectedApiHeader {
        return ApiHeader.ProtectedApiHeader(apiKey)
    }

}

