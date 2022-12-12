package com.example.sukafasta.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object BottomNavItems {

    val BottomItems = listOf(
        BottomBarItem(
            title = "Booking",
            image = Icons.Filled.DateRange,
            route = "booking",
            visibleTo = "client"
        ),
        BottomBarItem(
            title = "Service",
            image = Icons.Filled.AddCircle,
            route = "add_service",
            visibleTo = "hairdresser"
        ),

        BottomBarItem(
            title = "Product",
            image = Icons.Filled.Add,
            route = "add_product",
            visibleTo = "hairdresser"
        ),

        BottomBarItem(
            title = "Appointments",
            image = Icons.Filled.List,
            route = "appointments",
            visibleTo = "all"
        )

    )
}