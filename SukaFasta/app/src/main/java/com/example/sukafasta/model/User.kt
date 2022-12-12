package com.example.sukafasta.model

import com.google.firebase.firestore.DocumentId

data class User (val name: String, val email: String, val phoneNumber: String, val role: String, val password: String) {
        constructor(): this("Name", "Email", "Phone", "Client", "Password"){}
}