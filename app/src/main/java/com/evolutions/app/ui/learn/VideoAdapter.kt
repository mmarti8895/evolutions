package com.evolutions.app.ui.learn

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.data.models.ThaiVideo
import com.evolutions.app.databinding.ItemVideoBinding

class VideoAdapter : ListAdapter<ThaiVideo, VideoAdapter.VideoViewHolder>(VideoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VideoViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ThaiVideo) {
            binding.textVideoTitle.text = item.title
            binding.textVideoDescription.text = item.description
            binding.textVideoCategory.text = item.category.uppercase()

            binding.root.setOnClickListener {
                val query = Uri.encode("${item.title} Thai")
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=$query"))
                it.context.startActivity(intent)
            }
        }
    }

    private class VideoDiffCallback : DiffUtil.ItemCallback<ThaiVideo>() {
        override fun areItemsTheSame(oldItem: ThaiVideo, newItem: ThaiVideo) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ThaiVideo, newItem: ThaiVideo) = oldItem == newItem
    }
}
