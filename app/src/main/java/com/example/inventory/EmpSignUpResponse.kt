package com.example.inventory

import com.google.gson.annotations.SerializedName

data class EmpSignUpResponse(
//    @SerializedName("status_code")
//    val status_code:Int,
//    @SerializedName("authToken")
//    val authToken:Int,
//    @SerializedName("user")
//{
//    "id": 16,
//    "name": "harikrishna",
//    "emp_id": "EMP-016",
//    "phone_number": 7780619640,
//    "email": "harikrishna@gmail.com",
//    "designation": "Intern"
//}
    @SerializedName("name")
    val id :Int,
    @SerializedName("name")
    val name :String,
    @SerializedName("emp_id")
    val emp_id :String,
    @SerializedName("phone_number")
    val phone_number :String,
    @SerializedName("email")
    val email :String,
    @SerializedName("designation")
    val designation :String,
)
