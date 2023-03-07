package com.example.projetmobile

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
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
