package com.littlelemon.littlelemon

import Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.littlelemon.littlelemon.model.toProductItem


@Composable
fun HomeRoute(
    navController: NavHostController,
    database: AppDatabase
) {
    val menuItemsRoom by database
        .menuItemDao()
        .getAll()
        .observeAsState(emptyList())

    val productItems = menuItemsRoom.map { menuItemRoom ->
        menuItemRoom.toProductItem()
    }

    Home(
        navController = navController,
        products = productItems
    )
}
