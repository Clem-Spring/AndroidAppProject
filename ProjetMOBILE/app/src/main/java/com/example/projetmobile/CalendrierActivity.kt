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

                ReadAndWriteSnippets().createReservation(view.tag.toString(),stDate)
                ReadAndWriteSnippets().addBooking(view.tag.toString())
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

        val imageview3 = findViewById<ImageView>(R.id.imageView3)
        imageview3.setOnClickListener(changeImageClickListener)
        val imageview4 = findViewById<ImageView>(R.id.imageView4)
        imageview4.setOnClickListener(changeImageClickListener)
        val imageview5 = findViewById<ImageView>(R.id.imageView5)
        imageview5.setOnClickListener(changeImageClickListener)
        val imageview6 = findViewById<ImageView>(R.id.imageView6)
        imageview6.setOnClickListener(changeImageClickListener)
        val imageview7 = findViewById<ImageView>(R.id.imageView7)
        imageview7.setOnClickListener(changeImageClickListener)
        val imageview8 = findViewById<ImageView>(R.id.imageView8)
        imageview8.setOnClickListener(changeImageClickListener)
        val imageview9 = findViewById<ImageView>(R.id.imageView9)
        imageview9.setOnClickListener(changeImageClickListener)
        val imageview10 = findViewById<ImageView>(R.id.imageView10)
        imageview10.setOnClickListener(changeImageClickListener)
        val imageview11 = findViewById<ImageView>(R.id.imageView11)
        imageview11.setOnClickListener(changeImageClickListener)
        val imageview12 = findViewById<ImageView>(R.id.imageView12)
        imageview12.setOnClickListener(changeImageClickListener)
        val imageview13 = findViewById<ImageView>(R.id.imageView13)
        imageview13.setOnClickListener(changeImageClickListener)
        val imageview14 = findViewById<ImageView>(R.id.imageView14)
        imageview14.setOnClickListener(changeImageClickListener)
        val imageview15 = findViewById<ImageView>(R.id.imageView15)
        imageview15.setOnClickListener(changeImageClickListener)
        val imageview16 = findViewById<ImageView>(R.id.imageView16)
        imageview16.setOnClickListener(changeImageClickListener)
        val imageview17 = findViewById<ImageView>(R.id.imageView17)
        imageview17.setOnClickListener(changeImageClickListener)
        val imageview18 = findViewById<ImageView>(R.id.imageView18)
        imageview18.setOnClickListener(changeImageClickListener)
        val imageview19 = findViewById<ImageView>(R.id.imageView19)
        imageview19.setOnClickListener(changeImageClickListener)
        val imageview20 = findViewById<ImageView>(R.id.imageView20)
        imageview20.setOnClickListener(changeImageClickListener)
        val imageview21 = findViewById<ImageView>(R.id.imageView21)
        imageview21.setOnClickListener(changeImageClickListener)
        val imageview22 = findViewById<ImageView>(R.id.imageView22)
        imageview22.setOnClickListener(changeImageClickListener)
        val imageview23 = findViewById<ImageView>(R.id.imageView23)
        imageview23.setOnClickListener(changeImageClickListener)
        val imageview24 = findViewById<ImageView>(R.id.imageView24)
        imageview24.setOnClickListener(changeImageClickListener)
        val imageview25 = findViewById<ImageView>(R.id.imageView25)
        imageview25.setOnClickListener(changeImageClickListener)
        val imageview26 = findViewById<ImageView>(R.id.imageView26)
        imageview26.setOnClickListener(changeImageClickListener)
        val imageview27 = findViewById<ImageView>(R.id.imageView27)
        imageview27.setOnClickListener(changeImageClickListener)
        val imageview28 = findViewById<ImageView>(R.id.imageView28)
        imageview28.setOnClickListener(changeImageClickListener)
        val imageview29 = findViewById<ImageView>(R.id.imageView29)
        imageview29.setOnClickListener(changeImageClickListener)
        val imageview30 = findViewById<ImageView>(R.id.imageView30)
        imageview30.setOnClickListener(changeImageClickListener)


    }


}
