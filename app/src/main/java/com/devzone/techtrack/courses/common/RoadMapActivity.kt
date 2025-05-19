package com.devzone.techtrack.courses.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devzone.techtrack.courses.adapter.RoadmapAdapter
import com.devzone.techtrack.courses.dataClasses.RoadmapItem
import com.devzone.techtrack.databinding.ActivityRoadMapBinding

class RoadMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoadMapBinding
    private lateinit var adapter: RoadmapAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding setup
        binding = ActivityRoadMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Heading and back button
        binding.heading.text = "Roadmap for OS"
        binding.backBtn.setOnClickListener { finish() }

        // Example roadmap data
        val roadmapList = listOf(
            RoadmapItem(
                topic = "Introduction",
                subtopics = listOf("Definition", "Objectives", "Functions")
            ),
            RoadmapItem(
                topic = "Process Management",
                subtopics = listOf("Process States", "Scheduling", "Threads", "Context Switching")
            ),
            RoadmapItem(
                topic = "Memory Management",
                subtopics = listOf("Paging", "Segmentation", "Virtual Memory")
            )
        )

        // RecyclerView setup
        binding.roadmapRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RoadmapAdapter(roadmapList)
        binding.roadmapRecyclerView.adapter = adapter
    }
}
