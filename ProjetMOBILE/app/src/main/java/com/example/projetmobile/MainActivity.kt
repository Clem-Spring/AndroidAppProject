package com.example.projetmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetmobile.databinding.ActivityMainBinding
import com.example.projetmobile.model.User
import android.widget.Button
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

lateinit var database: DatabaseReference
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private fun buttonListener() {
        binding.CreaCompte.setOnClickListener {
            Log.d("CreaCompte", "Click sur le button Créer un compte")
            Toast.makeText(this, "j'ai cliqué", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonMain.setOnClickListener {
            val intentToInscription = Intent(this, inscription::class.java)
            startActivity(intentToInscription)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalendrier.setOnClickListener {
            val intentToInscription = Intent(this, CalendrierActivity::class.java)
            startActivity(intentToInscription)
        }

        buttonListener()
        //writeNewUserWithTaskListeners("testeur","mailtest@test.test")
        //createReservation()
        //basicReadWrite()
        //ReadAndWriteSnippets().writeNewUser(UUID.randomUUID().toString(),"TestRaW2","test@test.com")

    }

    private fun buttonListener() {


        //ReadAndWriteSnippets().writeNewUserWithTaskListeners(UUID.randomUUID().toString(),"testeuuur","clem83spring@gmail.com")
        //Toast.makeText(this, "Entrée", Toast.LENGTH_LONG).show()

    }



    private fun switchPage(){
        val intent = Intent(this,inscription ::class.java)
        intent.putExtra(inscription.extraKey, TAG)
        startActivity(intent)
    }
    override fun onStart() {
        super.onStart()
        Log.d( "lifeCycle", "MainActivity onStart")


    /**fun writeNewUser( name: String, email: String) {
    val userId = UUID.randomUUID().toString()
    val user = User(name, email, userId)
    Log.d(TAG, user.toString())
    DataBaseHelper.database.reference.child("User").child(name).setValue(user).addOnCompleteListener{
    Log.w(TAG,"Ok mec")
    }.addOnFailureListener{err ->
    Log.w(TAG, "PASCOOL")
    Toast.makeText(this,"error ${err.message}",Toast.LENGTH_LONG).show()

    }
    }**/

    override fun onResume() {
        super.onResume()
        Log.d( "lifeCycle", "MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "MainActivity onPause")
    }

    override fun onDestroy() {
        Log.d("lifeCycle", "MainActivity onDestroy")
        super.onDestroy()
    }
}
