package com.devzone.techtrack.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.devzone.techtrack.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ForgotPassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.resetPass.setOnClickListener {
            val email = binding.emailEt.text.toString().trim()

            if (email.isEmpty()) {
                binding.emailEt.error = "Email is required"
                return@setOnClickListener
            }

            lifecycleScope.launch {
                sendResetEmail(email)
            }
        }
    }

    private suspend fun sendResetEmail(email: String) {
        try {
            auth.sendPasswordResetEmail(email).await()
            Toast.makeText(this, "Password reset email sent!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } catch (e: Exception) {
            val errorMessage = e.localizedMessage ?: "Failed to send reset email."
            if (errorMessage.contains("There is no user record corresponding to this identifier")) {
                Toast.makeText(this, "Email is not registered!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
