package com.example.sukafasta.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class AppointmentViewModel: ViewModel() {
    var clientAppointmentList = mutableStateListOf<Appointment>()

    fun add(newAppointment: Appointment) {
        clientAppointmentList.add(newAppointment)
    }

    fun delete(appointment: Appointment) {
        clientAppointmentList.remove(appointment)
    }
}