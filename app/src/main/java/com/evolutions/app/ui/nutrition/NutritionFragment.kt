package com.evolutions.app.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evolutions.app.databinding.FragmentNutritionBinding
import com.google.android.material.chip.Chip

class NutritionFragment : Fragment() {

    private var _binding: FragmentNutritionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NutritionViewModel by viewModels()
    private lateinit var adapter: NutritionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNutritionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupCategoryChips()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = NutritionAdapter()
        binding.recyclerViewNutrition.adapter = adapter
    }

    private fun setupCategoryChips() {
        viewModel.categories.forEach { category ->
            val chip = Chip(requireContext()).apply {
                text = category
                isCheckable = true
                isChecked = category == "All"
                setOnClickListener {
                    viewModel.filterByCategory(category)
                }
            }
            binding.chipGroupCategories.addView(chip)
        }
    }

    private fun observeViewModel() {
        viewModel.nutritionItems.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
