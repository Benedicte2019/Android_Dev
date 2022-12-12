package com.example.sukafasta.database

import android.util.Log
import com.example.sukafasta.model.Product
import com.example.sukafasta.model.Service
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.toObject

class ProductDatabase {
    private val db = FirebaseFirestore.getInstance()

    //Product collection
    private val productsRef = db.collection("products")

    var allProducts = mutableListOf<Product>()

    suspend fun getAllProducts() {
        try {
            productsRef.addSnapshotListener { docSnapShot, error ->
                if (docSnapShot != null) {
                    //clear list to avoid duplicates
                    allProducts.clear()
                    for (doc in docSnapShot) {
                        //add to list
                        allProducts.add(doc.toObject())
                        Log.d("get", doc.getId())
                    }
                    Log.d("get", allProducts.size.toString())
                } else
                    if (error != null) {
                        Log.e("get", "listener error", error)
                    }
            }
        } catch (error: FirebaseFirestoreException) {
            Log.e("get", "listener error", error)
        }
    }

    suspend fun addProduct(product: Product){
        productsRef.document(product.name).set(product)
            .addOnSuccessListener { documentReference ->
                Log.d("add", "DocumentSnapshot written with ID: ${product.name}")
            }
            .addOnFailureListener { e ->
                Log.e("add", "Error adding document", e)
            }
    }

    suspend fun deleteProduct(productName: String){
        productsRef.document(productName).delete()
            .addOnSuccessListener {
                Log.d("delete", "DocumentSnapshot successfully deleted")
            }
            .addOnFailureListener { e ->
                Log.e("delete", "Error deleting document", e)
            }
    }
}