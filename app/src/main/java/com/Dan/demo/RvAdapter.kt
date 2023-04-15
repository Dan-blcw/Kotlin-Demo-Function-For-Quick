package com.Dan.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(var list:List<OutDataRecycler>, val rvUtil: RvUtil): RecyclerView.Adapter<RvAdapter.TilleView>() {
    // class Viewholder
    inner class TilleView(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TilleView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recyclerview, parent,false)
        return TilleView(view)
    }

    override fun onBindViewHolder(holder: TilleView, position: Int) {
        holder.itemView.apply {
            val image = findViewById<ImageView>(R.id.imgRecycler)
            val title = findViewById<TextView>(R.id.txtRecyclerTitle)
            val desc = findViewById<TextView>(R.id.txtRecyclerDesc)

            title.text = list[position].title
            desc.text = list[position].descripl
            image.setImageResource(list[position].image)

            // lắng nghe item click chọn
            holder.itemView.setOnClickListener {
                rvUtil.OnClickTitle(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}