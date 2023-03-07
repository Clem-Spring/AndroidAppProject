package com.example.projetmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
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
        val valider = findViewById<Button>(R.id.valider)
        valider.setOnClickListener {
            val intentToInscription = Intent(this, inscription::class.java)
            startActivity(intentToInscription)
        }

        //ReadAndWriteSnippets().initializeDbRef()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val uid = UUID.randomUUID().toString()
        //Log.d("TAG",uid)
        //ReadAndWriteSnippets().initializeDbRef()
        //database = FirebaseDatabase.getInstance().getReference("User")
        //ReadAndWriteSnippets().writeNewUser(uid,"Spring","clem83spring@gmail.com")
        //createReservation()
    }



    private fun switchPage(){
        val intent = Intent(this,inscription ::class.java)
        intent.putExtra(inscription.extraKey, TAG)
        startActivity(intent)
    }
    override fun onStart() {
        super.onStart()
        Log.d( "lifeCycle", "MainActivity onStart")
    }

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