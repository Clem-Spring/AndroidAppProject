package com.example.projetmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projetmobile.databinding.ActivityInscriptionBinding

class inscription : AppCompatActivity() {
    private lateinit var binding: ActivityInscriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object{
        val extraKey = "extraKey"
    }
}