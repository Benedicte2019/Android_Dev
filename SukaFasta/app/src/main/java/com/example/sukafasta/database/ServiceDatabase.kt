package com.example.sukafasta.database

import android.util.Log
import com.example.sukafasta.model.Service
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.toObject

class ServiceDatabase {
    private val db = FirebaseFirestore.getInstance()

    //Service collection
    private val servicesRef = db.collection("services")

    var allServices = mutableListOf<Service>()

    suspend fun getAllServices() {
        try {
            servicesRef.addSnapshotListener { docSnapShot, error ->
                if (docSnapShot != null) {
                    //clear list to avoid duplicates
                    allServices.clear()
                    for (doc in docSnapShot) {
                        //add to list
                        allServices.add(doc.toObject())
                        Log.d("get", doc.getId())
                    }
                    Log.d("get", allServices.size.toString())
                } else
                    if (error != null) {
                        Log.e("get", "listener error", error)
                    }
            }
        } catch (error: FirebaseFirestoreException) {
            Log.e("get", "listener error", error)
        }
    }

    suspend fun addService(service: Service){
        servicesRef.document(service.name).set(service)
            .addOnSuccessListener { documentReference ->
                Log.d("add", "DocumentSnapshot written with ID: ${service.name}")
            }
            .addOnFailureListener { e ->
                Log.e("add", "Error adding document", e)
            }
    }

    suspend fun deleteService(serviceName: String){
        servicesRef.document(serviceName).delete()
            .addOnSuccessListener {
                Log.d("delete", "DocumentSnapshot successfully deleted")
            }
            .addOnFailureListener { e ->
                Log.e("delete", "Error deleting document", e)
            }
    }
}