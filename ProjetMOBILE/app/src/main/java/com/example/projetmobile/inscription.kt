package com.example.projetmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.UUID
import android.widget.EditText
import android.util.Log
import com.example.projetmobile.databinding.ActivityInscriptionBinding

class inscription : AppCompatActivity() {
    private lateinit var binding: ActivityInscriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

            if (nameText != "" && pwdText != "") {
                snippets.writeNewUserWithTaskListeners(UUID.randomUUID().toString(), nameText, pwdText)
            }
        }
    }

    companion object{
        val extraKey = "extraKey"
    }
}