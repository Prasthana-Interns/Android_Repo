package com.example.inventory

import com.google.gson.annotations.SerializedName

class SignInRequest (
    @SerializedName("empId")
    val empId : String,

    @SerializedName("password")
    val password : String,

    )