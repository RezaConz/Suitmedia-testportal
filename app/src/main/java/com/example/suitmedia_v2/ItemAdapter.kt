package com.example.suitmedia_v2

import android.content.Context
import android.content.Intent
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmedia_v2.R
import com.example.suitmedia_v2.network.models.BaseClass
import com.example.suitmedia_v2.network.models.UserClass

class ItemAdapter(val context: Context, val dataset:List<UserClass>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageView=view.findViewById<ImageView>(R.id.userImage)
        val text1=view.findViewById<TextView>(R.id.textView1)
        val text2=view.findViewById<TextView>(R.id.textView2)
        val email=view.findViewById<TextView>(R.id.email)
        val card=view.findViewById<CardView>(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=dataset[position]
        Glide.with(context).load(item.avatar).into(holder.imageView)
        holder.text1.text=item.lastName
        holder.text2.text=item.firstName
        holder.email.text=item.email
        holder.card.setOnClickListener {
            Intent(context,SecondActivity::class.java).also { it.putExtra("firstname",item.firstName) }.also { it.putExtra("lastname",item.lastName) }.also{context.startActivity(it)}
        }
    }

    override fun getItemCount(): Int {
       return dataset.size
    }

}