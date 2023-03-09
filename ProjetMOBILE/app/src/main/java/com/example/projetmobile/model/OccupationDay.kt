package com.example.projetmobile.model

data class OccupationDay(var date: String, var hours: List<String>) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}
