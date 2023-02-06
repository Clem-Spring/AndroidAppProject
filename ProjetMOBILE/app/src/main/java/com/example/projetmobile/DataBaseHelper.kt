package com.example.projetmobile

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DataBaseHelper {
    companion object{
        val database = Firebase.database("https://console.firebase.google.com/project/projetmobile-a1362/database/projetmobile-a1362-default-rtdb/data/~2F")
    }
}