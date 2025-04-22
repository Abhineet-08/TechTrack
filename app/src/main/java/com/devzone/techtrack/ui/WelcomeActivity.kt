package com.devzone.techtrack.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.devzone.techtrack.R
import com.devzone.techtrack.home.HomeScreen
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Check if the user is already logged in
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // User is logged in, go directly to HomeScreen
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish() // Prevent coming back to WelcomeActivity
        }

        val letsStartButton = findViewById<Button>(R.id.letsStartBtn)
        letsStartButton.setOnClickListener {
            // Navigate to LoginActivity if the user is not logged in
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Prevent coming back to WelcomeActivity
        }
    }
}
