package com.example.projetmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.UUID
import android.widget.EditText
import android.widget.Toast

class Inscription : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
        val valider = findViewById<Button>(R.id.valider)
        val snippets = ReadAndWriteSnippets()

        valider.setOnClickListener {
            val editName = findViewById<EditText>(R.id.Id_name)
            val editPwd = findViewById<EditText>(R.id.Mot_de_passe)
            val nameText = editName.text.toString()
            val pwdText = editPwd.text.toString()
            val editConfirmPwd = findViewById<EditText>(R.id.ConfirmMDP)
            val confirmPwdText = editConfirmPwd.text.toString()

            if (nameText != "" && pwdText != "" && pwdText == confirmPwdText) {
                snippets.writeNewUserWithTaskListeners(UUID.randomUUID().toString(), nameText, pwdText)
                snippets.getUser(nameText, pwdText)
                val intentToCalendrierActivity = Intent(this, CalendrierActivity::class.java)
                startActivity(intentToCalendrierActivity)
            }else{
                if (nameText == "" || pwdText == ""){
                    editName.error = "Veuillez remplir tous les champs"
                    editPwd.error = "Veuillez remplir tous les champs"
                    Toast.makeText(this, "Remplissez tous les champs", Toast.LENGTH_LONG).show()

                }else{
                    editPwd.error = "Les mots de passe ne correspondent pas"
                    editConfirmPwd.error = "Les mots de passe ne correspondent pas"
                    Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_LONG).show()

                }
            }

        }
    }

    companion object{
        val extraKey = "extraKey"
    }
}