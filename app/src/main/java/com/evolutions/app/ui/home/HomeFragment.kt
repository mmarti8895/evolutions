package com.evolutions.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evolutions.app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.motivationalMessage.observe(viewLifecycleOwner) { message ->
            binding.textMotivationalMessage.text = message
        }

        viewModel.todayWorkout.observe(viewLifecycleOwner) { workout ->
            binding.textTodayWorkoutName.text = workout.name
            binding.textTodayWorkoutDescription.text = workout.description
            binding.textTodayWorkoutDuration.text = "${workout.durationMinutes} min · ${workout.difficultyLevel}"
        }

        viewModel.dailyNutritionTip.observe(viewLifecycleOwner) { tip ->
            binding.textNutritionTip.text = tip
        }

        viewModel.dailyKnowledgeChallenge.observe(viewLifecycleOwner) { challenge ->
            binding.textKnowledgeChallenge.text = challenge
        }

        viewModel.currentWeek.observe(viewLifecycleOwner) { week ->
            binding.textCurrentWeek.text = "Week $week"
        }

        viewModel.workoutsCompleted.observe(viewLifecycleOwner) { count ->
            binding.textWorkoutsCompleted.text = count.toString()
        }

        viewModel.currentStreak.observe(viewLifecycleOwner) { streak ->
            binding.textCurrentStreak.text = "$streak days"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
