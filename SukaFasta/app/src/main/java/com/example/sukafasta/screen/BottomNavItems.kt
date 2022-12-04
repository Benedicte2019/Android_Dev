package com.example.sukafasta.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object BottomNavItems {

    val BottomItems = listOf(
        BottomBarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BottomBarItem(
            title = "Booking",
            image = Icons.Filled.DateRange,
            route = "appointment"
        ),
        BottomBarItem(
            title = "Add Service",
            image = Icons.Filled.AddCircle,
            route = "add_service"
        ),

//        BottomBarItem(
//            title = "Account",
//            image = Icons.Filled.Person,
//            route = "account"
//        ),

        BottomBarItem(
            title = "Appointments",
            image = Icons.Filled.List,
            route = "appointments"
        ),

    )
}