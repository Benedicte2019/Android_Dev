package com.example.sukafasta.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ProductViewModel: ViewModel() {
    var productsList = mutableStateListOf<Product>()

    fun addProduct(newProduct: Product){
        productsList.add(newProduct)
    }
}