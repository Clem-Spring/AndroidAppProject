package com.example.projetmobile

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetmobile.databinding.ActivityCalendrierBinding
import com.example.projetmobile.databinding.ActivityMainBinding
import java.util.*

class CalendrierActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalendrierBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendrierBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val snippets = ReadAndWriteSnippets()

        val logout = findViewById<Button>(R.id.LogOut)
        logout.setOnClickListener {
            currentUser = null;
            Log.d("Log out", "current = $currentUser")
            val intentToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentToMainActivity)

        }

        val imageview = findViewById<ImageView>(R.id.imageL1T1)
        imageview.setOnClickListener {
            if (imageview.drawable == getDrawable(R.drawable.balleverte)) {
                imageview.setImageResource(R.drawable.ballebleue)
            }
            else {
                imageview.setImageResource(R.drawable.balleverte)
            }
        }

        //Calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // DatePickerDialog
        binding.pickDateBtn.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // affiche la date sélectionnée
                binding.pickDateBtn.text = "$dayOfMonth / $monthOfYear / $year"
            }, year, month, day)

            dpd.show()
        }
    }


}
