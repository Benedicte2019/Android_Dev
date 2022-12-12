package com.example.sukafasta.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sukafasta.database.ProductDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
//    var productsList = mutableStateListOf<Product>()
//
//    fun addProduct(newProduct: Product){
//        productsList.add(newProduct)
//    }

    private val productDB = ProductDatabase()

    var productList = productDB.allProducts

    init {
        viewModelScope.launch(Dispatchers.IO) { productDB.getAllProducts() }
    }

    fun addProduct(product: Product) = viewModelScope.launch(Dispatchers.IO){
        productDB.addProduct(product)
    }

    fun deleteProduct(product: Product) = viewModelScope.launch(Dispatchers.IO){
        productDB.deleteProduct(product.name)
    }
}