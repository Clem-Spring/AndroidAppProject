package com.example.projetmobile

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DataBaseHelper {
    companion object{
        val database = Firebase.database("https://projetmobile-a1362-default-rtdb.firebaseio.com/")
    }
}