package com.example.sukafasta.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sukafasta.model.Appointment
import com.example.sukafasta.model.AppointmentViewModel
import com.example.sukafasta.model.User

@Composable
fun ClientAppointmentsScreen(appointmentList: List<Appointment>, userList: List<User>, deleteAppointment: (Appointment) -> Unit, phoneNumber: String? = "", )
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
                var clientAppointmentList = mutableStateListOf<Appointment>();

                for (user in userList)
                {
                    if (user.phoneNumber.equals(phoneNumber) && user.role.equals("hairdresser", true))
                        for (appointment in appointmentList)
                            clientAppointmentList.add(appointment)
                    else if (user.phoneNumber.equals(phoneNumber)) {
                        for (appointment in appointmentList)
                        {
                            if (appointment.phoneNumber.equals(phoneNumber))
                                clientAppointmentList.add(appointment)
                        }
                    }
                }


                items(clientAppointmentList, key = {appointment -> appointment.id }) { appointment ->

                    AppointmentItem(item = appointment, context, {deleteAppointment(it)})
                }
            }

        })
}