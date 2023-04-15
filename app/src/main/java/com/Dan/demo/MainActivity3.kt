package com.Dan.demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Dan.demo.databinding.ActivityMain3Binding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMain3Binding
class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main3)

        val sub1 = BlankFragment1()
        val sub2 = BlankFragment2()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,sub1)
            commit()
        }
        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,sub1)
                commit()
            }
        }
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,sub2)
                commit()
            }
        }
    }
}