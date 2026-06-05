package com.littlelemon.littlelemon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationComposable(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    isUserRegistered: Boolean,
    database: AppDatabase
) {
    NavHost(
        navController = navController,
        startDestination = if (isUserRegistered) "home" else "onboarding",
        modifier = modifier
    ) {
        composable("home") {
            HomeRoute(
                navController = navController,
                database = database
            )
        }

        composable("profile") {
            Profile(navController = navController)
        }

        composable("onboarding") {
            Onboarding(navController = navController)
        }
    }
}