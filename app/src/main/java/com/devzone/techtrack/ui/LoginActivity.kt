package com.devzone.techtrack.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.devzone.techtrack.databinding.ActivityLoginBinding
import com.devzone.techtrack.home.HomeScreen
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val email = binding.nameEt
        val password = binding.passwordEt
        auth = FirebaseAuth.getInstance()

        binding.createaccountButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.forgotPassword.setOnClickListener{
            val intent = Intent(this@LoginActivity, ForgotPassword::class.java)
            startActivity(intent)
            finish()
        }

        binding.loginButton.setOnClickListener {
            val mail = email.text.toString().trim()
            val pass = password.text.toString().trim()

            if (mail.isEmpty()) {
                email.error = "Email is required"
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                password.error = "Password is required"
                return@setOnClickListener
            }
            if (pass.length < 8) {
                password.error = "Password must be of length >= 8"
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null && user.isEmailVerified) {
                        // Email is verified, proceed with login
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                        // Navigate to another screen (e.g., Home Screen)
                        val intent = Intent(this@LoginActivity, HomeScreen::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Email is not verified
                        Toast.makeText(this, "Please verify your email first.", Toast.LENGTH_SHORT).show()
                        auth.signOut()
                    }
                } else {
                    // Sign-in failed, display an error message
                    val errorMessage = task.exception?.message ?: "Login failed. Please try again."
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
