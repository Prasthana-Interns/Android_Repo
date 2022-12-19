package com.example.inventory

import androidx.appcompat.widget.AppCompatSpinner
import com.google.gson.annotations.SerializedName

data class EmpSignUpRequest(

    @SerializedName("name")
    val name :String,
    @SerializedName("phoneNo")
    val phone_number :String,
    @SerializedName("emailId")
    val email :String,
    @SerializedName("designation")
    val designation :String,
    @SerializedName("approved")
    val approved :Boolean=false,
    @SerializedName("role")
    val role : Array<AppCompatSpinner>,

    )
