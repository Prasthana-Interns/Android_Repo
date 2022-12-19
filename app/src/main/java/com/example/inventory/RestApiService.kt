package com.example.inventory

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUserSignUp(useruData : EmpSignUpRequest) {
        val retrofit = Constants.buildService(ApiService::class.java)
        retrofit.addUserSignUp(useruData).enqueue(object : Callback<EmpSignUpResponse> {
//            override fun onResponse(
//                call : Call<EmpSignUpRequest>, response : Response<EmpSignUpRequest>
//            ) {
//                val addedUserSignUp = response.body()
//                onResult(addedUserSignUp)
////                Log.d("RESPONSE CODE", "onResponse: " + response.code())
//
//            }
//            override fun onFailure(call : Call<EmpSignUpRequest>, t : Throwable) {
////                Log.d("Failed", "onFailure: " + t.message)
//onResult(null)
            //}

            override fun onResponse(
                call : Call<EmpSignUpResponse>,
                response : Response<EmpSignUpResponse>
            ) {
                val addedUserSignUp = response.body()

                // onResult(addedUserSignUp)
                Log.d("RESPONSE CODE", "onResponse: " + response.code())

            }

            override fun onFailure(call : Call<EmpSignUpResponse>, t : Throwable) {
                Log.d("Failed", "onFailure: " + t.message)

            }
        })


    }
}

//    fun addUserSignIn(useriData : EmpSignInRequest) {
//        val retrofit = Constants.buildService(ApiService::class.java)
//        retrofit.addUserSignIn(useriData).enqueue(object : Callback<EmpSignInResponse<Any?>> {
//            override fun onResponse(
//                call : Call<EmpSignInResponse<Any?>>,
//                response : Response<EmpSignInResponse<Any?>>
//            ) {
//                val addedUserSignUp = response.body()
//
//                // onResult(addedUserSignUp)
//                Log.d("RESPONSE CODE", "onResponse: " + response.code())
//
//            }
//
//            override fun onFailure(call : Call<EmpSignInResponse<Any?>>, t : Throwable) {
//                Log.d("Failed", "onFailure: " + t.message)
//
//            }
//
//
//        }) }
//}

//private fun <T> Call<T>.enqueue(callback : Callback<EmpSignUpRequest>) {
//
//}
