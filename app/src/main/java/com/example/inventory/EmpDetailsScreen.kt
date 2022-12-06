package com.example.inventory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_emp_details_screen.*

class EmpDetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emp_details_screen)

        empIdDt.text = intent.getStringExtra("id")
        empDesignationDt.text=intent.getStringExtra("email")
        empEmailDt.text=intent.getStringExtra("email")
        empNameDt.text=intent.getStringExtra("name")
        empDesignationDt.text=intent.getStringExtra("designation")
        nameIconDt.text=intent.getStringExtra("nameIcon")

        backBtn.setOnClickListener {
            val intent=Intent(this,AdminScreenOne::class.java)
            startActivity(intent)
        }
    }
}