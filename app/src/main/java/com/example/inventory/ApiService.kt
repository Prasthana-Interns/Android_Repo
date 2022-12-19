package com.example.inventory
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService{
    companion object{
        const val BASE_URL="http://13.251.95.54:3000/users/"
    }
    //    @GET("users")
//    fun getData(): Call<List<EmpSignInRequest>>
//    @GET(Constants.SignIn_URL)
//    fun fetchPosts(@Header("Authorization") token: String): Call<PostResponse>
    @POST("signup")
    fun addUserSignUp(@Body  request : EmpSignUpRequest):Call<EmpSignUpResponse>
    @GET("signin")
    fun getUserSignInData(): Call<List<EmpSignInRequest>>
    @POST("signin")
    fun addUserSignIn(@Body request : EmpSignInRequest):Call<EmpSignInResponse<Any?>>
}
