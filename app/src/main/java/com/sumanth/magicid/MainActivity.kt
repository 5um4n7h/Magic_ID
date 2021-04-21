package com.sumanth.magicid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = findViewById<EditText>(R.id.etID)
        val btnSubmit : Button = findViewById(R.id.btnSubmit)
        val result : TextView = findViewById(R.id.tvResult)


        btnSubmit.setOnClickListener {

            try {
                val id: String = id.text.toString().trim()
                val dob: String = id.substring(0, 6)
                val gender: Int = id.get(6).toInt()

                val sGender: String
                if (gender < 5) {
                    sGender = "Female"
                } else
                    sGender = "Male"


                val nationality: Int = id.get(10).toInt()

                val sNationality: String
                if (nationality == 0) {
                    sNationality = "SA Citizen"
                } else
                    sNationality = "Permanent Resident"

                result.setText("Date of Birth : ${dob}\n Gender : ${sGender}\nNationality : ${sNationality}")
            }catch (e : Exception){
                Toast.makeText(this,"Enter correct input",Toast.LENGTH_SHORT).show()
            }
        }
    }
}