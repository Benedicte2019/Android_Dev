package com.example.sukafasta.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.google.firebase.firestore.DocumentId

<<<<<<< HEAD
class Product(var name: String, var description: String, var service: String, var image: ImageVector?) {
    constructor(): this("", "", "", null)
=======
data class Product(val id: String, var prodName: String, var prodDesc: String, var prodImg: ImageVector) {
>>>>>>> ff5b743932ef70278e5f1424c390755e6354f06c
}