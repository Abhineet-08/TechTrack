package com.devzone.techtrack.courses.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devzone.techtrack.courses.adapter.LectureAdapter
import com.devzone.techtrack.courses.dataClasses.allCourses
import com.devzone.techtrack.databinding.ActivityLectureListBinding

class LectureListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLectureListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LectureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLectureListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.lecturesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val sectionName = intent.getStringExtra("sectionName")
        val courseName = intent.getStringExtra("courseName")

        val lectures =
            allCourses[courseName]?.find { it.sectionName == sectionName }?.lectures ?: emptyList()
        binding.heading.text = sectionName
        binding.backBtn.setOnClickListener {
            finish()
        }

        adapter = LectureAdapter(lectures)
        recyclerView.adapter = adapter
    }
}
