package com.littlelemon.littlelemon.components.menuitems.model

data class ProductItem(
    val title: String,
    val price: String,
    val description: String,
    val category: String,
    val image: String
)

data class Products(val items: List<ProductItem>)