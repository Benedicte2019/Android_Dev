package com.example.sukafasta.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.sukafasta.model.Service
import com.example.sukafasta.R
import com.example.sukafasta.model.Product

@Composable
fun deleteProductDialog(context: Context, dismissDialog:() -> Unit, item: Product, deleteProduct: (Product) -> Unit){
    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={ Text(text = stringResource(id = R.string.delete_product), style = MaterialTheme.typography.h6) },
        confirmButton = {
            Button(onClick = {
                deleteProduct(item)
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.product_deleted),
                    Toast.LENGTH_SHORT
                ).show()
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.yes))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.no))
            }
        }
    )
}