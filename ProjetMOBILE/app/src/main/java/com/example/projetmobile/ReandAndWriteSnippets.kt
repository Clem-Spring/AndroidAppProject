package com.example.projetmobile

import com.example.projetmobile.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database


import com.google.firebase.ktx.Firebase


class ReandAndWriteSnippets {

    private lateinit var database: DatabaseReference

    fun initializeDbRef(){
        database = Firebase.database.reference

    }

    fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email)

        database.child("users").child(userId).setValue(user)
    }
}