package com.moviereel.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.moviereel.remote.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author lusinabrian on 28/05/18.
 * @Notes Provides make methods to create instances of [ApiService] and related dependencies
 */
object ApiServiceFactory {

    /**
     * Factory method that makes the Api Service
     * @param isDebug Whether the application is in debug mode
     * @param apiKey The api key to use when communicating with API
     */
    fun makeApiService(isDebug: Boolean, apiKey: String) : ApiService {
        val okHttpClient = makeOkHttpClient(makeLoggingInterceptor(isDebug), apiKey)
        return  makeApiRetrofitService(makeGson(), okHttpClient)
    }

    private fun makeGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    private fun makeApiRetrofitService(gson: Gson, okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .build()

        return retrofit.create(ApiService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, apiKey: String): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor({
                    val originalRequest = it.request()
                    val originalUrl = originalRequest.url()
                    val url = originalUrl.newBuilder()
                            .addQueryParameter("api_key", apiKey)
                            .build()
                    val requestBuilder = originalRequest.newBuilder().url(url)
                    val request = requestBuilder.build()
                    it.proceed(request)
                })
                .addInterceptor {
                    var request = it.request()
                    request = request.newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Content-type", "application/json")
                            .build()
                    it.proceed(request)
                }
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }
}
