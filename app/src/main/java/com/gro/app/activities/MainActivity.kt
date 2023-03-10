package com.gro.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gro.app.entities.Items
import com.gro.app.R
import com.gro.app.adapters.HomeItemsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var homeItems : ArrayList<Items>
    private lateinit var homeItemsAdapter: HomeItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_home)

        init()
    }

    private fun init() {
        recyclerView = findViewById(R.id.recycleView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        homeItems = ArrayList()

        addHomeItemToList()

        homeItemsAdapter = HomeItemsAdapter(homeItems, applicationContext)
        recyclerView.adapter = homeItemsAdapter
    }

    private fun addHomeItemToList() {
        homeItems.add(Items(R.drawable.laticionios, "Laticínios"))
        homeItems.add(Items(R.drawable.fruits, "Frutas"))
        homeItems.add(Items(R.drawable.vegetal, "Vegetais"))
        homeItems.add(Items(R.drawable.beef, "Carnes"))
        homeItems.add(Items(R.drawable.fish, "Peixes"))
        homeItems.add(Items(R.drawable.ocean, "Frutos do mar"))
    }
}