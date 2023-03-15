package com.gro.app.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.gro.app.activities.CartActivity
import com.gro.app.R
import com.gro.app.entities.Items
import com.gro.app.entities.ProductItems

class ProductItemsAdapter(
        private val items: ArrayList<Items>,
        private val context : Context,
        private val productsCartList: ArrayList<ProductItems>
    )
    : GridItemsAdapter(items, R.layout.product_grid_item) {
    override fun onBindViewHolder(holder: HomeItemsViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.name

        holder.button.setOnClickListener {
            val intent = Intent(context, CartActivity::class.java)
            val bundle = Bundle()

            productsCartList.add(ProductItems(item.name, item.type, item.image))

            bundle.putString("title", item.name)
            bundle.putSerializable("productsCartList", productsCartList)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtras(bundle)

            context.startActivity(intent)
        }
    }
}