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

        toolbarConfig(toolbar, bundle?.getString("title") ?: "Produtos")

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        init(ProductEnum.valueOf("$type"))
    }

    private fun init(type : ProductEnum) {
        recyclerView = findViewById(R.id.recycleViewProduct)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        items = ArrayList()

        productItemsAdapter = ProductItemsAdapter(findProducts(type) as ArrayList<Items>, applicationContext)
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

        products.add(ProductItems("Maça", ProductEnum.FRUITS, R.drawable.fruits))
        products.add(ProductItems("Banana", ProductEnum.FRUITS, R.drawable.fruits))
        products.add(ProductItems("Abacaxi", ProductEnum.FRUITS, R.drawable.fruits))
        products.add(ProductItems("Abacate", ProductEnum.FRUITS, R.drawable.fruits))

        // fish
        products.add(ProductItems("Tilápia", ProductEnum.FISH, R.drawable.fish))
        products.add(ProductItems("Salmão", ProductEnum.FISH, R.drawable.fish))

        // vegetables
        products.add(ProductItems("Alface", ProductEnum.VEGETABLE, R.drawable.vegetal))
        products.add(ProductItems("Chuchu", ProductEnum.VEGETABLE, R.drawable.vegetal))

        return products
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}