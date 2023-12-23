package com.example.kotlin_fragment_lrn.adapters

import android.app.Dialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kotlin_fragment_lrn.R
import com.example.kotlin_fragment_lrn.adapterContainer.container
import com.example.kotlin_fragment_lrn.maps.MapsActivity

class adapter_recents(var list: ArrayList<container>):RecyclerView.Adapter<myViewholder1>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewholder1 {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.recent_item_recyclerview_blueprint,parent,false)
        return myViewholder1(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myViewholder1, position: Int) {
       val data=list.get(position)
        holder.imageView.setImageResource(data.photo)
        holder.textView.text=data.text
        holder.button_navigate.setOnClickListener {
            val intent=Intent(it.context,MapsActivity::class.java)
            it.context.startActivity(intent)
        }
        holder.view_button.setOnClickListener {
            holder.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            holder.dialog.setCancelable(true)
            holder.dialog.setContentView(R.layout.activity_dialog_view)
            holder.dialog.show()

        }

    }


}

class myViewholder1(itemView: View) :ViewHolder(itemView) {

    val imageView:ImageView=itemView.findViewById(R.id.image_photoview)
    val textView:TextView=itemView.findViewById(R.id.textview_item)
    val button_navigate:Button=itemView.findViewById(R.id.navigate)
    val view_button:Button=itemView.findViewById(R.id.viewAcount)
    val dialog:Dialog=Dialog(itemView.context)





}


