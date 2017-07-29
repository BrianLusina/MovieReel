package com.moviereel.di.modules

import android.content.Context
import dagger.Module
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import com.moviereel.BuildConfig
import com.moviereel.data.api.ApiHelper
import com.moviereel.data.api.ApiKeyInterceptor
import dagger.Provides
import okhttp3.Cache
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import javax.inject.Named

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
                .build()
    }

    @Provides @Singleton
    fun provideOkHttpCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideTheMovieDbApiService(retrofit: Retrofit) : ApiHelper{
        return retrofit.create(ApiHelper::class.java)
    }
}