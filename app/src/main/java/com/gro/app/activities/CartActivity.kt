package com.gro.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.gro.app.R
import com.gro.app.adapters.CartAdapter
import com.gro.app.databinding.ActivityMainBinding
import com.gro.app.entities.ProductItems
import com.gro.app.utils.toolbarConfig

class CartActivity : AppCompatActivity() {
    private lateinit var toolbar : Toolbar
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding
            .inflate(layoutInflater)

        setContentView(R.layout.activity_cart)

        val bundle = intent.extras
        val productsCartList = bundle?.getSerializable("productsCartList")
            ?: arrayListOf<ProductItems>()

        val listView = findViewById<ListView>(R.id.cartList)

        listView.adapter = CartAdapter(this, productsCartList as ArrayList<ProductItems>)

        toolbar = findViewById(R.id.toolbar)

        toolbarConfig(toolbar, "Carrinho")

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}