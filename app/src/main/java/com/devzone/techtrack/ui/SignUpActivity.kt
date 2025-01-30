package com.devzone.techtrack.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.devzone.techtrack.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Set onClickListener for loginText
        binding.loginText.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Set onClickListener for signupButton
        binding.signupButton.setOnClickListener {
            val userName = binding.nameEt.text.toString().trim()
            val mail = binding.emailEt.text.toString().trim()
            val phoneNumber = binding.contactEt.text.toString().trim()
            val pass = binding.passwordEt.text.toString().trim()

            // Validate input fields
            if (userName.isEmpty()) {
                binding.nameEt.error = "Name is required"
                return@setOnClickListener
            }
            if (mail.isEmpty()) {
                binding.emailEt.error = "Email is required"
                return@setOnClickListener
            }
            if (phoneNumber.isEmpty()) {
                binding.contactEt.error = "Phone number is required"
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                binding.passwordEt.error = "Password is required"
                return@setOnClickListener
            }
            if (pass.length < 8) {
                binding.passwordEt.error = "Password must be of length >= 8"
                return@setOnClickListener
            }

            // Firebase Authentication
            auth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Account creation successful
                    val userId = auth.currentUser?.uid
                    val databaseRef = FirebaseDatabase.getInstance().getReference("Users")

                    // User data to store in Realtime Database
                    val userData = mapOf(
                        "name" to userName,
                        "email" to mail,
                        "phone" to phoneNumber,
                        "password" to pass // Not recommended to store plain text passwords
                    )

                    // Store user data in Realtime Database
                    userId?.let {
                        databaseRef.child(it).setValue(userData).addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful) {
                                Toast.makeText(this, "Signup successful and data saved!", Toast.LENGTH_SHORT).show()

                                // Navigate to the login screen
                                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, "Failed to save user data: ${dbTask.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                } else {
                    // Handle failure
                    val errorMessage = task.exception?.message ?: "Signup failed"
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
