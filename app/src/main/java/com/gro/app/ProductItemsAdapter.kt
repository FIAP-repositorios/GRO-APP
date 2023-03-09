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

class ProductItemsAdapter(private val items: ArrayList<HomeItems>, private val context : Context)
    : HomeItemsAdapter(items, context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)

        return HomeItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeItemsViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.name

        holder.button.setOnClickListener {
            val intent = Intent(context, Cart::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;

            context.startActivity(intent)
        }
    }
}