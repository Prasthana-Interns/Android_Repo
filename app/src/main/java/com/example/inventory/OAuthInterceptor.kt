package com.example.inventory

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

//class OAuthInterceptor constructor(
//    private val tokenType:String,
//    private val accessToken:String
//): Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        var request = chain.request()
//        request = request.newBuilder().header("Authorization","$tokenType $accessToken")
//            .build()
//        return  chain.proceed(request)
class OAuthInterceptor(context: Context) : Interceptor {
    private val sessionManager = SessionManager(context)
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        sessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "$it")
        }
        return chain.proceed(requestBuilder.build())
    }
}

