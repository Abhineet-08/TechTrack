package com.devzone.techtrack.courses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devzone.techtrack.R
import com.devzone.techtrack.databinding.ActivityCommonBinding

class CommonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseName = intent.getStringExtra("courseName") ?: "OS"

        when (courseName) {
            "OS" -> {
                binding.courseTitle.setText(R.string.course_os)
                binding.courseTagline.setText(R.string.tag_os)
                binding.courseFooter.setText(R.string.foot_os)
            }
            "DBMS" -> {
                binding.courseTitle.setText(R.string.course_dbms)
                binding.courseTagline.setText(R.string.tag_dbms)
                binding.courseFooter.setText(R.string.foot_dbms)
            }
            "Web" -> {
                binding.courseTitle.setText(R.string.course_web)
                binding.courseTagline.setText(R.string.tag_web)
                binding.courseFooter.setText(R.string.foot_web)
            }
            "Android" -> {
                binding.courseTitle.setText(R.string.course_android)
                binding.courseTagline.setText(R.string.tag_android)
                binding.courseFooter.setText(R.string.foot_android)
            }
            "DSA" -> {
                binding.courseTitle.setText(R.string.course_dsa)
                binding.courseTagline.setText(R.string.tag_dsa)
                binding.courseFooter.setText(R.string.foot_dsa)
            }
        }



        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}
