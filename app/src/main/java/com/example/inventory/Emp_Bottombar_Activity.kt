package com.example.inventory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inventory.databinding.ActivityEmpBottombarBinding
import com.example.inventory.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.emp_bottom_bar_view.*

class Emp_Bottombar_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEmpBottombarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpBottombarBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_emp_bottombar)
        assign.setOnClickListener{
            var intent=Intent(this,AdminScreenOne::class.java)
        }
    }
       fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.activity_emp_bottombar, container, false)

        }




    }
