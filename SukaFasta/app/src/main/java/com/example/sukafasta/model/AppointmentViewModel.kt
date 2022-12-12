package com.example.sukafasta.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sukafasta.database.AppointmentDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppointmentViewModel: ViewModel() {
//    var clientAppointmentList = mutableStateListOf<Appointment>()
//
//    fun add(newAppointment: Appointment) {
//        clientAppointmentList.add(newAppointment)
//    }
//
//    fun delete(appointment: Appointment) {
//        clientAppointmentList.remove(appointment)
//    }
private val appointmentDB = AppointmentDatabase()

    var appointmentList = appointmentDB.allAppointments

    init {
        viewModelScope.launch(Dispatchers.IO) { appointmentDB.getAllAppointments() }
    }

    fun addAppointment(appointment: Appointment) = viewModelScope.launch(Dispatchers.IO){
        appointmentDB.addAppointment(appointment)
    }

    fun deleteAppointment(appointment: Appointment) = viewModelScope.launch(Dispatchers.IO){
        appointmentDB.deleteAppointment(appointment.id)
    }
}