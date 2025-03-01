package com.devzone.techtrack.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devzone.techtrack.R
import com.devzone.techtrack.home.fragments.HomeFragment
import com.devzone.techtrack.home.fragments.ProfileFragment
import com.devzone.techtrack.home.fragments.SettingFragment
import com.devzone.techtrack.databinding.ActivityHomeScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class HomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("Users")

        // Fetch and store username
        bottomNavFunctions()
    }



    private fun bottomNavFunctions() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Load HomeFragment
                    replaceFragment(HomeFragment())
                }
                R.id.nav_setting -> {
                    // Load SettingFragment
                    replaceFragment(SettingFragment())
                }
                R.id.nav_profile -> {
                    // Load ProfileFragment
                    replaceFragment(ProfileFragment())
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}
