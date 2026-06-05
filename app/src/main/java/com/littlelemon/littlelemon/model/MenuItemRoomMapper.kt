package com.littlelemon.littlelemon.model

import com.littlelemon.littlelemon.MenuItemRoom
import com.littlelemon.littlelemon.components.menuitems.model.ProductItem

fun MenuItemRoom.toProductItem(): ProductItem {
    return ProductItem(
        title = title,
        price = price,
        category = category,
        description = description,
        image = image
    )
}