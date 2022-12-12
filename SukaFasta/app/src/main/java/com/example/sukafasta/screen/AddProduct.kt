package com.example.sukafasta.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sukafasta.model.Product
import com.example.sukafasta.model.Service

@Composable
fun AddProduct(productList: MutableList<Product>, addProduct: (Product) -> Unit, deleteProduct: (Product) -> Unit, phoneNumber: String? = "", )
{
//    val viewModel: AppointmentViewModel = viewModel();
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 40.dp),
                onClick = {showDialog = true}

            )
            {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        },
        content = {
            if (showDialog){
                addProductDialog(context, dismissDialog = {showDialog = false}, {addProduct(it)})
            }
            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 18.dp,
                    horizontal = 8.dp
                ),
                modifier = Modifier
                    .padding(8.dp)

            ) {


                items(productList, key = { product -> product.name }) { product ->

                    ProductItem(item = product, context, {deleteProduct(it)})
                }
            }

        })
}