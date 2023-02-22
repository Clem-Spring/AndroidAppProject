package com.example.projetmobile

import android.util.Log
import com.example.projetmobile.model.Reservation
import com.example.projetmobile.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database


import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*


class ReadAndWriteSnippets {



    fun initializeDbRef(){
        database = Firebase.database.reference

    }

    /**fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email, userId)

        DataBaseHelper.database.reference.child("users").child(userId).setValue(user)
    }**/

    fun createReservation() {
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)
        val date = df.format(Date())
        val hours = mapOf("8" to User().userId)
        val reservation = Reservation(date, hours)

        DataBaseHelper.database.reference.child("Reservations").child(reservation.date).setValue(reservation)
    }

    fun writeNewUserWithTaskListeners(userId: String, name: String, email: String) {
        val user = User(name, email, userId)

        // [START rtdb_write_new_user_task]
        DataBaseHelper.database.reference.child("users").child(userId).setValue(user)
            .addOnSuccessListener {
                Log.d("a","Write successful" )
                //Toast.makeText(this,"Compte créé",Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Log.d("a","Write failed")
            }
        // [END rtdb_write_new_user_task]
    }

    fun getUser(email: String, password: String) {
        DataBaseHelper.database.getReference("users")
            .orderByChild("email")
            .equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d("dataBase", snapshot.toString())
                    if(snapshot.exists()) {
                        val user = snapshot.children.first().getValue(User::class.java)
                        if(user?.email == email) { //A changer par le mdp
                            Log.d("dataBase","connected")
                            // Connected
                        }
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("dataBase", error.toString())
                }

            })
    }
}

