package com.gro.app.adapters

import android.content.Context
import android.content.Intent
import com.gro.app.activities.CartActivity
import com.gro.app.entities.Items
import com.gro.app.R

class ProductItemsAdapter(private val items: ArrayList<Items>, private val context : Context)
    : GridItemsAdapter(items, R.layout.product_grid_item) {
    override fun onBindViewHolder(holder: HomeItemsViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.name

        holder.button.setOnClickListener {
            val intent = Intent(context, CartActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;

            context.startActivity(intent)
        }
    }
}