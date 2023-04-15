package com.Dan.demo

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.Dan.demo.databinding.ActivityMainBinding

class CustomAdapterSpinner(
    val activity: MainActivity,
    val list: List<OutDataSpinner>
    ):ArrayAdapter<OutDataSpinner>(activity,R.layout.list_spinner) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }
    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        /*
            position: Int - Vi tri cua value trong list
            convertView: View? che do xem cho tung muc trong spinner
            parent: ViewGroup: ViewGroup cha dang chua spinner
        */
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.list_spinner,parent,false)

        val image = rowView.findViewById<ImageView>(R.id.imgSpinner)
        val title = rowView.findViewById<TextView>(R.id.txtSpinner)

        image.setImageResource(list[position].image)
        title.text = list[position].title

        return rowView
    }
}