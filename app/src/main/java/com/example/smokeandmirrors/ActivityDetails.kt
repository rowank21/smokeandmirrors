package com.example.smokeandmirrors


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val averageTime = intent.getDoubleExtra("AVERAGE_TIME", 0.0)
        val tvAverage: TextView = findViewById(R.id.tvAverage)
        val btnBack: Button = findViewById(R.id.btnBack)

        tvAverage.text = "Average Screen Time: $averageTime minutes"

        btnBack.setOnClickListener {
            finish()
        }
    }
}

