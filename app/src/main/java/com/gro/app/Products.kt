package com.gro.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Products : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var homeItems : ArrayList<HomeItems>
    private lateinit var homeItemsAdapter: ProductItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        init()
    }

    private fun init() {
        recyclerView = findViewById(R.id.recycleViewProduct)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        homeItems = ArrayList()

        addHomeItemToList()

        homeItemsAdapter = ProductItemsAdapter(homeItems, applicationContext)
        recyclerView.adapter = homeItemsAdapter
    }

    private fun addHomeItemToList() {
        homeItems.add(HomeItems(R.drawable.laticionios, "Maça - 200 reais"))
        homeItems.add(HomeItems(R.drawable.fruits, "Banana - 100 reais"))
    }
}