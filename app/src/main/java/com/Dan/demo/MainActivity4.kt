package com.Dan.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View.OnCreateContextMenuListener
import android.widget.TableLayout
import com.Dan.demo.databinding.ActivityMain4Binding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var binding:ActivityMain4Binding
class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main4)
        //ViewPagerAdapter là adapter ta dùng viết
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tbViewPage,binding.viewpager){tab,position->
            when(position){
                0->{tab.text = "Tab 1"}
                1->{tab.text = "Tab 2"}
                2->{tab.text = "Tab 3"}
            }
        }.attach()

    }

}