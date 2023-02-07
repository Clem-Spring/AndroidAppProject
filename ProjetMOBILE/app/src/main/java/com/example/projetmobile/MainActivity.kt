package com.example.projetmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.projetmobile.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

private lateinit var database: DatabaseReference
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val valider = findViewById<Button>(R.id.valider)
        valider.setOnClickListener {
            val intentToInscription = Intent(this, inscription::class.java)
            startActivity(intentToInscription)
        }

        ReadAndWriteSnippets().initializeDbRef()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val uid = UUID.randomUUID().toString()
        Log.d("TAG",uid)
        //ReadAndWriteSnippets().initializeDbRef()
        //database = FirebaseDatabase.getInstance().getReference("User")
        ReadAndWriteSnippets().writeNewUser(uid,"Spring","clem83spring@gmail.com")
        createReservation()
    }



    fun createReservation() {
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)
        val date = df.format(Date())

        val hours = mapOf("12" to "4bf7d5a9-484a-4aed-8c72-431254b2710e")
        val reservation = Reservation(date, hours)

        DataBaseHelper.database.child("Reservations").child(reservation.date).setValue(reservation)
    }

    @IgnoreExtraProperties
    data class Reservation(val date: String, val hours: Map<String, String>) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }

    fun basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
        // [END write_message]

        // [START read_message]
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

}