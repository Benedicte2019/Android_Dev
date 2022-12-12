package com.example.sukafasta.screen

sealed class Routes (val route: String) {
    object Login : Routes("login")
    object Register : Routes("register")
    object ForgotPassword : Routes("forgot_password")
    object Home : Routes("home")
    object Booking : Routes("booking")
    object Account : Routes("account")
    object NavBottomBar : Routes("nav_bottom_bar")
    object AddService : Routes("add_service")
    object Appointments : Routes("appointments")
}