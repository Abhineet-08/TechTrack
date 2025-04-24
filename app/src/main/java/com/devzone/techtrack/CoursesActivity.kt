package com.devzone.techtrack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devzone.techtrack.courses.OsActivity
import com.devzone.techtrack.databinding.ActivityCoursesBinding

class CoursesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoursesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener
        binding.includeCourseOS.courseOS.setOnClickListener {
            val intent = Intent(this, OsActivity::class.java)
            startActivity(intent)
        }
    }
}



