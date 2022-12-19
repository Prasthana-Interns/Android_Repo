package com.example.inventory

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("empId")
    val empId:String,
    @SerializedName("password")
    val password: String

)
