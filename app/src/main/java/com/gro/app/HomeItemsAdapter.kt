package com.gro.app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeItemsAdapter(private val items: ArrayList<HomeItems>, private val context : Context)
    : RecyclerView.Adapter<HomeItemsAdapter.HomeItemsViewHolder>() {
    class HomeItemsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
            val imageView : ImageView = itemView.findViewById(R.id.productImage)
            val textView : TextView = itemView.findViewById(R.id.productText)
            val button : Button = itemView.findViewById(R.id.button)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.each_item, parent, false)

        return HomeItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeItemsViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.name

        holder.button.setOnClickListener {
            val intent = Intent(context, Products::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;

            context.startActivity(intent)
        }
    }
}