package com.example.sukafasta.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sukafasta.model.Appointment
import com.example.sukafasta.model.AppointmentViewModel

@Composable
fun ClientAppointmentsScreen(appointmentList: List<Appointment>, deleteAppointment: (Appointment) -> Unit)
{
//    val viewModel: AppointmentViewModel = viewModel();
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        content = {
            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 8.dp
                ),
                modifier = Modifier
                    .padding(8.dp)

            ) {
                items(appointmentList, key = {appointment -> appointment.id }) { appointment ->
                    AppointmentItem(item = appointment, context, {deleteAppointment(it)})
                }
            }

        })
}