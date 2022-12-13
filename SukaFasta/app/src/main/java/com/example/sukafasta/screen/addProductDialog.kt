package com.example.sukafasta.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.sukafasta.model.Product
import com.example.sukafasta.R

@Composable
fun addProductDialog(context: Context, dismissDialog:() -> Unit, addProduct:(Product) -> Unit){
    var ProductTextField by remember {
        mutableStateOf("")
    }
    var productDescriptionTextField by remember {
        mutableStateOf("")
    }
    var priceTextField by remember {
        mutableStateOf("")
    }
    var serviceTextField by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={Text(text = stringResource(id = R.string.add_product), style = MaterialTheme.typography.h6)},
        text = {
            Column(modifier = Modifier.padding(top=20.dp)) {
                TextField(label = {Text(text=stringResource(id = R.string.product_name))}, value = ProductTextField, onValueChange = {ProductTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = {Text(text=stringResource(id = R.string.product_description))},value = productDescriptionTextField, onValueChange = {productDescriptionTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = {Text(text=stringResource(id = R.string.product_price))},value = priceTextField, onValueChange = {priceTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = {Text(text=stringResource(id = R.string.service_name))},value = serviceTextField, onValueChange = {serviceTextField=it})
            }
        },
        confirmButton = {
            Button(onClick = {
                if(ProductTextField.isNotEmpty()) {
//                    val newID = UUID.randomUUID().toString();
                    addProduct(Product(ProductTextField, productDescriptionTextField, serviceTextField,priceTextField, null))
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.product_added),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.add))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}