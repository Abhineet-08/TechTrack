package com.devzone.techtrack.courses.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devzone.techtrack.courses.common.LectureListActivity
import com.devzone.techtrack.courses.dataClasses.Section
import com.devzone.techtrack.databinding.ItemSectionBinding

class SectionAdapter(
    private val context: Context,
    private val courseName: String,
    private val sections: List<Section>
) : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = ItemSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = sections[position]
        holder.bind(section)
    }

    override fun getItemCount(): Int = sections.size

    inner class SectionViewHolder(private val binding: ItemSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(section: Section) {
            binding.sectionTitle.text = section.sectionName

            binding.root.setOnClickListener {
                val intent = Intent(context, LectureListActivity::class.java)
                intent.putExtra("sectionName", section.sectionName)
                intent.putExtra("courseName", courseName)
                context.startActivity(intent)
            }
        }


    }
}
