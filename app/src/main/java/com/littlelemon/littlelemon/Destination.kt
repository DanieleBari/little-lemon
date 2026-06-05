package com.littlelemon.littlelemon

interface Destinations {
    val route: String
}

object HomeDestination:Destinations{ // keyword object create an object without having a class
    override val route = "home"
}

object OnboardingDestination:Destinations{
    override val route = "onboarding"
}

object ProfileDestination:Destinations{
    override val route = "profile"
}