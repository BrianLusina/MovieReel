package com.moviereel.di.modules

import com.moviereel.cache.CacheManagerImpl
import com.moviereel.data.source.DataCache
import dagger.Module
import dagger.Provides


/**
 * @author lusinabrian on 08/08/17.
 * @Notes Module for repositories
 */
@Module
class DataModule {

    @Provides
    fun provideDataCache(cacheManager : CacheManagerImpl) : DataCache{
        return cacheManager
    }
}