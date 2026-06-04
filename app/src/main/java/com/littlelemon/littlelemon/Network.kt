package com.littlelemon.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    @SerialName("menu")
    val menu: List<MenuItemNetwork> = emptyList()
)

@Serializable
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
) {
    fun toMenuItemRoom(): MenuItemRoom {
        return MenuItemRoom(
            id = id,
            title = title,
            description = description,
            price = price,
            image = image,
            category = category
        )
    }
}