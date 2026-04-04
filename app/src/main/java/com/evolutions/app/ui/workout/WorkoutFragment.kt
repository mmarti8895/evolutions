package com.evolutions.app.ui.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evolutions.app.databinding.FragmentWorkoutBinding
import com.google.android.material.tabs.TabLayout

class WorkoutFragment : Fragment() {

    private var _binding: FragmentWorkoutBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WorkoutViewModel by viewModels()
    private lateinit var adapter: WorkoutAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupTabs()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = WorkoutAdapter()
        binding.recyclerViewWorkouts.adapter = adapter
    }

    private fun setupTabs() {
        binding.tabLayoutPhases.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> viewModel.selectPhase(1)
                    1 -> viewModel.selectPhase(2)
                    2 -> viewModel.selectPhase(3)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun observeViewModel() {
        viewModel.filteredPlans.observe(viewLifecycleOwner) { plans ->
            adapter.submitList(plans)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
