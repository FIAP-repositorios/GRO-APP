package com.gro.app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup

class ProductItemsAdapter(private val items: ArrayList<HomeItems>, private val context : Context)
    : GridItemsAdapter(items, context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_grid_item, parent, false)

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