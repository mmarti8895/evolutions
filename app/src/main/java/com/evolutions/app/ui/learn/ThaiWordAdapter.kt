package com.evolutions.app.ui.learn

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.data.ProgressManager
import com.evolutions.app.data.models.ThaiWord
import com.evolutions.app.databinding.ItemThaiWordBinding

class ThaiWordAdapter(
    private val onCompletionChanged: (() -> Unit)? = null
) : ListAdapter<ThaiWord, ThaiWordAdapter.ThaiWordViewHolder>(ThaiWordDiffCallback()) {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThaiWordViewHolder {
        val binding = ItemThaiWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ThaiWordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ThaiWordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    inner class ThaiWordViewHolder(private val binding: ItemThaiWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ThaiWord) {
            binding.textEnglish.text = item.english
            binding.textThai.text = item.thai
            binding.textPhonetic.text = item.phonetic
            binding.textCategory.text = item.category
            binding.textUsageExample.text = item.usageExample

            binding.buttonPlayAudio.setOnClickListener {
                playAudio(item.audioUrl)
            }

            updateMasteredUI(item.id)

            binding.buttonMasteredThai.setOnClickListener {
                ProgressManager.toggleThaiWordCompleted(item.id)
                updateMasteredUI(item.id)
                onCompletionChanged?.invoke()
            }
        }

        private fun updateMasteredUI(wordId: Int) {
            val isCompleted = ProgressManager.isThaiWordCompleted(wordId)
            if (isCompleted) {
                binding.buttonMasteredThai.text = "✅ Learned"
                binding.buttonMasteredThai.setBackgroundResource(android.R.color.holo_green_dark)
            } else {
                binding.buttonMasteredThai.text = "Mark Learned"
                binding.buttonMasteredThai.setBackgroundResource(com.evolutions.app.R.drawable.chip_background)
            }
        }

        private fun playAudio(url: String) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(url)
                prepareAsync()
                setOnPreparedListener { start() }
            }
        }
    }

    private class ThaiWordDiffCallback : DiffUtil.ItemCallback<ThaiWord>() {
        override fun areItemsTheSame(oldItem: ThaiWord, newItem: ThaiWord) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ThaiWord, newItem: ThaiWord) = oldItem == newItem
    }
}
