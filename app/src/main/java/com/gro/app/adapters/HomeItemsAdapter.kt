package com.gro.app.adapters

import android.content.Context
import android.content.Intent
import com.gro.app.entities.Items
import com.gro.app.activities.ProductsActivity
import com.gro.app.R

class HomeItemsAdapter(private val items: ArrayList<Items>, private val context : Context)
    : GridItemsAdapter(items, R.layout.home_grid_items) {
    override fun onBindViewHolder(holder: HomeItemsViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.name

        holder.button.setOnClickListener {
            val intent = Intent(context, ProductsActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;

            context.startActivity(intent)
        }
    }
}