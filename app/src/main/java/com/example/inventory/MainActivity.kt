package com.example.inventory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.ConstantsValues.Companion.passwordValue
import com.example.inventory.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit  var binding: ActivityMainBinding
//    private lateinit var sessionManager: SessionManager
//    private lateinit var apiClient: ApiClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        passwordFocusListener()
        empIdFocusListener()
  signinBtn.setOnClickListener{
        signInForm()
    }
//        signinBtn.setOnClickListener {
//            signInForm()
//        }

        forgotPassBtn.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }
//        signinBtn.setOnClickListener {
//            val intent = Intent(this, SplashScreen::class.java)
//            startActivity(intent)
//                            }


        sign_Up.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

//        signinBtn.setOnClickListener {
//            val intent = Intent(this, SplashScreen::class.java)
//            startActivity(intent)
//        }
    }

//    private fun empSignInNav() {
//        apiClient = ApiClient()
//        sessionManager = SessionManager(this)
//
//        apiClient.getApiService(this).addUserSignIn(EmpSignInRequest(empIdTv.text.toString(),passwordTv.text.toString()))
//        apiClient.getApiService(this).addUserSignIn(
//            EmpSignInRequest(
//                empIdTv.text.toString(),
//                passwordTv.text.toString()
//            )
//        ) .enqueue(object : Callback<EmpSignInResponse<Any?>> {
//                override fun onFailure(call : Call<EmpSignInResponse<Any?>>, t : Throwable) {
//                    // Error logging in
//                }
//
//                override fun onResponse(
//                    call : Call<EmpSignInResponse<Any?>>,
//                    response : Response<EmpSignInResponse<Any?>>
//                ) {
//                    val empSignInResponse = response.body()
//                    if (empSignInResponse?.status_code == 200 && empSignInResponse.user != null) {
//                        val intent = Intent(this@MainActivity, AdminScreenOne::class.java)
//                          startActivity(intent)
//                          sessionManager.saveAuthToken(empSignInResponse.authToken.toString())
//                    } else {
//
//                    }
//
//                }
//            })
//    }
//    private fun signUpForm(){
//
//    }
    private fun signInForm() {
        binding.empIdReq.helperText = validEmpId()
        binding.pass1Req.helperText = validPassword()
        val validEmpId = binding.empIdReq.helperText.isNullOrEmpty()
        val validPassword = binding.pass1Req.helperText.isNullOrEmpty()
        //   val validEmpId = binding.empIdReq.helperText.isNullOrEmpty()
//    val validPassword = binding.pass1Req.helperText.isNullOrEmpty()
//
        if(validPassword && validEmpId) {
//            empSignInNav()
            //addDummyUserSI()
           // addDummyUser()
            //fetchPost()
           // addUserSignIn()
            val intent = Intent(this@MainActivity, SplashScreen::class.java)
            startActivity(intent)

            //            make API Call
//            fun addUserSignIn(useriData : EmpSignInRequest) {
//                val retrofit = Constants.buildService(ApiService::class.java)
//                retrofit.addUserSignIn(useriData).enqueue(object : Callback<EmpSignInRequest> {
//                    override fun onResponse(
//                        call : Call<EmpSignInRequest>, response : Response<EmpSignInRequest>
//                    ) {
//                        val useriData = response.body()
//                        Log.d("RESPONSE CODE", "onResponse: " + response.code())
//
//                    }
//
//                    override fun onFailure(call : Call<EmpSignInRequest>, t : Throwable) {
//                        Log.d("Failed", "onFailure: " + t.message)
//
//                    }
//
//                })
//
//
//            }
//            fun addDummyUserSI()
//            {
//                val apiServicesSI=RestApiService()
//                val empSignInRequest = EmpSignInRequest(
//                    empIdTv.text.toString(),
//                    passwordTv.text.toString()
//                )
//                apiServicesSI.addUserSignIn(empSignInRequest)
//            }





//        empSignInNav()
            //resetForm()
        } else {
            invalidForm()
        }
    }

//    private fun resetForm() {
//        var message=" "
//        message += "\nEmail: " + binding.empIdTv.text
//        message += "\nPhoneNumber: "+ binding.passwordTv.text
//        AlertDialog.Builder(this)
//            .setTitle(" signup completed")
//            .setMessage(message)
//            .setPositiveButton("okay") { _, _ ->
//                binding.empIdTv.text = null
//                binding.passwordTv.text = null
//            }
//    }


    private fun invalidForm() {
        var message=" "
        if (binding.empIdReq.helperText != null)
            message += "\n\nEmail: " + binding.empIdReq.helperText
        if (binding.pass1Req.helperText != null)
            message += "\n\nPhoneNumber: "+ binding.pass1Req.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("okay"){_,_->

            }
    }


//    private fun resetForm() {
//        var message=" "
//        message += "\nEmpId: " + binding.empIdTv.text
//        message += "\nPassword: "+ binding.passwordTv.text
//
//        AlertDialog.Builder(this)
//            .setTitle(" signup completed")
//            .setMessage(message)
//            .setPositiveButton("okay") { _, _ ->
//                binding.empIdTv.text = null
//                binding.passwordTv.text = null
//            }
//
//    }

    private fun passwordFocusListener()
    {
        binding.passwordTv.setOnFocusChangeListener{_, focused->
            if(!focused)
            {
                binding.pass1Req.helperText=validPassword()
            }

        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.passwordTv.text.toString()
        if(passwordText.length < passwordValue)
        {
            return "Minimum 4 characters password"
        }
        return null

    }
    private fun empIdFocusListener()
    {
        binding.empIdTv.setOnFocusChangeListener{_, focused->
            if(!focused)
            {
                binding.empIdReq.helperText=validEmpId()
            }

        }
    }

    private fun validEmpId(): String?
    {
        val empIdText = binding.empIdTv.text.toString()
        if(empIdText.length != 7 )
        {
            return "Minimum 7 characters EMP-ID"
        }
        return null


    }


//    private fun fetchPost(){
//        apiClient.getApiService(this).fetchPosts(token = " ${sessionManager.fetchAuthToken()}")
//            .enqueue(object : Callback<PostResponse>
//            {
//                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
//                    // Error fetching posts
//                }
//                override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
//                    // Handle function to display posts
//                }
//
//            })
//    }
//
//    fun addDummyUser()
//    {
//        val apiServices=RestApiService()
//            val empSignUpRequest = EmpSignUpRequest(
//                nameEt.text.toString(),
//                emailEditText.text.toString(),
//                phoneNumberEditText.text.toString(),
//                designationEt.text.toString(),
//                role = this.spnTest1
//            )
//            apiServices.addUserSignUp(empSignUpRequest)
//
//        }
//    fun addDummyUserSI()
//    {
//        val apiServicesSI=RestApiService()
//        val empSignInRequest = EmpSignInRequest(
//            empIdTv.text.toString(),
//                    passwordTv.text.toString()
//        )
//        apiServicesSI.addUserSignIn(empSignInRequest)
//    }
//
//
//    }

//private fun <T> Call<T>.enqueue(callback : Callback<EmpSignInRequest>) {
//
//}

//fun getUserSignInDataa() {
//    val recyclerView:RecyclerView=findViewById(R.id.recyclerview_users)
//    val retrofit= Constants.buildService(ApiService::class.java)
//
//    val retrofitData=retrofit.getUserSignInData()
//
//    retrofitData.enqueue(object : Callback<List<EmpSignInRequest>?> {
//        override fun onResponse(
//            call: Call<List<EmpSignInRequest>?>,
//            response: Response<List<EmpSignInRequest>?>){
     //       val responseBody=response.body()!!
           // binding=MainActivity(this@MainActivity.baseContext,responseBody)
//            myAdapter = MyAdapter(this@MainActivity.baseContext,responseBody)
//                myAdapter.notifyDataSetChanged()
            //binding?.recyclerviewUsers?.adapter=myAdapter
           // val responseBody=response.body()!!

//        }
//
//        override fun onFailure(call: Call<List<EmpSignInRequest>?>, t: Throwable) {
//            Log.d("MainActivity", "onFailure: " + t.message)
//        }
//    })
//}




//private fun signInForm() {
//    binding.empIdReq.helperText = validEmpId()
//    binding.pass1Req.helperText = validPassword()
//    val validEmpId = binding.empIdReq.helperText.isNullOrEmpty()
//    val validPassword = binding.pass1Req.helperText.isNullOrEmpty()
//    if(empIdTv.text.isNotEmpty()  && passwordTv.text.isNotEmpty() &&
//        empIdTv.text.length == 7 && passwordTv.text.length >= 4) {

//private fun addDummyUserSI() {
//    val apiServicesSI=RestApiService()
//    val empSignInRequest = EmpSignInRequest(
//        empIdTv.text.toString(),
//        passwordTv.text.toString()
//    )
//    apiServicesSI.addUserSignIn(empSignInRequest)
//
//        val intent = Intent(this@MainActivity, AdminScreenOne::class.java)
//        startActivity(intent)

}
