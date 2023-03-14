package com.gro.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gro.app.entities.HomeItems
import com.gro.app.R
import com.gro.app.adapters.HomeItemsAdapter
import com.gro.app.entities.Items
import com.gro.app.enums.ProductEnum.*

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
        homeItems.add(HomeItems(R.drawable.dairy, "Laticínios", DAIRY))
        homeItems.add(HomeItems(R.drawable.fruits, "Frutas", FRUITS))
        homeItems.add(HomeItems(R.drawable.vegetal, "Vegetais", VEGETABLE))
        homeItems.add(HomeItems(R.drawable.beef, "Carnes", BEEF))
        homeItems.add(HomeItems(R.drawable.fish, "Peixes", FISH))
        homeItems.add(HomeItems(R.drawable.ocean, "Frutos do mar", OCEAN))
    }
}