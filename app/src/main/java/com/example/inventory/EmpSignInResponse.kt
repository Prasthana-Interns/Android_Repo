package com.example.inventory

import android.service.autofill.UserData
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_sign_up.*

data class EmpSignInResponse<spnTest1>(
    @SerializedName("status_code")
    val status_code:Int,
    @SerializedName("authToken")
    val authToken:Int,
    @SerializedName("user")
    val user: UserData,
//    "user": {
//        "id": 1,
//        "name": "Shiva Kumar",
//        "emp_id": "EMP-001",
//        "designation": "Intern",
//        "email": "argulashiva529@gmail.com",
//        "user_roles": [
//            "Employee",
//            "Admin"
//        ]
//    },
//    "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJleHAiOjE2NzA0ODE2Njh9.Tvq6t62i97-gwjqnbkxLswPNtRtsOLsD0LQ7BgtGWJU"
//}
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("emp_id")
    val emp_id : String,
    @SerializedName("designation")
    val designaṭion:String,
    @SerializedName("emp_id")
    val email : String,
    @SerializedName("user_roles")
    val user_roles : spnTest1



)
