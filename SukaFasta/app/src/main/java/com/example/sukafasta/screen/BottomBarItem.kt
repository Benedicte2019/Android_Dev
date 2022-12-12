package com.example.sukafasta.screen

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(
    val title: String,
    val image: ImageVector,
    val route: String,
    val visibleTo: String
)
