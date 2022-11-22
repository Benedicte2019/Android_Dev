package com.example.sukafasta.screen

sealed class ScreenRoutes(val route: String){
    object Home : ScreenRoutes("home")
    object Booking : ScreenRoutes("appointment")
    object Account : ScreenRoutes("account")
}
