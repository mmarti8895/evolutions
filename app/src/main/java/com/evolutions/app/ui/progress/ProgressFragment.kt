package com.evolutions.app.ui.progress

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evolutions.app.data.ProgressManager
import com.evolutions.app.databinding.FragmentProgressBinding

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
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshProgress()
    }

    private fun observeViewModel() {
        viewModel.evolutionGrade.observe(viewLifecycleOwner) { grade ->
            binding.textEvolutionGrade.text = grade
        }

        viewModel.gradeColor.observe(viewLifecycleOwner) { color ->
            try {
                binding.textEvolutionGrade.setTextColor(Color.parseColor(color))
            } catch (_: Exception) { }
        }

        viewModel.totalWorkouts.observe(viewLifecycleOwner) { total ->
            binding.textTotalWorkouts.text = total.toString()

            // Calculate workouts to next grade
            val thresholds = listOf(9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108, 117, 126, 135, 144, 153)
            val nextThreshold = thresholds.firstOrNull { it > total }
            binding.textGradeNext.text = if (nextThreshold != null) {
                "${nextThreshold - total} workouts to next grade"
            } else {
                "MAX GRADE ACHIEVED! 🏆"
            }
        }

        viewModel.fitnessScore.observe(viewLifecycleOwner) { score ->
            binding.progressFitness.progress = score
            binding.textFitnessScore.text = "$score / 100"
        }

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
