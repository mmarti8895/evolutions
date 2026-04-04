package com.evolutions.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evolutions.app.data.models.Exercise
import com.evolutions.app.data.models.KnowledgeDomain
import com.evolutions.app.data.models.NutritionItem
import com.evolutions.app.data.models.WorkoutPlan
import java.util.Calendar

class HomeViewModel : ViewModel() {

    private val _motivationalMessage = MutableLiveData<String>()
    val motivationalMessage: LiveData<String> = _motivationalMessage

    private val _todayWorkout = MutableLiveData<WorkoutPlan>()
    val todayWorkout: LiveData<WorkoutPlan> = _todayWorkout

    private val _dailyNutritionTip = MutableLiveData<String>()
    val dailyNutritionTip: LiveData<String> = _dailyNutritionTip

    private val _dailyKnowledgeChallenge = MutableLiveData<String>()
    val dailyKnowledgeChallenge: LiveData<String> = _dailyKnowledgeChallenge

    private val _currentWeek = MutableLiveData<Int>()
    val currentWeek: LiveData<Int> = _currentWeek

    private val _workoutsCompleted = MutableLiveData<Int>()
    val workoutsCompleted: LiveData<Int> = _workoutsCompleted

    private val _currentStreak = MutableLiveData<Int>()
    val currentStreak: LiveData<Int> = _currentStreak

    private val motivationalMessages = listOf(
        "Every single step forward is a victory. You are rewriting your story, one workout at a time. 💜",
        "Seven years away doesn't define you — coming back defines you. Welcome to your evolution. ✨",
        "Your body is remarkable. It has healed, adapted, and is ready to grow stronger with you. 🌱",
        "Progress is not linear, and that's perfectly okay. Celebrate every moment of movement. 🎉",
        "You are not starting over — you are starting from experience, wisdom, and incredible strength. 💪",
        "Small steps taken consistently build mountains. Today's workout matters more than you know. 🏔️",
        "Your journey is uniquely yours. Honor your body, respect your limits, and celebrate your courage. 🦋"
    )

    private val nutritionTips = listOf(
        "💧 Stay hydrated! Aim for 8–10 glasses of water daily. Proper hydration supports joint health and reduces Crohn's inflammation.",
        "🍌 Bananas are your friend! Easy to digest, potassium-rich, and perfect pre-workout fuel for gentle energy.",
        "🍗 Well-cooked chicken breast is an excellent lean protein. Aim for 20–30g of protein within an hour after exercise.",
        "🐟 Salmon twice a week provides omega-3 fatty acids that fight inflammation — great for arthritis and injury recovery.",
        "🍚 White rice is a Crohn's-friendly carb that's gentle on the gut. Pair it with protein for balanced recovery meals.",
        "🫚 A drizzle of olive oil adds healthy fats and anti-inflammatory compounds. Use it on cooked vegetables.",
        "🫚 Bone broth is rich in collagen and glycine — soothing for the gut lining and supportive for joint recovery."
    )

    private val knowledgeChallenges = listOf(
        "🧠 Cybersecurity: What does Zero Trust Architecture mean and why is 'never trust, always verify' its core principle?",
        "💪 Exercise Science: Why does muscle soreness peak 24–48 hours after a workout? (Hint: it's called DOMS)",
        "🧬 Biology: How does estrogen therapy affect muscle development, bone density, and recovery in women?",
        "🌿 Nutrition: What is the difference between soluble and insoluble fiber, and why does it matter for Crohn's Disease?",
        "🔐 Technology: What is the difference between authentication and authorization in cybersecurity systems?",
        "🏃 Physiology: What happens to your cardiovascular system during the first 4 weeks of returning to exercise?",
        "🧘 Mind-Body: What is the science behind the 'rest and recovery' phase — why do muscles grow during rest, not exercise?"
    )

    init {
        loadDailyContent()
    }

    private fun loadDailyContent() {
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        _motivationalMessage.value = motivationalMessages[dayOfYear % motivationalMessages.size]
        _dailyNutritionTip.value = nutritionTips[dayOfYear % nutritionTips.size]
        _dailyKnowledgeChallenge.value = knowledgeChallenges[dayOfYear % knowledgeChallenges.size]

        _currentWeek.value = 1
        _workoutsCompleted.value = 0
        _currentStreak.value = 0

        _todayWorkout.value = WorkoutPlan(
            id = 1,
            name = "Foundation Day 1: Gentle Awakening",
            description = "A gentle reintroduction to movement. Focus on form and how your body feels. No pain, only activation.",
            phase = 1,
            weekNumber = 1,
            exercises = listOf(
                Exercise(
                    id = 1,
                    name = "10-Minute Gentle Walk",
                    description = "Slow, comfortable pace. Focus on breathing and posture.",
                    sets = 1,
                    reps = "10 minutes",
                    restSeconds = 0,
                    modifications = "Walk on flat ground. If knee aches, reduce to 5 minutes.",
                    isLowImpact = true,
                    targetMuscleGroup = "Full Body / Cardiovascular",
                    injuryConsiderations = "Easy on all joints. Safe for MCL, rotator cuffs, and clavicle."
                ),
                Exercise(
                    id = 2,
                    name = "Wall Push-Up",
                    description = "Stand arm's length from wall, place hands shoulder-width apart. Push in and out slowly.",
                    sets = 2,
                    reps = "8-10",
                    restSeconds = 60,
                    modifications = "Move feet further from wall to reduce difficulty. Do not lock elbows.",
                    isLowImpact = true,
                    targetMuscleGroup = "Chest, Shoulders (rotator-cuff safe)",
                    injuryConsiderations = "No overhead movement. Safe for rotator cuffs and metal plate."
                ),
                Exercise(
                    id = 3,
                    name = "Bird Dog",
                    description = "On hands and knees, extend opposite arm and leg while keeping core stable.",
                    sets = 2,
                    reps = "8 each side",
                    restSeconds = 45,
                    modifications = "Start with just leg extension, add arm when comfortable.",
                    isLowImpact = true,
                    targetMuscleGroup = "Core, Glutes, Back",
                    injuryConsiderations = "No spinal compression. Gentle on all injured areas."
                )
            ),
            durationMinutes = 25,
            focusArea = "Full Body Activation",
            difficultyLevel = "Very Easy"
        )
    }
}
