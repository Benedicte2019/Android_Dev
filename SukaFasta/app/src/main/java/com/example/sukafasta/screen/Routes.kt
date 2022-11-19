package com.example.sukafasta.screen

sealed class Routes (val route: String) {
    object Login : Routes("login")
    object Register : Routes("register")
    object ForgotPassword : Routes("forgot_password")
}