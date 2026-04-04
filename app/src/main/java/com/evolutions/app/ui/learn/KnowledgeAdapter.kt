package com.evolutions.app.ui.learn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.data.ProgressManager
import com.evolutions.app.data.models.KnowledgeTopic
import com.evolutions.app.databinding.ItemKnowledgeBinding

class KnowledgeAdapter(
    private val onCompletionChanged: (() -> Unit)? = null
) : ListAdapter<KnowledgeTopic, KnowledgeAdapter.KnowledgeViewHolder>(KnowledgeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnowledgeViewHolder {
        val binding = ItemKnowledgeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KnowledgeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KnowledgeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class KnowledgeViewHolder(private val binding: ItemKnowledgeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: KnowledgeTopic) {
            binding.textTopicTitle.text = item.title
            binding.textTopicCategory.text = item.category
            binding.textTopicContent.text = item.content
            binding.textKeyTakeaway.text = "💡 ${item.keyTakeaway}"

            updateMasteredUI(item.id)

            binding.buttonMastered.setOnClickListener {
                ProgressManager.toggleKnowledgeCompleted(item.id)
                updateMasteredUI(item.id)
                onCompletionChanged?.invoke()
            }
        }

        private fun updateMasteredUI(topicId: Int) {
            val isCompleted = ProgressManager.isKnowledgeCompleted(topicId)
            if (isCompleted) {
                binding.buttonMastered.text = "✅ Learned"
                binding.buttonMastered.setBackgroundResource(android.R.color.holo_green_dark)
            } else {
                binding.buttonMastered.text = "Mark Learned"
                binding.buttonMastered.setBackgroundResource(com.evolutions.app.R.drawable.chip_background)
            }
        }
    }

    private class KnowledgeDiffCallback : DiffUtil.ItemCallback<KnowledgeTopic>() {
        override fun areItemsTheSame(oldItem: KnowledgeTopic, newItem: KnowledgeTopic) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: KnowledgeTopic, newItem: KnowledgeTopic) = oldItem == newItem
    }
}
