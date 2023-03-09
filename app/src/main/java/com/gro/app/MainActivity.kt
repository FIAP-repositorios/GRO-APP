package com.gro.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gro.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var homeItems : ArrayList<HomeItems>
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
        homeItems.add(HomeItems(R.drawable.laticionios, "Laticínios"))
        homeItems.add(HomeItems(R.drawable.fruits, "Frutas"))
        homeItems.add(HomeItems(R.drawable.vegetal, "Vegetais"))
        homeItems.add(HomeItems(R.drawable.beef, "Carnes"))
        homeItems.add(HomeItems(R.drawable.fish, "Peixes"))
        homeItems.add(HomeItems(R.drawable.ocean, "Frutos do mar"))
    }
}