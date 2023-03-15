package com.gro.app.entities

import com.gro.app.enums.ProductEnum
import java.io.Serializable

interface Items {
    val image: Int
    val name: String
    val type : ProductEnum
}

data class HomeItems(
    override val image: Int,
    override val name: String,
    override val type : ProductEnum
) : Items

data class ProductItems(
    override val name : String,
    override val type : ProductEnum,
    override val image : Int
) : Items, Serializable