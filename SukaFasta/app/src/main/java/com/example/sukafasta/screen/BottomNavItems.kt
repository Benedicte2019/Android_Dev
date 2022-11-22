package com.example.sukafasta.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person

object BottomNavItems {

    val BottomItems = listOf(
        BottomBarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BottomBarItem(
            title = "My Appointments",
            image = Icons.Filled.DateRange,
            route = "appointment"
        ),
        BottomBarItem(
            title = "Account",
            image = Icons.Filled.Person,
            route = "account"
        )

    )
}