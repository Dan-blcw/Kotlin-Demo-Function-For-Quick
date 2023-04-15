package com.Dan.demo

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(
    val activity: Activity,
    val list: List<OutData>
    ): ArrayAdapter<OutData> (activity,R.layout.list_item) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //layoutInflater - component giup chuyen file xml thanh view trong andr
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.list_item,parent,false)

        val image = rowView.findViewById<ImageView>(R.id.imgView)
        val title = rowView.findViewById<TextView>(R.id.txtTitle)
        val desc = rowView.findViewById<TextView>(R.id.txtDesc)

        title.text = list[position].title
        desc.text = list[position].desc
        image.setImageResource(list[position].image)


        return rowView
    }
}