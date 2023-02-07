package com.example.projetmobile

import com.example.projetmobile.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database


import com.google.firebase.ktx.Firebase

private lateinit var database: DatabaseReference
public class ReadAndWriteSnippets {



    fun initializeDbRef(){
        database = Firebase.database.reference

    }

    fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email, userId)

        DataBaseHelper.database.child("User").child(userId).setValue(user)
    }
}

