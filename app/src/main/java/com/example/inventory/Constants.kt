package com.example.inventory

import com.example.inventory.ApiService.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
    const val SignIn_URL="http://13.251.95.54:3000/users/signin/"
    const val SignUp_URL="http://13.251.95.54:3000/users/signup/"
    const val PREFS_TOKEN_FILE = "PREFS_TOKEN_FILE"
    const val USER_TOKEN="USER_TOKEN"
        private val client= OkHttpClient.Builder().build()
    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}