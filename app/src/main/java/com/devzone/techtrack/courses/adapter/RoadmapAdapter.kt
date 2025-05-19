package com.devzone.techtrack.courses.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devzone.techtrack.R
import com.devzone.techtrack.courses.dataClasses.RoadmapItem
import com.google.android.material.button.MaterialButton

class RoadmapAdapter(private val roadmapList: List<RoadmapItem>) : RecyclerView.Adapter<RoadmapAdapter.RoadmapViewHolder>() {

    inner class RoadmapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleBtn: MaterialButton = itemView.findViewById(R.id.roadmapTitleBtn)
        val subtopicContainer: ViewGroup = itemView.findViewById(R.id.subtopicContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoadmapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_roadmap, parent, false)
        return RoadmapViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoadmapViewHolder, position: Int) {
        val item = roadmapList[position]
        holder.titleBtn.text = item.topic

        holder.subtopicContainer.removeAllViews()
        if (item.isExpanded) {
            holder.subtopicContainer.visibility = View.VISIBLE
            for (subtopic in item.subtopics) {
                val subtopicView = LayoutInflater.from(holder.itemView.context).inflate(R.layout.item_subtopic, holder.subtopicContainer, false) as TextView
                subtopicView.text = "- $subtopic"
                holder.subtopicContainer.addView(subtopicView)
            }
        } else {
            holder.subtopicContainer.visibility = View.GONE
        }

        holder.titleBtn.setOnClickListener {
            item.isExpanded = !item.isExpanded
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = roadmapList.size
}