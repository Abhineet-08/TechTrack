package com.devzone.techtrack.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.devzone.techtrack.CoursesActivity
import com.devzone.techtrack.databinding.FragmentHomeBinding
import com.devzone.techtrack.ui.RoadmapSubjectListActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference.child("Users")

        // Fetch and set username
        fetchUserName()

        // Handle click on courses box
        binding.coursesBox.setOnClickListener {
            val intent = Intent(requireContext(), CoursesActivity::class.java)
            startActivity(intent)
        }
        binding.RoadmapBox.setOnClickListener {
            val intent = Intent(requireContext(), RoadmapSubjectListActivity::class.java)
            startActivity(intent)
        }



    }

    private fun fetchUserName() {
        val userId = auth.currentUser?.uid
        if (userId != null) {
            database.child(userId).child("name").get().addOnSuccessListener { snapshot ->
                if (isAdded && _binding != null && snapshot.exists()) {
                    val userName = snapshot.value.toString()
                    binding.userNameTV.text = "Hi, $userName"
                } else if (!snapshot.exists()) {
                    Toast.makeText(requireContext(), "User name not found", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                if (isAdded && _binding != null) {
                    Toast.makeText(requireContext(), "Failed to retrieve user name", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            if (isAdded && _binding != null) {
                Toast.makeText(requireContext(), "User not logged in", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
