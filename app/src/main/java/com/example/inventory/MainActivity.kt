package com.example.inventory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.databinding.ActivityMainBinding
import com.example.inventory.ForgotPassword
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        forgotPassBtn.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        sign_Up.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }
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
        if(passwordText.length < 4)
        {
            return "Minimum 8 characters password"
        }
        return null


    }
    private fun empIdFocusListener()
    {
        binding.empIdTv.setOnFocusChangeListener{_, focused->
            if(!focused)
            {
                binding.empReq.helperText=validEmpId()
            }

        }
    }

    private fun validEmpId(): String?
    {
        val empIdText = binding.empIdTv.text.toString()
        if(empIdText.length < 4)
        {
            return "Minimum 4 characters password"
        }
        return null


    }

}