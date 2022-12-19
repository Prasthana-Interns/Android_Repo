package com.example.inventory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inventory.databinding.ActivityEmpBottombarBinding
import kotlinx.android.synthetic.main.activity_emp_details_screen.*
import kotlinx.android.synthetic.main.emp_bottom_bar_view.*

class EmpBottombarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmpBottombarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpBottombarBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_emp_bottombar)
        assign.setOnClickListener{
            var intent=Intent(this,AdminScreenOne::class.java)
            empIdDt.text = intent.getStringExtra("id")
            empDesignationDt.text=intent.getStringExtra("designation")
            empEmailDt.text=intent.getStringExtra("email")
            empNameDt.text=intent.getStringExtra("name")
            empDesignationDt.text=intent.getStringExtra("designation")
            nameIconDt.text=intent.getStringExtra("nameIcon")
        }
    }
}
