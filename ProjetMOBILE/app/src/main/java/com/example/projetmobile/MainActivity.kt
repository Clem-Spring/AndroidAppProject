package com.example.projetmobile

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetmobile.databinding.ActivityMainBinding
import com.example.projetmobile.model.User

import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

lateinit var database: DatabaseReference
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ReadAndWriteSnippets().initializeDbRef()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ReadAndWriteSnippets().initializeDbRef()


        buttonListener()
        //writeNewUserWithTaskListeners("testeur","mailtest@test.test")
        //createReservation()
        //basicReadWrite()
        //ReadAndWriteSnippets().writeNewUser(UUID.randomUUID().toString(),"TestRaW2","test@test.com")

    }

    private fun buttonListener() {
        binding.button.setOnClickListener {

            ReadAndWriteSnippets().writeNewUserWithTaskListeners(UUID.randomUUID().toString(),"testeuuur","clem83spring@gmail.com")
            //Toast.makeText(this, "Entrée", Toast.LENGTH_LONG).show()

        }
    }



    /**fun writeNewUser( name: String, email: String) {
        val userId = UUID.randomUUID().toString()
        val user = User(name, email, userId)

        Log.w(TAG, "hehohohe")
        Log.d(TAG, user.toString())
        DataBaseHelper.database.reference.child("User").child(name).setValue(user).addOnCompleteListener{
            Log.w(TAG,"Ok mec")
        }.addOnFailureListener{err ->
            Log.w(TAG, "PASCOOL")
            Toast.makeText(this,"error ${err.message}",Toast.LENGTH_LONG).show()
        }
    }**/

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
        // [END read_message]
    }
}
