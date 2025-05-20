package com.devzone.techtrack.courses.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devzone.techtrack.courses.dataClasses.Subject
import com.devzone.techtrack.databinding.ItemSubjectBinding

class SubjectAdapter(
    private val subjects: List<Subject>,
    private val onClick: (Subject) -> Unit
) : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    inner class SubjectViewHolder(val binding: ItemSubjectBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = ItemSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjects[position]
        holder.binding.subjectTitle.text = subject.title
        holder.binding.subjectQuote.text = subject.quote
        holder.binding.root.setOnClickListener {
            onClick(subject)
        }
    }

    override fun getItemCount() = subjects.size
}
