package com.example.projetmobile

import android.content.ContentValues.TAG
import android.util.Log
import com.example.projetmobile.model.OccupationDay
import com.example.projetmobile.model.Reservation
import com.example.projetmobile.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue


import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

var currentUser: User? = null
class ReadAndWriteSnippets {




    fun initializeDbRef(){
        database = Firebase.database.reference

    }

    /**fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email, userId)

        DataBaseHelper.database.reference.child("users").child(userId).setValue(user)
    }**/

    fun createReservation(heure: String, date: String) {
        //val df = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)
        //val date = df.format(Date())
        val hours = mapOf(heure to currentUser?.userId)
        val reservation = Reservation(date, hours )
        Log.d("test",date)

        DataBaseHelper.database.reference.child("Reservations").child(reservation.date).setValue(reservation)
    }

    fun deleteReservation(heure: String, date: String){
        val hour = mapOf(heure to currentUser?.userId)
        DataBaseHelper.database.getReference("Reservations").orderByChild("date")
            .equalTo(currentUser?.userId)
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot){
                    if (snapshot.exists()){
                        snapshot.ref.removeValue()
                        Log.d("dataBase","reservation deleted")
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("dataBase", error.toString())
                }
            })
    }

    fun removeFromBooking(heure: String, date: String){
        DataBaseHelper.database.getReference("occupationDays").orderByChild("date")
            .equalTo(date)
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot){
                    if (snapshot.exists()){
                        snapshot.ref.removeValue()
                        val book = snapshot.children.first().getValue(OccupationDay::class.java)
                        for (i in book?.hours!!) {
                            if (i == currentUser?.userId) {

                            }
                        }
                        Log.d("dataBase","reservation deleted")
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("dataBase", error.toString())
                }
            })
    }




    fun writeNewUserWithTaskListeners(userId: String, name: String, password: String) {
        val user = User(name, userId, password)

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
            .orderByChild("username")
            .equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d("dataBase", snapshot.toString())
                    if(snapshot.exists()) {
                        val user = snapshot.children.first().getValue(User::class.java)
                        if(user?.password == password) { //A changer par le mdp
                            Log.d("dataBase","connected")
                            // Connected
                            currentUser = user

                            Log.i(TAG, "Successfully signed in user ${currentUser?.userId}")
                        }
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("dataBase", error.toString())
                }

            })
    }

    fun getCurrentUser(){
        currentUser?.let { user -> }
    }

    fun addBooking(){
        val clickHour=1;
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)
        val date = df.format(Date())
        DataBaseHelper.database.getReference("occupationDays").child(date)
            .orderByChild("hours")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d("dataBase", snapshot.toString())
                    if(snapshot.exists()) {
                        var listBooking = snapshot.getValue(OccupationDay::class.java)

                        if (listBooking == null) {
                            createBooking(clickHour);
                        }

                        if (listBooking != null) {
                            listBooking.hours = listBooking.hours.toMutableList()

                            if (listBooking.hours?.get(clickHour) == "" ) {

                                (listBooking.hours as MutableList<String>?)?.set(clickHour, currentUser?.userId.toString())
                                DataBaseHelper.database.reference.child("occupationDays").child(listBooking.date).setValue(listBooking)
                                Log.d("dataBase", "booking added")

                            } else {
                                Log.d("dataBase", "booking already exist")
                            }
                            //(listBooking.hours as MutableList<String>?)?.set(clickHour, currentUser?.userId.toString())
                            //DataBaseHelper.database.reference.child("occupationDays").child(listBooking.date).setValue(listBooking)
                        }

                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("dataBase", error.toString())
                }

            })
    }

    fun createBooking( ind: Int ) {
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)
        val date = df.format(Date())
        val listBooking = mutableListOf(
            "", // 7
            "", // 8
            "", // 9
            "", // 10
            "", // 11
            "", // 12
            "", // 13
            "", // 14
            "", // 15
            "", // 16
            "", // 17
            "", // 18
            "", // 19
            "", // 20
            "", // 21
        )

        listBooking[ind] = currentUser?.userId.toString()

        val occupationDay = OccupationDay(
            date,
            listBooking)

        DataBaseHelper.database.reference.child("occupationDays").child(occupationDay.date).setValue(occupationDay)
    }
}

