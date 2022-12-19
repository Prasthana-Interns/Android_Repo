package com.example.inventory
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.databinding.ActivityAdminScreenOneBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_admin_screen_one.*

var binding: ActivityAdminScreenOneBinding?=null

var fragmentsArray= arrayOf("Employee","Devices","Approvals")

class AdminScreenOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminScreenOneBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)
        val viewPager = binding!!.viewPager
        val tabLayout = binding!!.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentsArray[position]
        }.attach()

        backBtn.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}