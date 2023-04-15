package com.Dan.demo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.Dan.demo.databinding.ActivityMain2Binding
import com.Dan.demo.databinding.ActivityMainBinding
@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMain2Binding
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main2)
        setContentView(binding.root)
        setupOnclickReturn()
        setupRvStaggeredGrid()
    }

    private fun setupRvStaggeredGrid() {
        var list = mutableListOf<Int>()
        list.add(R.drawable.img)
        list.add(R.drawable.img_5)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_4)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img)

        binding.RvStaggeredGrid.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val itemAdapter = RvAdapterPinterest(list)
        binding.RvStaggeredGrid.adapter = itemAdapter
    }

    private fun setupOnclickReturn() {
        binding.button3.setOnClickListener {
            val it = Intent(this,MainActivity::class.java)
            /*
                có 2 cách để truyền qua activity
                1. Dùng trực tiếp từ Intent (gửi đơn lẻ từng dữ liệu)
                    Truyền trực tiếp bằng Intent: Gửi dữ liêu putExtra() không có s

                2. Đóng gói vào Bundle ( Đóng gói sau đó gửi 1 lần
            */

            //1 Truyền dữ liệu qua intent
            //  it.putExtra("Your profile","Dan")
            //  it.putExtra("double",10.9)
            //  it.putExtra("isTrue",true)

            //2.Nap dữ liệu vào Bundle()
            val bundle = Bundle()
            bundle.putString("Your profile","Dan")
            bundle.putDouble("double",10.9)
            bundle.putBoolean("isTrue",true)
            /*
                đặt bundle vào trong intent
                Note: là putExtras (có s vì là số nhiều )
            */
            it.putExtras(bundle)
            startActivity(it)
        }
    }
}