package com.example.inventory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
//    fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.activity_admin_screen_one, container, false)
//
//    }
//

}