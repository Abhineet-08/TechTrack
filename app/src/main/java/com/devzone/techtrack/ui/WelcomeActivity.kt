package com.devzone.techtrack.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.devzone.techtrack.MainActivity
import com.devzone.techtrack.R
import com.devzone.techtrack.home.HomeScreen

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val letsStartButton = findViewById<Button>(R.id.letsStartBtn)

        letsStartButton.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish() // so that user cannot come back to welcome screen
        }
    }
}
