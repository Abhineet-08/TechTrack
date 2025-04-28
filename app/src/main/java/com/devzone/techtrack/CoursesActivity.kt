package com.devzone.techtrack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.devzone.techtrack.courses.CommonActivity
import com.devzone.techtrack.databinding.ActivityCoursesBinding
import com.devzone.techtrack.databinding.ItemCourseCardAndroidBinding
import com.devzone.techtrack.databinding.ItemCourseCardDbmsBinding
import com.devzone.techtrack.databinding.ItemCourseCardDsaBinding
import com.devzone.techtrack.databinding.ItemCourseCardWebBinding
import com.devzone.techtrack.databinding.ItemCourseOsFullBinding

class CoursesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoursesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // for os
        val osIncludedView = findViewById<View>(R.id.includeCourseOS)
        val osBinding = ItemCourseOsFullBinding.bind(osIncludedView)
        osBinding.btnStartOS.setOnClickListener {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra("courseName", "OS")
            startActivity(intent)
        }


        // for dbms
        val dbmsIncludedView = findViewById<View>(R.id.includeCourseDBMS)
        val dbmsBinding = ItemCourseCardDbmsBinding.bind(dbmsIncludedView)
        dbmsBinding.btnStartDBMS.setOnClickListener {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra("courseName", "DBMS")
            startActivity(intent)
        }

        // Web Dev Course Button
        val webDevIncludedView = findViewById<View>(R.id.includeCourseWeb)
        val webDevBinding = ItemCourseCardWebBinding.bind(webDevIncludedView)
        webDevBinding.btnStartWebDev.setOnClickListener {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra("courseName", "Web")
            startActivity(intent)
        }

        // Android Course Button
        val androidIncludedView = findViewById<View>(R.id.includeCourseAndroid)
        val androidBinding = ItemCourseCardAndroidBinding.bind(androidIncludedView)
        androidBinding.btnStartAndroid.setOnClickListener {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra("courseName", "Android")
            startActivity(intent)
        }

        // DSA Course Button
        val dsaIncludedView = findViewById<View>(R.id.includeCourseDSA)
        val dsaBinding = ItemCourseCardDsaBinding.bind(dsaIncludedView)
        dsaBinding.btnStartDSA.setOnClickListener {
            val intent = Intent(this, CommonActivity::class.java)
            intent.putExtra("courseName", "DSA")
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}



