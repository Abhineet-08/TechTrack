package com.devzone.techtrack.courses.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devzone.techtrack.R
import com.devzone.techtrack.courses.adapter.SectionAdapter
import com.devzone.techtrack.courses.dataClasses.allCourses
import com.devzone.techtrack.databinding.ActivityLecturesBinding

class LecturesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLecturesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLecturesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the course name from the intent
        val courseName = intent.getStringExtra("courseName") ?: "OS"
        // Get the sections for the selected course
        val sections = allCourses[courseName] ?: emptyList()

        when (courseName) {
            "OS" -> {
                binding.heading.setText(R.string.course_os)
            }

            "DBMS" -> {
                binding.heading.setText(R.string.course_dbms)
            }

            "Web" -> {
                binding.heading.setText(R.string.course_web)
            }

            "Android" -> {
                binding.heading.setText(R.string.course_android)
            }

            "DSA" -> {
                binding.heading.setText(R.string.course_dsa)
            }
        }


        binding.backBtn.setOnClickListener {
            finish()
        }
        // Set up RecyclerView with the sections for the selected course

        val adapter = SectionAdapter(this, courseName, sections)
        binding.sectionsRecyclerView.adapter = adapter
        binding.sectionsRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}
