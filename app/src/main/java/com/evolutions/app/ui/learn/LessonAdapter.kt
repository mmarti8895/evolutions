package com.evolutions.app.ui.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.data.models.ThaiLesson
import com.evolutions.app.databinding.ItemLessonBinding

class LessonAdapter : ListAdapter<ThaiLesson, LessonAdapter.LessonViewHolder>(LessonDiffCallback()) {

    private val expandedIds = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val binding = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LessonViewHolder(private val binding: ItemLessonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ThaiLesson) {
            binding.textLessonNumber.text = item.id.toString()
            binding.textLessonTitle.text = item.title
            binding.textLessonSubtitle.text = item.subtitle
            binding.textLessonCategory.text = item.category.uppercase()
            binding.textLessonContent.text = item.content

            val isExpanded = expandedIds.contains(item.id)
            binding.textLessonContent.visibility = if (isExpanded) View.VISIBLE else View.GONE
            binding.iconExpand.rotation = if (isExpanded) 180f else 0f

            binding.root.setOnClickListener {
                if (expandedIds.contains(item.id)) {
                    expandedIds.remove(item.id)
                } else {
                    expandedIds.add(item.id)
                }
                notifyItemChanged(bindingAdapterPosition)
            }
        }
    }

    private class LessonDiffCallback : DiffUtil.ItemCallback<ThaiLesson>() {
        override fun areItemsTheSame(oldItem: ThaiLesson, newItem: ThaiLesson) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ThaiLesson, newItem: ThaiLesson) = oldItem == newItem
    }
}
