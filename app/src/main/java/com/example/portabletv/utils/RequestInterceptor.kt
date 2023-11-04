package com.example.portabletv.utils

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
//            .addHeader("Authorization", API_KEY)
            .build()
        return chain.proceed(request)
    }
}