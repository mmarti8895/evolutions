package com.evolutions.app.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evolutions.app.databinding.FragmentProgressBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProgressViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        observeViewModel()
    }

    private fun setupClickListeners() {
        binding.buttonLogWorkout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Log Workout Complete! 💪")
                .setMessage("Amazing work! You showed up for yourself today. Your scores will update to reflect your progress.")
                .setPositiveButton("Log It!") { _, _ ->
                    viewModel.addWorkoutEntry()
                }
                .setNegativeButton("Not Yet", null)
                .show()
        }
    }

    private fun observeViewModel() {
        viewModel.currentPhase.observe(viewLifecycleOwner) { phase ->
            val phaseName = when (phase) {
                1 -> "Phase 1: Foundation"
                2 -> "Phase 2: Building"
                3 -> "Phase 3: Advancing"
                else -> "Phase 1: Foundation"
            }
            binding.textCurrentPhase.text = phaseName
            binding.progressPhaseBar.progress = when (phase) {
                1 -> 33
                2 -> 66
                3 -> 100
                else -> 33
            }
        }

        viewModel.currentWeek.observe(viewLifecycleOwner) { week ->
            binding.textCurrentWeek.text = "Week $week of Your Evolution"
        }

        viewModel.strengthScore.observe(viewLifecycleOwner) { score ->
            binding.progressStrength.progress = score
            binding.textStrengthScore.text = "$score / 100"
        }

        viewModel.staminaScore.observe(viewLifecycleOwner) { score ->
            binding.progressStamina.progress = score
            binding.textStaminaScore.text = "$score / 100"
        }

        viewModel.wellbeingScore.observe(viewLifecycleOwner) { score ->
            binding.progressWellbeing.progress = score
            binding.textWellbeingScore.text = "$score / 100"
        }

        viewModel.progressEntries.observe(viewLifecycleOwner) { entries ->
            binding.textTotalWorkouts.text = (entries.lastOrNull()?.workoutsCompleted ?: 0).toString()
        }

        viewModel.milestones.observe(viewLifecycleOwner) { milestones ->
            binding.textMilestones.text = milestones.joinToString("\n") { milestone ->
                val status = if (milestone.achieved) "✅" else "⬜"
                "$status  ${milestone.emoji} ${milestone.title}"
            }
        }

        viewModel.knowledgeDomains.observe(viewLifecycleOwner) { domains ->
            binding.textKnowledgeDomains.text = domains.joinToString("\n\n") { domain ->
                "${domain.icon} ${domain.name}\n${domain.progressPercent}% explored"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
