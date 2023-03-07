package com.example.projetmobile.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Reservation(val date: String, val hours: Map<String, String?>) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}