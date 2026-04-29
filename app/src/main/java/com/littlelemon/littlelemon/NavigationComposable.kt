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
    isUserRegistered: Boolean?
    ) {
    if (isUserRegistered == null){
        return
    }
    val startDestination =
        if (isUserRegistered) {
            HomeDestination.route
        } else {
            OnboardingDestination.route

        }

    NavHost(
        navController = navController,
        startDestination = startDestination)
    {
        composable(HomeDestination.route) {
            Home(navController)
        }
        composable(ProfileDestination.route) {
            Profile(modifier, navController)
        }
        composable(OnboardingDestination.route) {
            Onboarding(modifier, navController)
        }
    }
}