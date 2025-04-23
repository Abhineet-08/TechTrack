package com.devzone.techtrack
import androidx.cardview.widget.CardView

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.devzone.techtrack.courses.OsActivity
import com.devzone.techtrack.databinding.ActivityCoursesBinding

class CoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses) // Ensure this is the correct layout file

        // Correct reference of the CardView by ID
        val courseOSCard = findViewById<CardView>(R.id.courseOS)

        // Set the click listener after the view is initialized
        courseOSCard.setOnClickListener {
            val intent = Intent(this, OsActivity::class.java)
            startActivity(intent)
        }
    }
}


