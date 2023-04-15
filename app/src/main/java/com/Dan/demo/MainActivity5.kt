package com.Dan.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.Dan.demo.databinding.ActivityMain5Binding

private lateinit var binding: ActivityMain5Binding
class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main5)

        //sử dụng màu cho icon menu
        binding.navLeftMenu.itemIconTintList = null
        binding.navLeftMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mnuSearchItem -> Toast.makeText(this@MainActivity5,"Search Item",Toast.LENGTH_SHORT).show()
                R.id.mnuIcon2 -> Toast.makeText(this@MainActivity5,"Home",Toast.LENGTH_SHORT).show()
                R.id.mnuIcon3 -> Toast.makeText(this@MainActivity5,"Exit",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}