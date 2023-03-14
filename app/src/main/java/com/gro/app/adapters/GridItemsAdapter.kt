package com.gro.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gro.app.R
import com.gro.app.entities.Items

open class GridItemsAdapter(
    private val items: ArrayList<Items>,
    private val viewID: Int
    ) : RecyclerView.Adapter<GridItemsAdapter.HomeItemsViewHolder>() {
    class HomeItemsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
            val imageView : ImageView = itemView.findViewById(R.id.productImage)
            val textView : TextView = itemView.findViewById(R.id.productText)
            val button : Button = itemView.findViewById(R.id.button)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewID, parent, false)

        return HomeItemsViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HomeItemsViewHolder, position: Int) {}
}