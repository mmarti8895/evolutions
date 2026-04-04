package com.evolutions.app.ui.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.data.models.ThaiBook
import com.evolutions.app.databinding.ItemBookBinding

class BookAdapter : ListAdapter<ThaiBook, BookAdapter.BookViewHolder>(BookDiffCallback()) {

    private val expandedIds = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ThaiBook) {
            val emoji = when (item.language) {
                "Thai Classic" -> "📜"
                "English Classic" -> "📕"
                "Bilingual" -> "🌏"
                else -> "📖"
            }
            binding.textBookEmoji.text = emoji
            binding.textBookTitle.text = item.title
            binding.textBookAuthor.text = "by ${item.author}"
            binding.textLanguageBadge.text = item.language.uppercase()
            binding.textBookDescription.text = item.description
            binding.textSampleText.text = item.sampleText

            val isExpanded = expandedIds.contains(item.id)
            binding.textSampleText.visibility = if (isExpanded) View.VISIBLE else View.GONE
            binding.textSampleLabel.text = if (isExpanded) "📄 Tap to hide sample" else "📄 Tap to read sample"

            binding.textSampleLabel.setOnClickListener {
                if (expandedIds.contains(item.id)) {
                    expandedIds.remove(item.id)
                } else {
                    expandedIds.add(item.id)
                }
                notifyItemChanged(bindingAdapterPosition)
            }
        }
    }

    private class BookDiffCallback : DiffUtil.ItemCallback<ThaiBook>() {
        override fun areItemsTheSame(oldItem: ThaiBook, newItem: ThaiBook) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ThaiBook, newItem: ThaiBook) = oldItem == newItem
    }
}
