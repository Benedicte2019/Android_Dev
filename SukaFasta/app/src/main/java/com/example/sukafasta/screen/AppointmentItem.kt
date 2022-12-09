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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppointmentItem(item: Appointment, context: Context, deleteAppointment: (Appointment) -> Unit)
{
    var showDeleteDialog by remember { mutableStateOf(false) }
    var done by remember { mutableStateOf(false) }


    Card(
        elevation = 14.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = changeCardColorWhenCompleted(done = done),
        contentColor = changeContentColorWhenCompleted(done = done),
        border = BorderStroke(2.dp, color = MaterialTheme.colors.primaryVariant),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(
                            context,
                            context.resources.getString(R.string.readmsg) + " " + item.serviceName,
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
                    Checkbox(checked = done, onCheckedChange = {done = !done})
                }
                Column() {
                    Text(text = item.serviceName, style = MaterialTheme.typography.h6)
                    Text(text = item.date, style = MaterialTheme.typography.body1)
                    Text(text = item.time, style = MaterialTheme.typography.body1)


                }
            }

        }
    }
    if (showDeleteDialog){
        deleteAppointmentDialog(context, dismissDialog = {showDeleteDialog = false}, item,
            deleteAppointment
        )
    }

}

@Composable
fun changeCardColorWhenCompleted(done: Boolean): Color {
    if (done){
        return MaterialTheme.colors.primary;
    }
    else
        return MaterialTheme.colors.secondary;
}
@Composable
fun changeContentColorWhenCompleted(done: Boolean): Color {
    if (done){
        return MaterialTheme.colors.onPrimary;
    }
    else
        return MaterialTheme.colors.onSecondary;
}