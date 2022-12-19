package com.example.inventory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.databinding.ActivityForgotPasswordBinding
import kotlinx.android.synthetic.main.activity_forgot_password.*


class ForgotPassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        empfFocusListener()
        binding.sendbtn.setOnClickListener{
            sendToLogin()
        }
        backToLogin.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun sendToLogin() {
        binding.empIdfReq.helperText = validEmpf()
        val validEmpf = binding.empIdfReq.helperText == null
        if (validEmpf)
        {
            val intent = Intent(this@ForgotPassword,MainActivity::class.java)
            startActivity(intent)
        }
        else
        {

        }
    }

    private fun empfFocusListener() {

            binding.empIdfEt.setOnFocusChangeListener{_, focused->
                if(!focused)
                {
                    binding.empIdfReq.helperText=validEmpf()
                }

            }
        }

        private fun validEmpf(): String?
        {
            val empIdftext = binding.empIdfEt.text.toString()
            if(empIdftext.length != 7)
            {
                return "Minimum 7 characters password"
            }
            return null
        }
    }
