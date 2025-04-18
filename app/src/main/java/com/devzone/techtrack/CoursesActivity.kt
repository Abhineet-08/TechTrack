package com.devzone.techtrack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devzone.techtrack.databinding.ActivityCoursesBinding
import com.devzone.techtrack.ui.OSActivity

class CoursesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoursesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // OS course click
        binding.courseOS.setOnClickListener {
            startActivity(Intent(this, OSActivity::class.java))
        }
    }
}