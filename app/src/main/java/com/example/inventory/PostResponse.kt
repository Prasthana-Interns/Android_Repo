package com.example.inventory

import android.service.autofill.UserData
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("status_code")
    val status_code:Int,
    @SerializedName("authToken")
    val authToken:Int,
    @SerializedName("user")
    val user: UserData
)
