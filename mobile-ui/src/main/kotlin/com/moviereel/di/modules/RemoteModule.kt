package com.moviereel.di.modules

import com.moviereel.BuildConfig
import com.moviereel.remote.ApiServiceFactory
import com.moviereel.remote.api.ApiService
import dagger.Module
import dagger.Provides

/**
 * @author lusinabrian on 28/07/17.
 * @Notes: Api Module used to generate dependencies for use when making network calls
 */

@Module
class RemoteModule {

    @Provides
    fun provideApiService() : ApiService {
        return ApiServiceFactory.makeApiService(BuildConfig.DEBUG, BuildConfig.MOVIE_DB_API_KEY)
    }
}