package com.gro.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gro.app.R
import com.gro.app.adapters.ProductItemsAdapter
import com.gro.app.entities.Items
import com.gro.app.entities.ProductItems
import com.gro.app.enums.ProductEnum
import com.gro.app.utils.toolbarConfig

class ProductsActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var items : ArrayList<Items>
    private lateinit var productItemsAdapter: ProductItemsAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        toolbar = findViewById(R.id.toolbar)

        val bundle = intent.extras
        val type = bundle?.getString("type")
        val productsCartList = bundle?.getSerializable("productsCartList")
            ?: arrayListOf<ProductItems>()

        toolbarConfig(toolbar, bundle?.getString("title") ?: "Produtos")

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        init(
            ProductEnum.valueOf("$type"),
            productsCartList as ArrayList<ProductItems>
        )
    }

    private fun init(
        type : ProductEnum,
        productsCartList: ArrayList<ProductItems>
    ) {
        recyclerView = findViewById(R.id.recycleViewProduct)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        items = ArrayList()

        productItemsAdapter = ProductItemsAdapter(
            findProducts(type) as ArrayList<Items>,
            applicationContext,
            productsCartList
        )
        recyclerView.adapter = productItemsAdapter
    }

    private fun findProducts(type : ProductEnum): List<ProductItems> {
        val productList = productList()

        return productList.filter {
            it.type == type
        }
    }

    private fun productList(): ArrayList<ProductItems> {
        val products = arrayListOf<ProductItems>()

        // fruits

        products.add(ProductItems("Maça - 200 reais", ProductEnum.FRUITS, R.drawable.maca))
        products.add(ProductItems(
            "Banana - 100 reais",
            ProductEnum.FRUITS,
            R.drawable.banana
        ))
        products.add(ProductItems(
            "Abacaxi - 200 reais",
            ProductEnum.FRUITS,
            R.drawable.abacaxi
        ))
        products.add(ProductItems(
            "Abacate - 300 reais",
            ProductEnum.FRUITS,
            R.drawable.abacate
        ))

        // fish
        products.add(ProductItems(
            "Tilápia - 50 reais",
            ProductEnum.FISH,
            R.drawable.fish_product
        ))
        products.add(ProductItems(
            "Salmão - 300 reais",
            ProductEnum.FISH,
            R.drawable.fish_product
        ))

        // vegetables
        products.add(ProductItems(
            "Alface - 10 reais",
            ProductEnum.VEGETABLE,
            R.drawable.alface
        ))
        products.add(ProductItems(
            "Chuchu - 20 reais",
            ProductEnum.VEGETABLE,
            R.drawable.chuchu
        ))

        return products
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}