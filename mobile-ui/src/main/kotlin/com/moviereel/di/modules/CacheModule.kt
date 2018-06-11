package com.moviereel.di.modules

import android.content.Context
import com.moviereel.cache.CacheManager
import com.moviereel.cache.CacheManagerImpl
import com.moviereel.cache.db.DbFactory
import com.moviereel.cache.db.MovieReelDatabase
import com.moviereel.cache.db.dao.movies.MovieNowPlayingDao
import com.moviereel.cache.db.dao.movies.MoviePopularDao
import com.moviereel.cache.db.dao.movies.MovieTopRatedDao
import com.moviereel.cache.db.dao.movies.MovieUpcomingDao
import com.moviereel.cache.files.FileHelper
import com.moviereel.cache.files.FileHelperImpl
import com.moviereel.cache.movies.MovieCache
import com.moviereel.cache.movies.MovieCacheImpl
import com.moviereel.cache.movies.nowplaying.NowPlaying
import com.moviereel.cache.movies.nowplaying.NowPlayingCacheMapper
import com.moviereel.cache.movies.nowplaying.NowPlayingImpl
import com.moviereel.cache.prefs.PreferencesHelper
import com.moviereel.cache.prefs.PreferencesHelperImpl
import com.moviereel.di.qualifiers.AppContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author lusinabrian on 08/08/17.
 * @Notes CacheModule to provide dependencies for database to use
 */
@Module
class CacheModule {

    @Provides
    fun providePreferencesHelper(preferencesHelper: PreferencesHelperImpl) : PreferencesHelper{
        return preferencesHelper
    }

    @Provides
    fun provideFileHelper(filesHelper : FileHelperImpl): FileHelper{
        return filesHelper
    }

    @Provides
    fun provideCacheManager(cacheManager : CacheManagerImpl) : CacheManager{
        return cacheManager
    }

    @Provides
    fun provideMovieCache(movieCache : MovieCacheImpl) : MovieCache{
        return movieCache
    }

    @Provides
    fun provideAppDatabase(context: Context): MovieReelDatabase {
        return DbFactory.makeAppDatabase(context)
    }

    @Provides
    fun provideNowPlayingCacheMapper() : NowPlayingCacheMapper{
        return NowPlayingCacheMapper()
    }

    @Provides
    fun providesMoviesNowPlaying(nowPlaying: NowPlayingImpl): NowPlaying{
        return nowPlaying
    }

    @Provides
    fun provideMovieNowPlayingDao(database: MovieReelDatabase): MovieNowPlayingDao {
        return database.getMovieNowPlayingDao()
    }

    @Provides
    fun provideMoviePopularDao(database: MovieReelDatabase): MoviePopularDao {
        return database.getMoviePopularDao()
    }

    @Provides
    fun provideMovieTopRatedDao(database: MovieReelDatabase): MovieTopRatedDao {
        return database.getMovieTopRatedDao()
    }

    @Provides
    fun provideMovieUpcomingDao(database: MovieReelDatabase): MovieUpcomingDao {
        return database.getMovieUpcomingDao()
    }
}