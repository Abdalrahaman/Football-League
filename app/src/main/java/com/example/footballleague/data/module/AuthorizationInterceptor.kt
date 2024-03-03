package com.example.footballleague.data.module

import com.example.footballleague.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().header(
                "X-Auth-Token",
                BuildConfig.API_KEY
            ).build()
        )
    }
}