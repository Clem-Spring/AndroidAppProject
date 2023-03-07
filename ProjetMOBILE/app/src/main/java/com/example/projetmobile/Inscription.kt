package com.example.projetmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.UUID
import android.widget.EditText
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

            if (nameText != "" && pwdText != "") {
                snippets.writeNewUserWithTaskListeners(UUID.randomUUID().toString(), nameText, pwdText)
            }

        }
    }
}