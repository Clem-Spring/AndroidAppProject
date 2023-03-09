package com.example.projetmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetmobile.databinding.ActivityMainBinding
import com.example.projetmobile.model.User
import android.widget.Button
import android.widget.EditText
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
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val valider = findViewById<Button>(R.id.buttonMain)
        val inscription = findViewById<Button>(R.id.CreaCompte)
        val snippets = ReadAndWriteSnippets()

        valider.setOnClickListener {
            val editName = findViewById<EditText>(R.id.Id_name)
            val editPwd = findViewById<EditText>(R.id.Mot_de_passe)
            val nameText = editName.text.toString()
            val pwdText = editPwd.text.toString()


            snippets.getUser(nameText, pwdText)

            if ( currentUser?.username != null && currentUser?.password != null) {
                val intentToCalendrierActivity = Intent(this, CalendrierActivity::class.java)
                startActivity(intentToCalendrierActivity)
            }
            else {
                Toast.makeText(this, "Identifiants incorrects", Toast.LENGTH_LONG).show()
            }


        }

        inscription.setOnClickListener {
            Log.d("CreaCompte", "Click sur le button Créer un compte")
            Toast.makeText(this, "j'ai cliqué", Toast.LENGTH_LONG).show()
            val intentToInscription = Intent(this, Inscription::class.java)
            startActivity(intentToInscription)
        }
        //writeNewUserWithTaskListeners("testeur","mailtest@test.test")
        //createReservation()
        //basicReadWrite()
        //ReadAndWriteSnippets().writeNewUser(UUID.randomUUID().toString(),"TestRaW2","test@test.com")

    }


    private fun buttonListener() {



    }
    private fun switchPage(){
        val intent = Intent(this,Inscription ::class.java)
        intent.putExtra(Inscription.extraKey, TAG)
        startActivity(intent)
    }
    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "MainActivity onStart")
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
