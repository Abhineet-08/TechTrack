package com.devzone.techtrack.ui
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devzone.techtrack.courses.adapter.SubjectAdapter
import com.devzone.techtrack.courses.common.RoadMapActivity
import com.devzone.techtrack.courses.dataClasses.Subject
import com.devzone.techtrack.databinding.ActivityRoadmapSubjectListBinding

class RoadmapSubjectListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoadmapSubjectListBinding
    private lateinit var adapter: SubjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoadmapSubjectListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subjects = listOf(
            Subject("Operating System", "Master the core of computers"),
            Subject("DBMS", "Manage data like a pro"),
            Subject("WEB DEVELOPMENT", "Connect the digital world"),
            Subject("Android Development", "Scale beyond limits"),
            Subject("DSA", "Code with logic, not luck")
        )

        adapter = SubjectAdapter(subjects) { subject ->
            val intent = Intent(this, RoadMapActivity::class.java)
            intent.putExtra("subject_name", subject.title)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}

