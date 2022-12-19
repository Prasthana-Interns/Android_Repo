package com.example.inventory

import com.google.gson.annotations.SerializedName

data class EmpSignInRequest(
    @SerializedName("empId")
    val emp_id : String,
    @SerializedName("password")
    val password : String
)
