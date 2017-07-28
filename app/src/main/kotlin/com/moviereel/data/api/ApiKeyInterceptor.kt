package com.moviereel.data.api

import com.moviereel.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author lusinabrian on 28/07/17.
 * @Notes interceptor to add api key to api requests
 */

internal class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()
        val url = originalUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.MOVIE_DB_KEY)
                .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}