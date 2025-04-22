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
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

//         OS course click listener
        binding.courseOS.setOnClickListener {
            startActivity(Intent(this, OsActivity::class.java))
        }
    }
}
