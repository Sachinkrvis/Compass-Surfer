package com.example.kotlin_fragment_lrn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kotlin_fragment_lrn.R
import com.example.kotlin_fragment_lrn.adapterContainer.container_newFeed
import java.util.*

class adapter_newFeed(var list: ArrayList<container_newFeed>) :
    RecyclerView.Adapter<myviewHolder2>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder2 {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.newfeed_item_recyclerview_blueprint, parent, false)
        return myviewHolder2(view)
    }

    override fun onBindViewHolder(holder: myviewHolder2, position: Int) {
val data=list.get(position)
        holder.title.text=data.news
        holder.description.text="this is just a dummy description which is use to display the content on the screen"

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class myviewHolder2(itemview: View) : ViewHolder(itemview) {
    val title: TextView = itemview.findViewById(R.id.recentTitle_tv)
    val description: TextView = itemview.findViewById(R.id.recentDescription_tv)

}

