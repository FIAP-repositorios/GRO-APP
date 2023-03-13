package com.gro.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gro.app.entities.HomeItems
import com.gro.app.R
import com.gro.app.adapters.ProductItemsAdapter
import com.gro.app.utils.toolbarConfig

class ProductsActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var items : ArrayList<HomeItems>
    private lateinit var productItemsAdapter: ProductItemsAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        toolbar = findViewById(R.id.toolbar)

        toolbarConfig(toolbar, "Produtos")

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
        items.add(HomeItems(R.drawable.laticionios, "Maça - 200 reais"))
        items.add(HomeItems(R.drawable.fruits, "Banana - 200 reais"))
    }
}