package com.gro.app.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.gro.app.R
import com.gro.app.entities.ProductItems
import org.w3c.dom.Text

class CartAdapter(
    private val context : Activity,
    private val list : ArrayList<ProductItems>
) : ArrayAdapter<ProductItems>(
    context,
    R.layout.cart_listview,
    list
) {
    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.cart_listview, null)

        val productImageView : ImageView = view.findViewById(R.id.productImage)
        val productName : TextView = view.findViewById(R.id.productCartText)

        productImageView.setImageResource(list[position].image)
        productName.text = list[position].name

        return view
    }
}