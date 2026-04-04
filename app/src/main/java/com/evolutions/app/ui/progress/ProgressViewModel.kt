package com.evolutions.app.ui.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evolutions.app.data.models.KnowledgeDomain
import com.evolutions.app.data.models.ProgressEntry
import java.util.Calendar

class ProgressViewModel : ViewModel() {

    private val _currentPhase = MutableLiveData<Int>(1)
    val currentPhase: LiveData<Int> = _currentPhase

    private val _currentWeek = MutableLiveData<Int>(1)
    val currentWeek: LiveData<Int> = _currentWeek

    private val _strengthScore = MutableLiveData<Int>(5)
    val strengthScore: LiveData<Int> = _strengthScore

    private val _staminaScore = MutableLiveData<Int>(5)
    val staminaScore: LiveData<Int> = _staminaScore

    private val _wellbeingScore = MutableLiveData<Int>(10)
    val wellbeingScore: LiveData<Int> = _wellbeingScore

    private val _progressEntries = MutableLiveData<List<ProgressEntry>>()
    val progressEntries: LiveData<List<ProgressEntry>> = _progressEntries

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

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        _progressEntries.value = listOf(
            ProgressEntry(
                id = 1,
                date = Calendar.getInstance().timeInMillis,
                weightLbs = 195f,
                workoutsCompleted = 0,
                strengthScore = 5,
                staminaScore = 5,
                wellbeingScore = 10,
                notes = "Starting point. Feeling hopeful and ready to begin my evolution."
            )
        )

        _milestones.value = listOf(
            Milestone("Starting Line 🌟", "You showed up. That's everything.", "🌟", true),
            Milestone("First Workout Complete!", "You moved your body. That matters.", "💪", false),
            Milestone("One Week Strong!", "7 days of intention and action.", "🔥", false),
            Milestone("First 5 Workouts!", "Consistency is building.", "⭐", false),
            Milestone("Two Weeks of Consistency!", "Your body is already adapting.", "🚀", false),
            Milestone("First Month Champion!", "30 days of showing up for yourself.", "🏆", false),
            Milestone("Phase 1 Complete!", "Foundation built. You're ready to build.", "🦋", false),
            Milestone("Phase 2 Complete!", "You're stronger than when you started.", "💜", false)
        )

        _knowledgeDomains.value = listOf(
            KnowledgeDomain(
                id = 1,
                name = "Cybersecurity & Zero Trust",
                description = "Deepen expertise in your professional domain. Zero Trust, threat modeling, and beyond.",
                icon = "🔐",
                topics = listOf(
                    "Zero Trust Architecture principles",
                    "Identity and Access Management",
                    "Threat modeling frameworks (STRIDE, PASTA)",
                    "Security Operations Center workflows",
                    "Cloud security fundamentals"
                ),
                dailyChallengeQuestion = "What is the difference between authentication and authorization, and why does Zero Trust require both at every access point?",
                resourceLinks = listOf(
                    "https://www.nist.gov/publications/zero-trust-architecture",
                    "https://csrc.nist.gov/publications/detail/sp/800-207/final"
                ),
                progressPercent = 65
            ),
            KnowledgeDomain(
                id = 2,
                name = "Exercise Science & Physiology",
                description = "Understand what's happening in your body during exercise, recovery, and adaptation.",
                icon = "💪",
                topics = listOf(
                    "Muscle fiber types and how they adapt",
                    "The science of DOMS (delayed onset muscle soreness)",
                    "How cardiovascular fitness develops",
                    "Hormones and exercise (estrogen, cortisol, growth hormone)",
                    "Injury recovery and tissue remodeling"
                ),
                dailyChallengeQuestion = "Why do muscles get stronger during rest rather than during exercise? What cellular processes drive this adaptation?",
                resourceLinks = listOf(
                    "https://www.acsm.org/education-resources/",
                    "https://www.ncbi.nlm.nih.gov/books/NBK279395/"
                ),
                progressPercent = 15
            ),
            KnowledgeDomain(
                id = 3,
                name = "Nutrition Science",
                description = "Build evidence-based knowledge around food, inflammation, gut health, and recovery nutrition.",
                icon = "🥗",
                topics = listOf(
                    "Macronutrient roles in muscle building",
                    "Crohn's Disease and the gut-brain axis",
                    "Anti-inflammatory diet patterns",
                    "Micronutrient deficiencies common in IBD",
                    "Protein timing for muscle protein synthesis"
                ),
                dailyChallengeQuestion = "What is the difference between soluble and insoluble fiber, and why is soluble fiber generally safer for Crohn's Disease management?",
                resourceLinks = listOf(
                    "https://www.crohnscolitisfoundation.org/diet-and-nutrition",
                    "https://examine.com/supplements/omega-3-fatty-acids/"
                ),
                progressPercent = 20
            ),
            KnowledgeDomain(
                id = 4,
                name = "Mind-Body & Wellbeing",
                description = "Explore the science of mental resilience, stress management, and the mind-body connection in health.",
                icon = "🧘",
                topics = listOf(
                    "Neuroplasticity and habit formation",
                    "The HPA axis and chronic stress",
                    "Sleep's role in recovery and hormone regulation",
                    "Mindfulness and pain perception",
                    "Building self-compassion as a foundation"
                ),
                dailyChallengeQuestion = "What is neuroplasticity, and how does consistent positive behavior change literally reshape the brain over time?",
                resourceLinks = listOf(
                    "https://www.mindful.org/",
                    "https://www.apa.org/topics/resilience"
                ),
                progressPercent = 30
            ),
            KnowledgeDomain(
                id = 5,
                name = "Transgender Health & Medicine",
                description = "Knowledge about gender-affirming care, HRT effects on the body, and navigating healthcare as a trans woman.",
                icon = "💜",
                topics = listOf(
                    "How estrogen therapy affects muscle, fat, and bones",
                    "Cardiovascular considerations with HRT",
                    "Exercise adaptations specific to trans women",
                    "Navigating medical advocacy and finding affirming care",
                    "Mental health resources and community connection"
                ),
                dailyChallengeQuestion = "How does estrogen therapy affect bone density, and why is weight-bearing exercise particularly important for trans women on HRT?",
                resourceLinks = listOf(
                    "https://transcare.ucsf.edu/guidelines",
                    "https://www.outcarehealth.org/"
                ),
                progressPercent = 40
            )
        )
    }

    fun addWorkoutEntry(notes: String = "") {
        val current = _progressEntries.value?.toMutableList() ?: mutableListOf()
        val lastEntry = current.lastOrNull()
        val newEntry = ProgressEntry(
            id = current.size + 1,
            date = Calendar.getInstance().timeInMillis,
            weightLbs = lastEntry?.weightLbs ?: 195f,
            workoutsCompleted = (lastEntry?.workoutsCompleted ?: 0) + 1,
            strengthScore = minOf(100, (_strengthScore.value ?: 5) + 2),
            staminaScore = minOf(100, (_staminaScore.value ?: 5) + 2),
            wellbeingScore = minOf(100, (_wellbeingScore.value ?: 10) + 1),
            notes = notes.ifEmpty { "Workout completed!" }
        )
        current.add(newEntry)
        _progressEntries.value = current
        _strengthScore.value = newEntry.strengthScore
        _staminaScore.value = newEntry.staminaScore
        _wellbeingScore.value = newEntry.wellbeingScore
    }
}
