package com.example.sukafasta.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object BottomNavItems {

    val BottomItems = listOf(
//        BottomBarItem(
//            title = "Home",
//            image = Icons.Filled.Home,
//            route = "home"
//        ),
        BottomBarItem(
            title = "Booking",
            image = Icons.Filled.DateRange,
            route = "booking"
        ),
        BottomBarItem(
            title = "Add Service",
            image = Icons.Filled.AddCircle,
            route = "add_service"
        ),

        BottomBarItem(
            title = "Add Product",
            image = Icons.Filled.Add,
            route = "add_product"
        ),

        BottomBarItem(
            title = "Bookings",
            image = Icons.Filled.List,
            route = "appointments"
        ),

    )
}