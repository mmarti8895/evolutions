package com.evolutions.app.ui.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.data.models.ScriptItem
import com.evolutions.app.databinding.ItemScriptBinding

class ScriptAdapter : ListAdapter<ScriptItem, ScriptAdapter.ScriptViewHolder>(ScriptDiffCallback()) {

    private val revealedIds = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScriptViewHolder {
        val binding = ItemScriptBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScriptViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScriptViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ScriptViewHolder(private val binding: ItemScriptBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ScriptItem) {
            binding.textCharacter.text = item.character

            when (item.type) {
                "passage" -> {
                    binding.textThaiName.text = item.thaiName
                    binding.textClassBadge.text = "PASSAGE"
                    binding.textIpa.text = item.meaning
                    binding.textStrokeOrder.visibility = View.GONE

                    val isRevealed = revealedIds.contains(item.id)
                    if (isRevealed) {
                        binding.textIpa.text = "${item.meaning}\n\n📖 ${item.romanization}"
                    } else {
                        binding.textIpa.text = "${item.meaning}\n\n👆 Tap to reveal translation"
                    }

                    binding.root.setOnClickListener {
                        if (revealedIds.contains(item.id)) {
                            revealedIds.remove(item.id)
                        } else {
                            revealedIds.add(item.id)
                        }
                        notifyItemChanged(bindingAdapterPosition)
                    }
                }
                "tone_rule" -> {
                    binding.textThaiName.text = item.thaiName
                    binding.textClassBadge.text = "TONE RULE"
                    binding.textIpa.text = item.meaning
                    binding.textStrokeOrder.visibility = View.GONE
                }
                else -> {
                    binding.textThaiName.text = "${item.thaiName} — ${item.meaning}"
                    binding.textClassBadge.text = item.consonantClass.uppercase()
                    binding.textIpa.text = "IPA: /${item.ipa}/  •  Roman: ${item.romanization}"

                    if (item.strokeOrder.isNotEmpty()) {
                        binding.textStrokeOrder.visibility = View.VISIBLE
                        binding.textStrokeOrder.text = "✏️ ${item.strokeOrder}"
                    } else {
                        binding.textStrokeOrder.visibility = View.GONE
                    }
                }
            }
        }
    }

    private class ScriptDiffCallback : DiffUtil.ItemCallback<ScriptItem>() {
        override fun areItemsTheSame(oldItem: ScriptItem, newItem: ScriptItem) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ScriptItem, newItem: ScriptItem) = oldItem == newItem
    }
}
