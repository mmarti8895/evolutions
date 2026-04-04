package com.evolutions.app.ui.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evolutions.app.data.ProgressManager
import com.evolutions.app.data.models.KnowledgeDomain

class ProgressViewModel : ViewModel() {

    private val _currentPhase = MutableLiveData<Int>(1)
    val currentPhase: LiveData<Int> = _currentPhase

    private val _currentWeek = MutableLiveData<Int>(1)
    val currentWeek: LiveData<Int> = _currentWeek

    private val _fitnessScore = MutableLiveData<Int>(0)
    val fitnessScore: LiveData<Int> = _fitnessScore

    private val _evolutionGrade = MutableLiveData<String>("F-")
    val evolutionGrade: LiveData<String> = _evolutionGrade

    private val _gradeColor = MutableLiveData<String>("#B00020")
    val gradeColor: LiveData<String> = _gradeColor

    private val _totalWorkouts = MutableLiveData<Int>(0)
    val totalWorkouts: LiveData<Int> = _totalWorkouts

    private val _milestones = MutableLiveData<List<Milestone>>()
    val milestones: LiveData<List<Milestone>> = _milestones

    private val _knowledgeDomains = MutableLiveData<List<KnowledgeDomain>>()
    val knowledgeDomains: LiveData<List<KnowledgeDomain>> = _knowledgeDomains

    data class Milestone(
        val title: String,
        val description: String,
        val emoji: String,
        val achieved: Boolean
    )

    // Knowledge topic IDs by category
    private val knowledgeIdsByCategory = mapOf(
        "Cybersecurity" to listOf(1, 2, 3, 4),
        "Exercise Science" to listOf(10, 11, 12),
        "Nutrition" to listOf(20, 21, 22),
        "Biology" to listOf(30, 31, 32),
        "Mindfulness" to listOf(40, 41, 42)
    )

    // Thai word IDs by category
    private val thaiIdsByCategory = mapOf(
        "Greetings" to listOf(1, 2, 3, 4, 5, 6),
        "Muay Thai" to listOf(10, 11, 12, 13, 14, 15, 16, 17, 18, 19),
        "Numbers" to listOf(20, 21, 22, 23, 24, 25),
        "Food" to listOf(30, 31, 32, 33, 34, 35),
        "Essentials" to listOf(40, 41, 42, 43, 44),
        "Polite" to listOf(50, 51, 52, 53)
    )

    init {
        refreshProgress()
    }

    fun refreshProgress() {
        val total = ProgressManager.getTotalWorkoutsLogged()
        _totalWorkouts.value = total
        _fitnessScore.value = ProgressManager.getFitnessScore()
        _evolutionGrade.value = ProgressManager.getEvolutionGrade()
        _gradeColor.value = ProgressManager.getGradeColor()

        // Phase based on total workouts: 1-24 = Phase 1, 25-48 = Phase 2, 49+ = Phase 3
        val phase = when {
            total < 24 -> 1
            total < 48 -> 2
            else -> 3
        }
        _currentPhase.value = phase

        // Week within phase (3 workouts per week)
        val weekInPhase = (total % 24) / 3 + 1
        _currentWeek.value = weekInPhase

        updateMilestones(total)
        updateKnowledgeDomains()
    }

    private fun updateMilestones(totalWorkouts: Int) {
        _milestones.value = listOf(
            Milestone("Starting Line 🌟", "You showed up. That's everything.", "🌟", true),
            Milestone("First Workout Complete!", "You moved your body. That matters.", "💪", totalWorkouts >= 1),
            Milestone("One Week Strong!", "3 workouts of intention and action.", "🔥", totalWorkouts >= 3),
            Milestone("First 5 Workouts!", "Consistency is building.", "⭐", totalWorkouts >= 5),
            Milestone("Two Weeks Strong!", "Your body is already adapting.", "🚀", totalWorkouts >= 6),
            Milestone("First Month Champion!", "12 workouts — a month of showing up!", "🏆", totalWorkouts >= 12),
            Milestone("Phase 1 Complete!", "Foundation built. You're ready to build.", "🦋", totalWorkouts >= 24),
            Milestone("Phase 2 Complete!", "You're stronger than when you started.", "💜", totalWorkouts >= 48)
        )
    }

    private fun updateKnowledgeDomains() {
        val completedKnowledge = ProgressManager.getCompletedKnowledgeIds()
        val completedThai = ProgressManager.getCompletedThaiIds()

        val totalThaiIds = thaiIdsByCategory.values.flatten()
        val thaiCompleted = totalThaiIds.count { it in completedThai }
        val thaiPercent = if (totalThaiIds.isNotEmpty()) (thaiCompleted * 100) / totalThaiIds.size else 0

        _knowledgeDomains.value = listOf(
            buildDomain(1, "Thai Language", "🇹🇭", thaiPercent),
            buildDomain(2, "Cybersecurity & Zero Trust", "🔐",
                calcKnowledgePercent("Cybersecurity", completedKnowledge)),
            buildDomain(3, "Exercise Science & Physiology", "💪",
                calcKnowledgePercent("Exercise Science", completedKnowledge)),
            buildDomain(4, "Nutrition Science", "🥗",
                calcKnowledgePercent("Nutrition", completedKnowledge)),
            buildDomain(5, "Biology", "🧬",
                calcKnowledgePercent("Biology", completedKnowledge)),
            buildDomain(6, "Mindfulness & Wellbeing", "🧘",
                calcKnowledgePercent("Mindfulness", completedKnowledge))
        )
    }

    private fun calcKnowledgePercent(category: String, completedIds: Set<Int>): Int {
        val ids = knowledgeIdsByCategory[category] ?: return 0
        val completed = ids.count { it in completedIds }
        return if (ids.isNotEmpty()) (completed * 100) / ids.size else 0
    }

    private fun buildDomain(id: Int, name: String, icon: String, percent: Int): KnowledgeDomain {
        return KnowledgeDomain(
            id = id,
            name = name,
            description = "",
            icon = icon,
            topics = emptyList(),
            dailyChallengeQuestion = "",
            resourceLinks = emptyList(),
            progressPercent = percent
        )
    }
}
