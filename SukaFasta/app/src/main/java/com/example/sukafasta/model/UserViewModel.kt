package com.example.sukafasta.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sukafasta.database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val userDB = UserDatabase()

    var userList = userDB.allUsers

    init {
        viewModelScope.launch(Dispatchers.IO) { userDB.getAllUsers() }
    }

    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO){
        userDB.addUser(user)
    }

    fun deleteUser(phoneNumber: String) = viewModelScope.launch(Dispatchers.IO){
        userDB.deleteUser(phoneNumber)
    }

}