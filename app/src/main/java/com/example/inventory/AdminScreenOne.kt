package com.example.inventory

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.inventory.databinding.ActivityAdminScreenOneBinding
import com.example.inventory.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_admin_screen_one.*
import kotlinx.android.synthetic.main.activity_main.*

class AdminScreenOne : AppCompatActivity() {
    private var binding: ActivityAdminScreenOneBinding? = null
    lateinit var adapter: ViewPagerAdapter
    lateinit var def: ColorStateList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminScreenOneBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val actionBar = supportActionBar
        actionBar!!.title = ""
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_back_arrow)
        getActionBar()?.setTitle("Other")

        initView()
    }

    fun initView() {
        adapter = ViewPagerAdapter(this.supportFragmentManager, this.lifecycle)
        adapter.addFragment(EmployeeFragment(), "Employee")
        adapter.addFragment(DevicesFragment(), "Devices")
        adapter.addFragment(ApprovalsFragment(), "Aprovals")

        binding?.viewPager?.adapter = adapter
        binding?.viewPager?.offscreenPageLimit = 1

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.fragmentTitleList.get(position)
        }.attach()

//        for (i in 0..3){
//            var tv:TextView = LayoutInflater.from(this).inflate(R.layout.custom_tab,null) as TextView
//            binding?.tabLayout?.getTabAt(i)?.setCustomView(tv)
//        }
    }

    class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

        var fragmentList = ArrayList<Fragment>()
        var fragmentTitleList = ArrayList<String>()

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList.get(position)
        }

    }
}