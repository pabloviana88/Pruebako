package com.example.pruebako.Model

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request:Request =chain.request()
            .newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("X-Platforma","android")
            .addHeader("Content-Type:"," application/x-www-form-urlencoded")
            .build()
        return chain.proceed(request)
    }

}