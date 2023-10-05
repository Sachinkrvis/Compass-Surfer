package com.example.kotlin_fragment_lrn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kotlin_fragment_lrn.R
import com.example.kotlin_fragment_lrn.container

class adapter(var list:ArrayList<container>):RecyclerView.Adapter<myViewholder1>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewholder1 {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view_on_recyclerview_blueprint,parent,false)
        return myViewholder1(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myViewholder1, position: Int) {
       val data=list.get(position)
        holder.imageView.setImageResource(data.photo)
        holder.textView.text=data.text
    }

}

class myViewholder1(itemView: View) :ViewHolder(itemView) {

    val imageView:ImageView=itemView.findViewById(R.id.image_photoview)
    val textView:TextView=itemView.findViewById(R.id.textview_item)

}

