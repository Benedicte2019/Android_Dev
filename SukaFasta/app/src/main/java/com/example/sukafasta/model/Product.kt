package com.example.sukafasta.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.google.firebase.firestore.DocumentId

class Product(var name: String, var description: String, var service: String, var price: String, var image: ImageVector?) {
    constructor(): this("", "", "", "2000 RWF", null)
}