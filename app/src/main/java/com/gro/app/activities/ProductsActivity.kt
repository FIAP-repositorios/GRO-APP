package com.gro.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gro.app.entities.Items
import com.gro.app.R
import com.gro.app.adapters.ProductItemsAdapter

class ProductsActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var items : ArrayList<Items>
    private lateinit var productItemsAdapter: ProductItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        init()
    }

    private fun init() {
        recyclerView = findViewById(R.id.recycleViewProduct)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        items = ArrayList()

        addItemToList()

        productItemsAdapter = ProductItemsAdapter(items, applicationContext)
        recyclerView.adapter = productItemsAdapter
    }

    private fun addItemToList() {
        items.add(Items(R.drawable.laticionios, "Maça - 200 reais"))
        items.add(Items(R.drawable.fruits, "Banana - 200 reais"))
    }
}