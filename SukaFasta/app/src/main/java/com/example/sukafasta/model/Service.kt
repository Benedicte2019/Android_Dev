package com.example.sukafasta.model

import androidx.compose.ui.graphics.vector.ImageVector

<<<<<<< HEAD
class Service (var name: String, var description: String, var image: ImageVector?) {
    constructor(): this( "", "", null)
=======
data class Service (val id: String, var servName: String, var serviceDesc: String, var img: ImageVector) {
>>>>>>> ff5b743932ef70278e5f1424c390755e6354f06c
}