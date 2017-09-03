package com.moviereel.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.moviereel.BuildConfig
import com.moviereel.data.api.ApiHeaderInterceptor
import com.moviereel.data.api.ApiKeyInterceptor
import com.moviereel.data.api.ApiRetrofitService
import com.moviereel.di.qualifiers.ApiInfo
import com.moviereel.di.qualifiers.AppContext
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/07/17.
 * @Notes: Api Module used to generate dependencies for use when making network calls
 */

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }


    @Provides
    @Singleton
    @Named("posterPath")
    fun provideBasePosterPath(): String {
        return BuildConfig.IMAGE_BASE_URL
    }

    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.MOVIE_DB_KEY
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("baseUrl") baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }

    @Provides @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(ApiKeyInterceptor())
                .addInterceptor(ApiHeaderInterceptor())
                .build()
    }

    @Provides @Singleton
    fun provideOkHttpCache(@AppContext context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideTheMovieDbApiService(retrofit: Retrofit): ApiRetrofitService {
        return retrofit.create(ApiRetrofitService::class.java)
    }
}