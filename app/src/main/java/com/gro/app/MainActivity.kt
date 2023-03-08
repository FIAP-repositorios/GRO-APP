package com.gro.app

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

        homeItemsAdapter = HomeItemsAdapter(homeItems)
        recyclerView.adapter = homeItemsAdapter
    }

    private fun addHomeItemToList() {
        homeItems.add(HomeItems(R.drawable.baseline_home_24, "Test 1"))
        homeItems.add(HomeItems(R.drawable.baseline_home_24, "Test 2"))
        homeItems.add(HomeItems(R.drawable.baseline_home_24, "Test 3"))
        homeItems.add(HomeItems(R.drawable.baseline_home_24, "Test 4"))
    }
}