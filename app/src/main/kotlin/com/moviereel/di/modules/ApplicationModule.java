package com.moviereel.di.modules;

import android.app.Application;
import android.content.Context;

import com.moviereel.BuildConfig;
import com.moviereel.R;
import com.moviereel.data.DataManager;
import com.moviereel.data.DataManagerImpl;
import com.moviereel.data.api.ApiHeader;
import com.moviereel.data.api.ApiHelper;
import com.moviereel.data.api.ApiHelperImpl;
import com.moviereel.data.db.DbHelper;
import com.moviereel.data.db.DbHelperImpl;
import com.moviereel.data.files.FileHelper;
import com.moviereel.data.files.FileHelperImpl;
import com.moviereel.data.prefs.PreferencesHelper;
import com.moviereel.data.prefs.PreferencesHelperImpl;
import com.moviereel.di.ApiInfo;
import com.moviereel.di.ApplicationContext;
import com.moviereel.di.DatabaseInfo;
import com.moviereel.di.PreferenceInfo;
import com.moviereel.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * @author lusinabrian on 27/03/17
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @ApiInfo
    String provideApiKey(){
        return BuildConfig.MOVIE_DB_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName(){
        return Constants.MOVIE_PREFS_FILE_NAME;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return Constants.DATABASE_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImpl dataManager){
        return dataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbHelperImpl dbHelper){
        return dbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferenceHelper(PreferencesHelperImpl preferencesHelper){
        return preferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelperImpl apiHelper){
        return apiHelper;
    }

    @Provides
    @Singleton
    FileHelper provideFileHelper(FileHelperImpl fileHelper){
        return fileHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey){
        return new ApiHeader.ProtectedApiHeader(apiKey);
    }

    @Provides
    @Singleton
    CalligraphyConfig provideDefaultCalligraphyConfig(){
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}

