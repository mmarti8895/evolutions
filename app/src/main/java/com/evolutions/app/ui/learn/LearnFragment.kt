package com.evolutions.app.ui.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.evolutions.app.databinding.FragmentLearnBinding
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabLayout

class LearnFragment : Fragment() {

    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LearnViewModel by viewModels()
    private lateinit var thaiAdapter: ThaiWordAdapter
    private lateinit var knowledgeAdapter: KnowledgeAdapter
    private lateinit var lessonAdapter: LessonAdapter
    private lateinit var scriptAdapter: ScriptAdapter
    private lateinit var bookAdapter: BookAdapter
    private lateinit var videoAdapter: VideoAdapter

    private var currentThaiSection: String = "🗣️ Words"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        thaiAdapter = ThaiWordAdapter()
        knowledgeAdapter = KnowledgeAdapter()
        lessonAdapter = LessonAdapter()
        scriptAdapter = ScriptAdapter()
        bookAdapter = BookAdapter()
        videoAdapter = VideoAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabs()
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupTabs() {
        binding.tabLayoutLearn.addTab(binding.tabLayoutLearn.newTab().setText("🇹🇭 Thai Language"))
        binding.tabLayoutLearn.addTab(binding.tabLayoutLearn.newTab().setText("🧠 Knowledge"))

        binding.tabLayoutLearn.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        viewModel.selectTab("Thai")
                        showThaiSections()
                    }
                    1 -> {
                        viewModel.selectTab("Knowledge")
                        showKnowledgeView()
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        showThaiSections()
    }

    private fun showThaiSections() {
        setupSectionChips(viewModel.thaiSections) { section ->
            currentThaiSection = section
            showThaiSection(section)
        }
        showThaiSection(currentThaiSection)
    }

    private fun showThaiSection(section: String) {
        when (section) {
            "🗣️ Words" -> {
                binding.recyclerViewLearn.adapter = thaiAdapter
                showSubcategoryChips(viewModel.thaiCategories) { category ->
                    viewModel.filterThaiByCategory(category)
                }
            }
            "📚 Lessons" -> {
                binding.recyclerViewLearn.adapter = lessonAdapter
                showSubcategoryChips(viewModel.lessonCategories) { category ->
                    viewModel.filterLessonsByCategory(category)
                }
            }
            "🔤 Scripts" -> {
                binding.recyclerViewLearn.adapter = scriptAdapter
                showSubcategoryChips(viewModel.scriptCategories) { category ->
                    viewModel.filterScriptsByCategory(category)
                }
            }
            "📖 Library" -> {
                binding.recyclerViewLearn.adapter = bookAdapter
                showSubcategoryChips(viewModel.bookCategories) { category ->
                    viewModel.filterBooksByCategory(category)
                }
            }
            "🎬 Videos" -> {
                binding.recyclerViewLearn.adapter = videoAdapter
                showSubcategoryChips(viewModel.videoCategories) { category ->
                    viewModel.filterVideosByCategory(category)
                }
            }
        }
    }

    private fun showKnowledgeView() {
        binding.recyclerViewLearn.adapter = knowledgeAdapter
        setupSectionChips(viewModel.knowledgeCategories) { category ->
            viewModel.filterKnowledgeByCategory(category)
        }
        binding.scrollSubcategory.visibility = View.GONE
    }

    private fun setupSectionChips(categories: List<String>, onSelected: (String) -> Unit) {
        binding.chipGroupLearn.removeAllViews()
        categories.forEachIndexed { index, category ->
            val chip = Chip(requireContext()).apply {
                text = category
                isCheckable = true
                isChecked = index == 0
                setOnClickListener {
                    onSelected(category)
                }
            }
            binding.chipGroupLearn.addView(chip)
        }
    }

    private fun showSubcategoryChips(categories: List<String>, onSelected: (String) -> Unit) {
        binding.chipGroupSubcategory.removeAllViews()
        categories.forEachIndexed { index, category ->
            val chip = Chip(requireContext()).apply {
                text = category
                isCheckable = true
                isChecked = index == 0
                setOnClickListener {
                    onSelected(category)
                }
            }
            binding.chipGroupSubcategory.addView(chip)
        }
        binding.scrollSubcategory.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        binding.recyclerViewLearn.adapter = thaiAdapter
    }

    private fun observeViewModel() {
        viewModel.filteredThaiWords.observe(viewLifecycleOwner) { words ->
            thaiAdapter.submitList(words)
        }
        viewModel.filteredKnowledge.observe(viewLifecycleOwner) { topics ->
            knowledgeAdapter.submitList(topics)
        }
        viewModel.filteredLessons.observe(viewLifecycleOwner) { lessons ->
            lessonAdapter.submitList(lessons)
        }
        viewModel.filteredScripts.observe(viewLifecycleOwner) { scripts ->
            scriptAdapter.submitList(scripts)
        }
        viewModel.filteredBooks.observe(viewLifecycleOwner) { books ->
            bookAdapter.submitList(books)
        }
        viewModel.filteredVideos.observe(viewLifecycleOwner) { videos ->
            videoAdapter.submitList(videos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        thaiAdapter.releasePlayer()
        _binding = null
    }
}
