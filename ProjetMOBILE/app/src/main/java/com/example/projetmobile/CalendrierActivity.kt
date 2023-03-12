package com.example.projetmobile

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetmobile.databinding.ActivityCalendrierBinding
import java.util.*
import android.view.View
import java.text.SimpleDateFormat

class CalendrierActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalendrierBinding
    val df = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)

    var stDate = df.format(Date())
    private val changeImageClickListener = View.OnClickListener { view ->
        if (view is ImageView) {
            if (view.drawable.constantState == resources.getDrawable(R.drawable.ballebleue).constantState) {
                view.setImageResource(R.drawable.balleverte)

            } else {
                view.setImageResource(R.drawable.ballebleue)
                Log.d("setImage",stDate)

            }
        }
    }
    @SuppressLint("SetTextI18n")
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



        //Calendar
        val c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)


        // DatePickerDialog
        binding.pickDateBtn.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, yearOf, monthOfYear, dayOfMonth ->
                // affiche la date sélectionnée
                month = monthOfYear
                day = dayOfMonth
                year = yearOf
                binding.pickDateBtn.text = "$dayOfMonth / $monthOfYear / $yearOf"

            }, year, month, day)

            dpd.show()

            stDate = year.toString()+"-"+(month+1).toString()+"-"+day.toString()

        }


        val imageview1 = findViewById<ImageView>(R.id.imageL1T1)
        imageview1.setOnClickListener(changeImageClickListener)


        val imageview2 = findViewById<ImageView>(R.id.imageView2)
        imageview2.setOnClickListener(changeImageClickListener)


    }


}
