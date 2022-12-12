package com.example.sukafasta.database

import android.util.Log
import com.example.sukafasta.model.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class UserDatabase {
    private val db = FirebaseFirestore.getInstance()

    //users collection
    private val usersRef = db.collection("users")

    var allUsers = mutableListOf<User>()

    suspend fun getAllUsers() {
        try {
            usersRef.addSnapshotListener { docSnapShot, error ->
                if (docSnapShot != null) {
                    //clear list to avoid duplicates
                    allUsers.clear()
                    for (doc in docSnapShot) {
                        //add to list
                        allUsers.add(doc.toObject())
                        Log.d("get", doc.getId())
                    }
                    Log.d("get", allUsers.size.toString())
                } else
                    if (error != null) {
                        Log.e("get", "listener error", error)
                    }
            }
        } catch (error: FirebaseFirestoreException) {
            Log.e("get", "listener error", error)
        }
    }

    suspend fun addUser(user: User){
        usersRef.add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("add", "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.e("add", "Error adding document", e)
            }
    }

    suspend fun deleteUser(phoneNumber: String){
        usersRef.document(phoneNumber).delete()
            .addOnSuccessListener {
                Log.d("delete", "DocumentSnapshot successfully deleted")
            }
            .addOnFailureListener { e ->
                Log.e("delete", "Error deleting document", e)
            }
    }
}