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
import com.example.sukafasta.model.Appointment
import com.example.sukafasta.model.Product
import com.example.sukafasta.model.Service

@Composable
fun ServiceDetail(productList: MutableList<Product>, deleteProduct: (Product) -> Unit, phoneNumber: String? = "", serviceName: String? = "")
{
//    val viewModel: AppointmentViewModel = viewModel();
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(

        content = {
            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 18.dp,
                    horizontal = 8.dp
                ),
                modifier = Modifier
                    .padding(8.dp)

            ) {
                var productMatchingSerivceList = mutableStateListOf<Product>();

                for (product in productList)
                {
                    if (product.service.equals(serviceName, true))
                        productMatchingSerivceList.add(product)
                }

                items(productMatchingSerivceList, key = { product -> product.name }) { product ->

                    ProductItem(item = product, context, {deleteProduct(it)})
                }
            }

        })
}