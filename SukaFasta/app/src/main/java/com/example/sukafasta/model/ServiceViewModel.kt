package com.example.sukafasta.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sukafasta.database.ServiceDatabase
import com.example.sukafasta.database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceViewModel: ViewModel() {
//    var servicesList = mutableStateListOf<Service>()
//
//    fun addService(newService: Service){
//        servicesList.add(newService)
//    }
//
//    fun delete(service: Service){
//        servicesList.remove(service)
//    }

    private val serviceDB = ServiceDatabase()

    var serviceList = serviceDB.allServices

    init {
        viewModelScope.launch(Dispatchers.IO) { serviceDB.getAllServices() }
    }

    fun addService(service: Service) = viewModelScope.launch(Dispatchers.IO){
        serviceDB.addService(service)
    }

    fun deleteService(service: Service) = viewModelScope.launch(Dispatchers.IO){
        serviceDB.deleteService(service.name)
    }
}