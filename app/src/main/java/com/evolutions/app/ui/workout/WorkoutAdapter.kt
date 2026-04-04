package com.evolutions.app.ui.workout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolutions.app.data.models.WorkoutPlan
import com.evolutions.app.databinding.ItemWorkoutBinding

class WorkoutAdapter : ListAdapter<WorkoutPlan, WorkoutAdapter.WorkoutViewHolder>(WorkoutDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val binding = ItemWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WorkoutViewHolder(private val binding: ItemWorkoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plan: WorkoutPlan) {
            binding.textWorkoutName.text = plan.name
            binding.textWorkoutDescription.text = plan.description
            binding.textWorkoutFocus.text = "Focus: ${plan.focusArea}"
            binding.textWorkoutDifficulty.text = plan.difficultyLevel
            binding.textWorkoutDuration.text = "${plan.durationMinutes} min"
            binding.textExerciseCount.text = "${plan.exercises.size} exercises"

            val exerciseSummary = plan.exercises.joinToString("\n") { exercise ->
                "• ${exercise.name} — ${exercise.sets}×${exercise.reps}"
            }
            binding.textExerciseSummary.text = exerciseSummary

            val hasModifications = plan.exercises.any { it.modifications.isNotEmpty() }
            if (hasModifications) {
                val firstMod = plan.exercises.first { it.modifications.isNotEmpty() }
                binding.textModificationNote.text = "⚠️ ${firstMod.modifications}"
            } else {
                binding.textModificationNote.text = ""
            }
        }
    }

    private class WorkoutDiffCallback : DiffUtil.ItemCallback<WorkoutPlan>() {
        override fun areItemsTheSame(oldItem: WorkoutPlan, newItem: WorkoutPlan) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: WorkoutPlan, newItem: WorkoutPlan) =
            oldItem == newItem
    }
}
