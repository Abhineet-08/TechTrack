package com.devzone.techtrack.courses.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devzone.techtrack.R
import com.devzone.techtrack.courses.dataClasses.Lecture

class LectureAdapter(private val lectures: List<Lecture>) :
    RecyclerView.Adapter<LectureAdapter.LectureViewHolder>() {

    inner class LectureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lectureTitle: TextView = itemView.findViewById(R.id.lectureTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lecture, parent, false)
        return LectureViewHolder(view)
    }

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        val lecture = lectures[position]
        holder.lectureTitle.text = lecture.title
        // Add click listener when you want to play videos from Firebase in future
    }

    override fun getItemCount() = lectures.size
}
