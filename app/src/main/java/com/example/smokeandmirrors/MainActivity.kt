package com.example.smokeandmirrors


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etMorning: EditText
    private lateinit var etAfternoon: EditText
    private var morningMinutes = 0
    private var afternoonMinutes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMorning = findViewById(R.id.etMorning)
        etAfternoon = findViewById(R.id.etAfternoon)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnViewDetails: Button = findViewById(R.id.btnViewDetails)

        btnAdd.setOnClickListener {
            try {
                morningMinutes = etMorning.text.toString().toInt()
                afternoonMinutes = etAfternoon.text.toString().toInt()
                Toast.makeText(this, "Values added", Toast.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }

        btnClear.setOnClickListener {
            etMorning.text.clear()
            etAfternoon.text.clear()
            morningMinutes = 0
            afternoonMinutes = 0
            Toast.makeText(this, "Values cleared", Toast.LENGTH_SHORT).show()
        }

        btnViewDetails.setOnClickListener {
            val average = (morningMinutes + afternoonMinutes) / 2.0
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("AVERAGE_TIME", average)
            startActivity(intent)
        }
    }
}

