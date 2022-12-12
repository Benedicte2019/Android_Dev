package com.example.sukafasta.database

import android.util.Log
import com.example.sukafasta.model.Appointment
import com.example.sukafasta.model.Service
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.toObject

class AppointmentDatabase {
    private val db = FirebaseFirestore.getInstance()

    //users collection
    private val appointmentsRef = db.collection("appointments")

    var allAppointments = mutableListOf<Appointment>()

    suspend fun getAllAppointments() {
        try {
            appointmentsRef.addSnapshotListener { docSnapShot, error ->
                if (docSnapShot != null) {
                    //clear list to avoid duplicates
                    allAppointments.clear()
                    for (doc in docSnapShot) {
                        //add to list
                        allAppointments.add(doc.toObject())
                        Log.d("get", doc.getId())
                    }
                    Log.d("get", allAppointments.size.toString())
                } else
                    if (error != null) {
                        Log.e("get", "listener error", error)
                    }
            }
        } catch (error: FirebaseFirestoreException) {
            Log.e("get", "listener error", error)
        }
    }

    suspend fun addAppointment(appointment: Appointment){
        appointmentsRef.add(appointment)
            .addOnSuccessListener { documentReference ->
                Log.d("add", "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.e("add", "Error adding document", e)
            }
    }

    suspend fun deleteAppointment(id: String){
        appointmentsRef.document(id).delete()
            .addOnSuccessListener {
                Log.d("delete", "DocumentSnapshot successfully deleted")
            }
            .addOnFailureListener { e ->
                Log.e("delete", "Error deleting document", e)
            }
    }
}