package com.Dan.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.recyclerview.widget.RecyclerView

class RvAdapterPinterest(private  val list: List<Int>): RecyclerView.Adapter<RvAdapterPinterest.itemViewHolder>(){
    class itemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_rv_staggeredgridlayout,parent,false)
        return itemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.itemView.apply {
            val imageF = findViewById<ImageView>(R.id.imgRvStaggeredGrid)
            imageF.setImageResource(list[position])
        }
    }
}