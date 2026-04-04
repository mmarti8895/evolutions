package com.evolutions.app.ui.nutrition

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.R
import com.evolutions.app.data.models.NutritionItem
import com.evolutions.app.databinding.ItemNutritionBinding

class NutritionAdapter : ListAdapter<NutritionItem, NutritionAdapter.NutritionViewHolder>(NutritionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionViewHolder {
        val binding = ItemNutritionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NutritionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NutritionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NutritionViewHolder(private val binding: ItemNutritionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NutritionItem) {
            binding.textFoodName.text = item.name
            binding.textFoodCategory.text = item.category
            binding.textFoodDescription.text = item.description
            binding.textFoodBenefits.text = item.benefits
            binding.textServingSuggestion.text = "🍽️ ${item.servingSuggestion}"
            binding.textCalories.text = if (item.caloriesPerServing > 0) "${item.caloriesPerServing} cal/serving" else ""

            val tags = buildList {
                if (item.crohnsFriendly) add("✅ Crohn's Friendly")
                if (item.lowFiber) add("🌾 Low Fiber")
                if (item.antiInflammatory) add("💜 Anti-Inflammatory")
                if (!item.crohnsFriendly) add("⚠️ Use With Caution")
            }
            binding.textTags.text = tags.joinToString("  ")

            val categoryColor = when (item.category) {
                "Protein" -> ContextCompat.getColor(binding.root.context, R.color.category_protein)
                "Recovery" -> ContextCompat.getColor(binding.root.context, R.color.category_recovery)
                "Anti-Inflammatory" -> ContextCompat.getColor(binding.root.context, R.color.category_anti_inflammatory)
                "Fat" -> ContextCompat.getColor(binding.root.context, R.color.category_fat)
                "Carb" -> ContextCompat.getColor(binding.root.context, R.color.category_carb)
                "Avoid" -> ContextCompat.getColor(binding.root.context, R.color.category_avoid)
                else -> ContextCompat.getColor(binding.root.context, R.color.md_theme_primary)
            }
            binding.textFoodCategory.setBackgroundColor(categoryColor)
        }
    }

    private class NutritionDiffCallback : DiffUtil.ItemCallback<NutritionItem>() {
        override fun areItemsTheSame(oldItem: NutritionItem, newItem: NutritionItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NutritionItem, newItem: NutritionItem) =
            oldItem == newItem
    }
}
