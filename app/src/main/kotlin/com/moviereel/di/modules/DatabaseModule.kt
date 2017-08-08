package com.moviereel.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.moviereel.data.db.MovieReelDatabase
import com.moviereel.data.db.dao.MovieNPDao
import com.moviereel.di.AppContext
import com.moviereel.di.DatabaseInfo
import com.moviereel.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author lusinabrian on 08/08/17.
 * @Notes DatabaseModule to provide dependencies for database to use
 */
@Module
class DatabaseModule {

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return DATABASE_NAME
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@AppContext context: Context): MovieReelDatabase {
        return Room.databaseBuilder(context, MovieReelDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    fun provideMovieNowPlayingDao(database: MovieReelDatabase): MovieNPDao {
        return database.getMovieNowPlayingDao()
    }
}