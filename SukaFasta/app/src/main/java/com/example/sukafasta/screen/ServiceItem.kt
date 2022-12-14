package com.example.sukafasta.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sukafasta.R
import com.example.sukafasta.model.Appointment
import com.example.sukafasta.model.Service

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ServiceItem(item: Service, context: Context, deleteService: (Service) -> Unit, onItemClick: (serviceName: String) -> Unit)
{
    var showDeleteDialog by remember { mutableStateOf(false) }


    Card(
        elevation = 14.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.onSecondary,
        border = BorderStroke(2.dp, color = MaterialTheme.colors.primaryVariant),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    onItemClick(item.name)
                    Toast
                        .makeText(
                            context,
                            context.resources.getString(R.string.readmsg) + " " + item.name,
                            Toast.LENGTH_LONG
                        )
                        .show()
                },
                onLongClick = { showDeleteDialog = true }
            )

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row() {
                Column() {
                    Text(text = item.name, style = MaterialTheme.typography.h6)
                    Text(text = item.description, style = MaterialTheme.typography.body1)
                    Text(text = item.price, style = MaterialTheme.typography.body1)
//                    Text(text = item.time, style = MaterialTheme.typography.body1)


                }
            }

        }
    }
//    if (showDeleteDialog){
//        deleteServiceDialog(context, dismissDialog = {showDeleteDialog = false}, item,
//            deleteService
//        )
//    }

}
