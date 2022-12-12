package com.example.sukafasta.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ServiceViewModel: ViewModel() {
    var servicesList = mutableStateListOf<Service>()

    fun addService(newService: Service){
        servicesList.add(newService)
    }

    fun delete(service: Service){
        servicesList.remove(service)
    }
}