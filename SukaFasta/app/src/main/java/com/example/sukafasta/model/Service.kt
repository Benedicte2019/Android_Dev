package com.example.sukafasta.model

import androidx.compose.ui.graphics.vector.ImageVector

class Service (var name: String, var description: String, var image: ImageVector?) {
    constructor(): this( "", "", null)
}