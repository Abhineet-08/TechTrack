package com.devzone.techtrack.courses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devzone.techtrack.databinding.ActivityOsBinding

class OsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}
