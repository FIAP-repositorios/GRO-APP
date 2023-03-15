package com.gro.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.gro.app.R
import com.gro.app.entities.ProductItems
import com.gro.app.utils.toolbarConfig

class CartActivity : AppCompatActivity() {
    private lateinit var toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val bundle = intent.extras
        val productsCartList = bundle?.getSerializable("productsCartList")
            ?: arrayListOf<ProductItems>()

        println(productsCartList)

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