package com.moviereel.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiHeaderInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-type", "application/json")
                .build()
        return chain.proceed(request)
    }
}
