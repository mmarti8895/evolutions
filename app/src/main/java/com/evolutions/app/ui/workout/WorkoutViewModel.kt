package com.evolutions.app.ui.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evolutions.app.data.models.Exercise
import com.evolutions.app.data.models.WorkoutPlan

class WorkoutViewModel : ViewModel() {

    private val _workoutPlans = MutableLiveData<List<WorkoutPlan>>()
    val workoutPlans: LiveData<List<WorkoutPlan>> = _workoutPlans

    private val _selectedPhase = MutableLiveData<Int>(1)
    val selectedPhase: LiveData<Int> = _selectedPhase

    private val _selectedWeek = MutableLiveData<Int>(1)
    val selectedWeek: LiveData<Int> = _selectedWeek

    private val _filteredPlans = MutableLiveData<List<WorkoutPlan>>()
    val filteredPlans: LiveData<List<WorkoutPlan>> = _filteredPlans

    init {
        loadWorkoutPlans()
    }

    fun selectPhase(phase: Int) {
        _selectedPhase.value = phase
        _selectedWeek.value = 1
        filterPlans(phase, 1)
    }

    fun selectWeek(week: Int) {
        _selectedWeek.value = week
        filterPlans(_selectedPhase.value ?: 1, week)
    }

    private fun filterPlans(phase: Int, week: Int) {
        val phaseWeek = when (phase) {
            1 -> week
            2 -> week + 8
            3 -> week + 16
            else -> week
        }
        _filteredPlans.value = _workoutPlans.value?.filter { it.phase == phase && it.weekNumber == phaseWeek }
    }

    private fun loadWorkoutPlans() {
        val plans = buildWorkoutPlans()
        _workoutPlans.value = plans
        filterPlans(1, 1)
    }

    private fun buildWorkoutPlans(): List<WorkoutPlan> {
        val plans = mutableListOf<WorkoutPlan>()
        var id = 1
        var exId = 1

        // ══════════════════════════════════════════════════════════════════════
        // PHASE 1: FOUNDATION (Weeks 1–8) — 3 days/week
        // Gentle reintroduction, basic movements, flexibility
        // ══════════════════════════════════════════════════════════════════════

        // ── Week 1 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 1 — Day 1: Gentle Cardio",
            description = "Reintroduce your body to movement. Walk at a comfortable pace and focus on breathing.",
            phase = 1, weekNumber = 1, durationMinutes = 20, focusArea = "Cardiovascular", difficultyLevel = "Very Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "10-Minute Gentle Walk", description = "Walk at a conversational pace on flat ground. Focus on breathing deeply and posture.", sets = 1, reps = "10 minutes", restSeconds = 0, modifications = "If knee aches, shorten to 5 minutes.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Flat ground only. Safe for MCL and rotator cuffs."),
                Exercise(id = exId++, name = "Seated Marching", description = "Sit in a sturdy chair and alternate lifting each knee. Engages core and hip flexors.", sets = 2, reps = "20 total (10 each leg)", restSeconds = 30, modifications = "Hold sides of chair for balance.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Core", injuryConsiderations = "No stress on MCL or upper body."),
                Exercise(id = exId++, name = "Standing Calf Raises", description = "Hold a wall for balance. Rise on toes slowly, then lower.", sets = 2, reps = "12-15", restSeconds = 45, modifications = "Hold a wall. Don't lock knee.", isLowImpact = true, targetMuscleGroup = "Calves", injuryConsiderations = "No MCL stress. Gentle on joints.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 1 — Day 2: Basic Strength",
            description = "Activate major muscle groups with gentle body-weight exercises.",
            phase = 1, weekNumber = 1, durationMinutes = 25, focusArea = "Strength", difficultyLevel = "Very Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Wall Push-Up", description = "Stand arm's length from wall. Place hands shoulder-width. Lower nose toward wall, push back.", sets = 2, reps = "8-10", restSeconds = 60, modifications = "Adjust distance from wall to change difficulty.", isLowImpact = true, targetMuscleGroup = "Chest, Shoulders", injuryConsiderations = "No overhead. Safe for rotator cuffs."),
                Exercise(id = exId++, name = "Glute Bridge", description = "Lie on back, knees bent, feet flat. Press through heels and lift hips.", sets = 2, reps = "10-12", restSeconds = 60, modifications = "Pillow under lower back if uncomfortable.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings, Core", injuryConsiderations = "No MCL stress. No shoulder involvement."),
                Exercise(id = exId++, name = "Bird Dog", description = "Hands and knees. Extend right arm forward and left leg back simultaneously. Hold 2 sec.", sets = 2, reps = "8 each side", restSeconds = 45, modifications = "Start with leg-only extension.", isLowImpact = true, targetMuscleGroup = "Core, Glutes, Lower Back", injuryConsiderations = "Safe for all listed injuries."),
                Exercise(id = exId++, name = "Resistance Band Pull-Apart", description = "Hold light band at chest height. Pull apart squeezing shoulder blades.", sets = 2, reps = "12-15", restSeconds = 60, modifications = "Use lightest band. Focus on scapular retraction.", isLowImpact = true, targetMuscleGroup = "Upper Back, Rotator Cuff", injuryConsiderations = "Rehabilitates rotator cuffs. No overhead movement.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 1 — Day 3: Stretch & Recovery",
            description = "Core stability and stretching to begin building foundation.",
            phase = 1, weekNumber = 1, durationMinutes = 20, focusArea = "Flexibility & Core", difficultyLevel = "Very Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Dead Bug", description = "Lie on back, arms up, knees 90°. Lower opposite arm and leg while breathing out.", sets = 2, reps = "6 each side", restSeconds = 60, modifications = "Only extend leg at first.", isLowImpact = true, targetMuscleGroup = "Deep Core", injuryConsiderations = "No joint loading. Safe for all injuries."),
                Exercise(id = exId++, name = "Gentle Supine Spinal Twist", description = "Lie on back, bring knee across body. Hold 30 seconds each side.", sets = 1, reps = "30 seconds each side", restSeconds = 15, modifications = "Pillow between knees if needed.", isLowImpact = true, targetMuscleGroup = "Spine, Hips", injuryConsiderations = "Do not force. Safe for arthritis."),
                Exercise(id = exId++, name = "Child's Pose", description = "Kneel and sit back toward heels, arms extended forward. Hold and breathe.", sets = 1, reps = "60 seconds", restSeconds = 0, modifications = "Blanket under knees. Widen knees if needed.", isLowImpact = true, targetMuscleGroup = "Lower Back, Hips, Shoulders", injuryConsiderations = "Avoid if knees are acutely painful."),
                Exercise(id = exId++, name = "Neck Rolls & Side Stretches", description = "Slowly roll head in circles. Tilt ear to shoulder, hold 20 sec each side.", sets = 1, reps = "5 circles + 20 sec holds", restSeconds = 0, modifications = "Keep movements slow.", isLowImpact = true, targetMuscleGroup = "Neck, Trapezius", injuryConsiderations = "Gentle on clavicle plate.")
            )))

        // ── Week 2 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 2 — Day 1: Cardio Progression",
            description = "Extend walking duration and add light movement variety.",
            phase = 1, weekNumber = 2, durationMinutes = 25, focusArea = "Cardiovascular", difficultyLevel = "Very Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "15-Minute Walk", description = "Slightly brisker pace than week 1. Maintain good posture and deep breathing.", sets = 1, reps = "15 minutes", restSeconds = 0, modifications = "Slow down if breathless.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Flat ground. Supportive shoes."),
                Exercise(id = exId++, name = "Seated Marching — Faster", description = "Same as week 1 but increase tempo slightly. Lift knees higher.", sets = 3, reps = "20 total", restSeconds = 30, modifications = "Slow down if hips fatigue.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Core", injuryConsiderations = "No knee stress."),
                Exercise(id = exId++, name = "Standing Calf Raises", description = "Rise on toes, hold 1 second at top this week.", sets = 3, reps = "15", restSeconds = 45, modifications = "Hold wall. Both feet.", isLowImpact = true, targetMuscleGroup = "Calves", injuryConsiderations = "Safe for all injuries.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 2 — Day 2: Strength + Core",
            description = "Add reps and introduce new movements as your body adapts.",
            phase = 1, weekNumber = 2, durationMinutes = 30, focusArea = "Strength & Core", difficultyLevel = "Very Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Wall Push-Up", description = "Same form, increased volume.", sets = 3, reps = "10", restSeconds = 60, modifications = "Step slightly further from wall.", isLowImpact = true, targetMuscleGroup = "Chest, Shoulders", injuryConsiderations = "No overhead. Rotator-cuff safe."),
                Exercise(id = exId++, name = "Glute Bridge", description = "Add a 2-second hold at the top this week.", sets = 3, reps = "12", restSeconds = 60, modifications = "Keep core engaged.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings", injuryConsiderations = "MCL-safe. No shoulder involvement."),
                Exercise(id = exId++, name = "Bird Dog", description = "Hold extended position for 3 seconds this week.", sets = 3, reps = "8 each side", restSeconds = 45, modifications = "Keep hips level.", isLowImpact = true, targetMuscleGroup = "Core, Glutes, Lower Back", injuryConsiderations = "Safe for all injuries."),
                Exercise(id = exId++, name = "Dead Bug", description = "Increase to 8 reps each side with controlled breathing.", sets = 3, reps = "8 each side", restSeconds = 60, modifications = "Keep lower back pressed into floor.", isLowImpact = true, targetMuscleGroup = "Deep Core", injuryConsiderations = "No joint loading.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 2 — Day 3: Full Body Stretch",
            description = "Dedicated stretching session. Building flexibility for future Muay Thai work.",
            phase = 1, weekNumber = 2, durationMinutes = 20, focusArea = "Flexibility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Standing Quad Stretch", description = "Hold wall. Bend knee, grab foot behind you. Hold 30 sec each leg.", sets = 1, reps = "30 sec each leg", restSeconds = 0, modifications = "Use strap if can't reach.", isLowImpact = true, targetMuscleGroup = "Quadriceps, Hip Flexors", injuryConsiderations = "Hold wall for MCL safety."),
                Exercise(id = exId++, name = "Hip Flexor Lunge Stretch", description = "Kneel on one knee. Push hips forward gently. Hold 30 seconds each side.", sets = 2, reps = "30 sec each side", restSeconds = 15, modifications = "Hands on front knee for balance.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Psoas", injuryConsiderations = "Pad kneeling knee. Critical for kick flexibility."),
                Exercise(id = exId++, name = "Seated Hamstring Stretch", description = "Sit with one leg extended. Hinge forward at hips. Hold 30 sec each leg.", sets = 2, reps = "30 sec each leg", restSeconds = 15, modifications = "Use towel around foot.", isLowImpact = true, targetMuscleGroup = "Hamstrings, Lower Back", injuryConsiderations = "No MCL stress."),
                Exercise(id = exId++, name = "Shoulder Cross-Body Stretch", description = "Bring arm across chest, press above elbow. Hold 20 sec each side.", sets = 2, reps = "20 sec each side", restSeconds = 0, modifications = "Keep arm below shoulder height.", isLowImpact = true, targetMuscleGroup = "Posterior Deltoid, Rotator Cuff", injuryConsiderations = "Gentle on clavicle plate.")
            )))

        // ── Week 3 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 3 — Day 1: Cardio Endurance",
            description = "Continue building cardiovascular base with longer duration.",
            phase = 1, weekNumber = 3, durationMinutes = 25, focusArea = "Cardiovascular", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "20-Minute Walk", description = "Steady pace for 20 minutes. Try to maintain consistent speed throughout.", sets = 1, reps = "20 minutes", restSeconds = 0, modifications = "Break into two 10-min segments if needed.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Supportive shoes on flat ground."),
                Exercise(id = exId++, name = "Standing Knee Raises", description = "Stand with wall support. Raise each knee to hip height alternately.", sets = 3, reps = "12 each leg", restSeconds = 30, modifications = "Lower height if hip flexors tire.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Core", injuryConsiderations = "No MCL stress. Prepares for Muay Thai knees."),
                Exercise(id = exId++, name = "Heel-to-Toe Walk", description = "Walk in a straight line placing heel directly in front of opposite toe. Builds balance.", sets = 2, reps = "20 steps", restSeconds = 30, modifications = "Walk near a wall for safety.", isLowImpact = true, targetMuscleGroup = "Balance, Ankles, Core", injuryConsiderations = "Safe for all injuries.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 3 — Day 2: Strength Building",
            description = "Progress resistance and add new movement patterns.",
            phase = 1, weekNumber = 3, durationMinutes = 30, focusArea = "Strength", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Incline Push-Up (Counter)", description = "Hands on kitchen counter or sturdy table. Full push-up motion.", sets = 3, reps = "8-10", restSeconds = 60, modifications = "Return to wall push-up if too hard.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps, Shoulders", injuryConsiderations = "No overhead. Monitor clavicle side."),
                Exercise(id = exId++, name = "Glute Bridge — Marching", description = "In bridge position, lift one foot at a time alternately. Keeps hips level.", sets = 3, reps = "8 each leg", restSeconds = 60, modifications = "Lower hips slightly if unstable.", isLowImpact = true, targetMuscleGroup = "Glutes, Core, Hamstrings", injuryConsiderations = "MCL-safe."),
                Exercise(id = exId++, name = "Side-Lying Hip Abduction", description = "Lie on side, raise top leg to 45°, lower slowly.", sets = 3, reps = "12 each side", restSeconds = 45, modifications = "Add ankle weight when easy.", isLowImpact = true, targetMuscleGroup = "Gluteus Medius, Hip Stabilizers", injuryConsiderations = "Zero knee stress. Excellent for MCL recovery."),
                Exercise(id = exId++, name = "Resistance Band Pull-Apart", description = "Increase to 3 sets. Medium resistance band.", sets = 3, reps = "15", restSeconds = 60, modifications = "Use lighter band if shoulders fatigue.", isLowImpact = true, targetMuscleGroup = "Upper Back, Rotator Cuff", injuryConsiderations = "Rehabilitates rotator cuffs.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 3 — Day 3: Stretch & Mobility",
            description = "Deeper stretching with hip opening focus.",
            phase = 1, weekNumber = 3, durationMinutes = 25, focusArea = "Flexibility & Mobility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Frog Stretch", description = "On hands and knees, widen knees, toes out. Sink hips back. Hold 30-60 sec.", sets = 2, reps = "45 seconds", restSeconds = 15, modifications = "Pillows under knees. Only go as wide as comfortable.", isLowImpact = true, targetMuscleGroup = "Adductors, Groin, Hips", injuryConsiderations = "Essential for Muay Thai kicks. No MCL stress."),
                Exercise(id = exId++, name = "Cat-Cow Spine Mobilization", description = "Alternate between arching back up and dropping belly down. Breathe rhythmically.", sets = 2, reps = "10 cycles", restSeconds = 15, modifications = "Towel under wrists if uncomfortable.", isLowImpact = true, targetMuscleGroup = "Spine, Core", injuryConsiderations = "Safe for all injuries."),
                Exercise(id = exId++, name = "Supine Spinal Twist", description = "Lie on back, drop knee across body. Hold 30 sec each side.", sets = 2, reps = "30 sec each side", restSeconds = 10, modifications = "Pillow between knees.", isLowImpact = true, targetMuscleGroup = "Spine, Hips, IT Band", injuryConsiderations = "Don't force. Safe if done gently."),
                Exercise(id = exId++, name = "Butterfly Stretch", description = "Sit with soles of feet together. Hinge forward from hips. Hold 45 sec.", sets = 2, reps = "45 seconds", restSeconds = 15, modifications = "Sit on folded towel.", isLowImpact = true, targetMuscleGroup = "Inner Thighs, Hips", injuryConsiderations = "No MCL stress. Opens groin for kicks.")
            )))

        // ── Week 4 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 4 — Day 1: Cardio + Movement",
            description = "Add variety to cardio. Introduce movement patterns used in Muay Thai.",
            phase = 1, weekNumber = 4, durationMinutes = 25, focusArea = "Cardiovascular", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "20-Minute Brisk Walk", description = "Walk at a pace where you can speak short sentences but feel breathless.", sets = 1, reps = "20 minutes", restSeconds = 0, modifications = "Slow to comfortable pace for 2 min if knee twinges.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Supportive shoes."),
                Exercise(id = exId++, name = "Lateral Shuffles", description = "Shuffle sideways 10 steps left, 10 steps right. Stay low in athletic stance.", sets = 3, reps = "10 each direction", restSeconds = 30, modifications = "Take smaller steps. Stay higher if knee complains.", isLowImpact = true, targetMuscleGroup = "Adductors, Quads, Cardiovascular", injuryConsiderations = "No hard cutting. Controlled movement for MCL."),
                Exercise(id = exId++, name = "Standing Calf Raises — Single Leg Intro", description = "Try 5 reps on single leg, then both feet for remaining.", sets = 3, reps = "5 single + 10 both", restSeconds = 45, modifications = "Stay on both feet if single-leg is unstable.", isLowImpact = true, targetMuscleGroup = "Calves, Ankle Stabilizers", injuryConsiderations = "Hold wall firmly.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 4 — Day 2: Strength Consolidation",
            description = "Consolidate strength gains. Slightly higher volume than week 3.",
            phase = 1, weekNumber = 4, durationMinutes = 30, focusArea = "Strength", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Incline Push-Up", description = "Counter height. Focus on controlled lowering (2 sec down, 1 sec up).", sets = 3, reps = "10-12", restSeconds = 60, modifications = "Return to wall if shoulders fatigue.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "Monitor clavicle plate side."),
                Exercise(id = exId++, name = "Glute Bridge — Hold", description = "Hold at top for 5 seconds each rep.", sets = 3, reps = "10 with 5-sec hold", restSeconds = 60, modifications = "Reduce hold time if needed.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings", injuryConsiderations = "MCL-safe."),
                Exercise(id = exId++, name = "Pallof Press with Band", description = "Anchor band at chest height. Stand sideways. Press out and hold 2 sec. Resist rotation.", sets = 3, reps = "10 each side", restSeconds = 60, modifications = "Stand closer to anchor for less resistance.", isLowImpact = true, targetMuscleGroup = "Core (Anti-Rotation), Obliques", injuryConsiderations = "Arms at chest height. Rotator-cuff safe."),
                Exercise(id = exId++, name = "Seated Leg Extension", description = "Sit on chair edge. Extend one leg until nearly straight. Hold 1 sec.", sets = 3, reps = "12 each leg", restSeconds = 60, modifications = "Don't lock knee. Stop at discomfort.", isLowImpact = true, targetMuscleGroup = "Quadriceps", injuryConsiderations = "MCL-friendly. No lateral stress.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 4 — Day 3: Deep Stretch",
            description = "Deeper flexibility work. Preparing muscles and joints for more intense phases.",
            phase = 1, weekNumber = 4, durationMinutes = 25, focusArea = "Flexibility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Dynamic Leg Swings (Front-to-Back)", description = "Hold wall. Swing leg forward and backward. Gradually increase range.", sets = 2, reps = "15 each leg", restSeconds = 15, modifications = "Controlled swings, no jerking.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Hamstrings", injuryConsiderations = "Standing knee slightly bent."),
                Exercise(id = exId++, name = "Hip Flexor Lunge Stretch", description = "Deeper push this week. Hold 40 seconds each side.", sets = 2, reps = "40 sec each side", restSeconds = 15, modifications = "Keep torso upright.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Psoas", injuryConsiderations = "Pad kneeling knee well."),
                Exercise(id = exId++, name = "Pigeon Pose (Modified)", description = "Slide knee forward, extend other leg back. Lower chest toward floor.", sets = 2, reps = "45 sec each side", restSeconds = 15, modifications = "Towel under front hip.", isLowImpact = true, targetMuscleGroup = "Hip Rotators, Glutes, Psoas", injuryConsiderations = "Amazing for kick flexibility."),
                Exercise(id = exId++, name = "Thoracic Spine Rotation", description = "Side-lying. Top arm rotates open. Hold 20 sec.", sets = 2, reps = "5 reps each side, 20 sec holds", restSeconds = 15, modifications = "Pillow between knees.", isLowImpact = true, targetMuscleGroup = "Thoracic Spine, Chest", injuryConsiderations = "Excellent for rotator cuff mobility.")
            )))

        // ── Week 5 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 5 — Day 1: Cardio Intervals Intro",
            description = "Introduce light interval variation to build cardiovascular capacity.",
            phase = 1, weekNumber = 5, durationMinutes = 30, focusArea = "Cardiovascular", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Walk with Speed Intervals", description = "Walk 3 min at normal pace, 1 min at brisk pace. Repeat 5 times.", sets = 5, reps = "4 min per interval", restSeconds = 0, modifications = "If MCL hurts at brisk pace, do moderate vs slow.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "No jogging yet. Walking only."),
                Exercise(id = exId++, name = "Standing Knee Raises — Faster", description = "Raise knees with more energy, as if marching in place.", sets = 3, reps = "15 each leg", restSeconds = 30, modifications = "Slow down if winded. Quality over speed.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Core, Cardiovascular", injuryConsiderations = "Preparing for Muay Thai knee strikes."),
                Exercise(id = exId++, name = "Stationary Bike — Low Resistance", description = "Pedal at comfortable resistance for 10 minutes.", sets = 1, reps = "10 minutes", restSeconds = 0, modifications = "Raise seat to reduce knee bend.", isLowImpact = true, targetMuscleGroup = "Quads, Hamstrings, Cardiovascular", injuryConsiderations = "No MCL stress when seat adjusted correctly.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 5 — Day 2: Lower Body Strength",
            description = "Focus on building leg and hip strength critical for Muay Thai.",
            phase = 1, weekNumber = 5, durationMinutes = 30, focusArea = "Lower Body Strength", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Partial Wall Sit", description = "Back against wall, slide to 45° bend. Hold 15-20 sec. NOT 90°.", sets = 3, reps = "20 seconds", restSeconds = 75, modifications = "Only go as low as comfortable.", isLowImpact = true, targetMuscleGroup = "Quadriceps, Glutes", injuryConsiderations = "Partial range protects MCL. Don't go below 45°."),
                Exercise(id = exId++, name = "Side-Lying Hip Abduction", description = "Add light ankle weight if bodyweight is easy.", sets = 3, reps = "15 each side", restSeconds = 45, modifications = "No weight if fatiguing.", isLowImpact = true, targetMuscleGroup = "Gluteus Medius, Hip Stabilizers", injuryConsiderations = "Zero knee stress."),
                Exercise(id = exId++, name = "Glute Bridge — Single Leg Intro", description = "Try 5 reps single leg, then finish set on both feet.", sets = 3, reps = "5 single + 5 both", restSeconds = 60, modifications = "Stay on both feet if unstable.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings", injuryConsiderations = "No knee valgus."),
                Exercise(id = exId++, name = "Standing Calf Raises — Single Leg", description = "Full set on single leg with wall support.", sets = 3, reps = "10 each leg", restSeconds = 45, modifications = "Return to both feet if balance is off.", isLowImpact = true, targetMuscleGroup = "Calves, Ankle Stabilizers", injuryConsiderations = "Hold wall firmly.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 5 — Day 3: Yoga-Inspired Stretch",
            description = "Flowing stretch sequences to build flexibility and body awareness.",
            phase = 1, weekNumber = 5, durationMinutes = 25, focusArea = "Flexibility & Mindfulness", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Cat-Cow Flow (Slow)", description = "10 slow cycles connecting breath to movement.", sets = 2, reps = "10 cycles", restSeconds = 0, modifications = "Move gently.", isLowImpact = true, targetMuscleGroup = "Spine, Core", injuryConsiderations = "Safe for all injuries."),
                Exercise(id = exId++, name = "World's Greatest Stretch", description = "Lunge forward, hand inside lead foot, rotate and reach up. Hold 5 sec.", sets = 2, reps = "5 each side", restSeconds = 15, modifications = "Keep back knee on ground.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Thoracic Spine, Hamstrings", injuryConsiderations = "Front knee over ankle. Arm below shoulder height."),
                Exercise(id = exId++, name = "90/90 Hip Switch", description = "Sit with legs bent 90°. Rotate knees side to side.", sets = 3, reps = "10 switches", restSeconds = 30, modifications = "Lean back on hands.", isLowImpact = true, targetMuscleGroup = "Hip Rotators, Glutes", injuryConsiderations = "Game-changer for kick mobility. No MCL stress."),
                Exercise(id = exId++, name = "Supine Full Body Stretch", description = "Lie on back, stretch long. 4 counts in, 6 counts out breathing.", sets = 3, reps = "30 seconds", restSeconds = 15, modifications = "Bend knees if lower back uncomfortable.", isLowImpact = true, targetMuscleGroup = "Full Body, Recovery", injuryConsiderations = "Safe for everything.")
            )))

        // ── Week 6 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 6 — Day 1: Cardio + Balance",
            description = "Building endurance and introducing balance challenges.",
            phase = 1, weekNumber = 6, durationMinutes = 30, focusArea = "Cardiovascular & Balance", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "25-Minute Walk", description = "Maintain brisk pace for full duration.", sets = 1, reps = "25 minutes", restSeconds = 0, modifications = "Slow for 2 min if needed, then resume.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Flat ground. Supportive shoes."),
                Exercise(id = exId++, name = "Single-Leg Balance Hold", description = "Stand on one leg, hold 30 sec. Arms out for balance.", sets = 3, reps = "30 sec each leg", restSeconds = 15, modifications = "Touch wall lightly. Close eyes to increase difficulty.", isLowImpact = true, targetMuscleGroup = "Ankle Stabilizers, Core", injuryConsiderations = "Near a wall for safety. MCL-safe."),
                Exercise(id = exId++, name = "Step-Ups (Low Step)", description = "Use a 6-inch step or stair. Step up and down alternating legs.", sets = 3, reps = "10 each leg", restSeconds = 45, modifications = "Use handrail for balance.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes, Cardiovascular", injuryConsiderations = "Low step height protects MCL.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 6 — Day 2: Upper Body + Core",
            description = "Building upper body endurance with core integration.",
            phase = 1, weekNumber = 6, durationMinutes = 30, focusArea = "Upper Body & Core", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Incline Push-Up (Lower Surface)", description = "Use a bench or sturdy chair. Getting closer to a full push-up.", sets = 3, reps = "10", restSeconds = 60, modifications = "Use higher surface if too difficult.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps, Shoulders", injuryConsiderations = "Monitor clavicle plate side."),
                Exercise(id = exId++, name = "Seated Row with Band", description = "Sit on floor, band around feet. Row back squeezing shoulder blades.", sets = 3, reps = "12-15", restSeconds = 60, modifications = "Use anchor point if floor is uncomfortable.", isLowImpact = true, targetMuscleGroup = "Mid-Back, Rhomboids, Biceps", injuryConsiderations = "Horizontal pull. Safe for rotator cuffs."),
                Exercise(id = exId++, name = "Pallof Press", description = "Increased hold time to 3 seconds this week.", sets = 3, reps = "10 each side, 3-sec hold", restSeconds = 60, modifications = "Adjust band tension.", isLowImpact = true, targetMuscleGroup = "Core, Obliques", injuryConsiderations = "Arms at chest height."),
                Exercise(id = exId++, name = "Dead Bug — Alternating", description = "Full alternating arm and leg. Controlled and slow.", sets = 3, reps = "10 each side", restSeconds = 60, modifications = "Keep lower back flat.", isLowImpact = true, targetMuscleGroup = "Deep Core", injuryConsiderations = "No joint loading.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 6 — Day 3: Dynamic Stretching",
            description = "Moving from static to dynamic stretching. Preparing for Muay Thai movements.",
            phase = 1, weekNumber = 6, durationMinutes = 20, focusArea = "Dynamic Flexibility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Dynamic Leg Swings (Front-to-Back)", description = "20 swings each leg with increasing range.", sets = 2, reps = "20 each leg", restSeconds = 15, modifications = "Hold wall firmly. Controlled movement.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Hamstrings", injuryConsiderations = "Standing knee slightly bent."),
                Exercise(id = exId++, name = "Dynamic Leg Swings (Side-to-Side)", description = "Face wall. Swing leg across body and out.", sets = 2, reps = "20 each leg", restSeconds = 15, modifications = "Core tight, hips square.", isLowImpact = true, targetMuscleGroup = "Adductors, Abductors", injuryConsiderations = "Essential for roundhouse kicks. No lateral knee stress."),
                Exercise(id = exId++, name = "Arm Circles", description = "Small circles progressing to large. Forward and backward.", sets = 2, reps = "20 each direction", restSeconds = 0, modifications = "Keep below shoulder height if cuff is sensitive.", isLowImpact = true, targetMuscleGroup = "Shoulders, Rotator Cuff", injuryConsiderations = "Gentle on clavicle. Warm up rotator cuffs."),
                Exercise(id = exId++, name = "Trunk Rotations", description = "Feet planted, rotate torso side to side. Arms swing naturally.", sets = 2, reps = "20 total", restSeconds = 0, modifications = "Gentle rotation. No forcing.", isLowImpact = true, targetMuscleGroup = "Obliques, Thoracic Spine", injuryConsiderations = "Prepares for Muay Thai hooks and elbows.")
            )))

        // ── Week 7 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 7 — Day 1: Cardio Endurance",
            description = "Pushing cardiovascular duration further. Building solid aerobic base.",
            phase = 1, weekNumber = 7, durationMinutes = 35, focusArea = "Cardiovascular Endurance", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "30-Minute Walk", description = "Brisk, steady-state walk. Full 30 minutes without stopping.", sets = 1, reps = "30 minutes", restSeconds = 0, modifications = "Brief 1-min slow if needed.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Flat ground. Monitor knee."),
                Exercise(id = exId++, name = "Stationary Bike — 15 Min", description = "Comfortable resistance for 15 minutes. Keep seat high for MCL.", sets = 1, reps = "15 minutes", restSeconds = 0, modifications = "Raise seat to reduce knee bend angle.", isLowImpact = true, targetMuscleGroup = "Quads, Hamstrings, Cardiovascular", injuryConsiderations = "No standing on pedals.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 7 — Day 2: Full Body Strength",
            description = "Integrating upper and lower body in compound movements.",
            phase = 1, weekNumber = 7, durationMinutes = 35, focusArea = "Full Body Strength", difficultyLevel = "Easy to Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Incline Push-Up", description = "Bench height or lower. 3-second lowering phase.", sets = 3, reps = "10-12", restSeconds = 60, modifications = "Higher surface if needed.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "No overhead press."),
                Exercise(id = exId++, name = "Resistance Band Deadlift", description = "Stand on band, hinge at hips, drive hips forward. Back straight.", sets = 3, reps = "12", restSeconds = 60, modifications = "Light band. Focus on hip hinge.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings, Lower Back", injuryConsiderations = "No extreme forward lean. MCL-safe."),
                Exercise(id = exId++, name = "Partial Wall Sit", description = "Increase hold to 25-30 seconds.", sets = 3, reps = "30 seconds", restSeconds = 75, modifications = "Don't go below 45°.", isLowImpact = true, targetMuscleGroup = "Quadriceps, Glutes", injuryConsiderations = "Partial range protects MCL."),
                Exercise(id = exId++, name = "Seated Row with Band", description = "Medium resistance. Focus on squeeze at the back.", sets = 3, reps = "15", restSeconds = 60, modifications = "Lighter band if shoulders tire.", isLowImpact = true, targetMuscleGroup = "Mid-Back, Biceps", injuryConsiderations = "Safe for rotator cuffs.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 7 — Day 3: Muay Thai Prep Stretch",
            description = "Stretching specifically targeting the muscles and ranges needed for Muay Thai.",
            phase = 1, weekNumber = 7, durationMinutes = 25, focusArea = "Muay Thai Mobility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Hip Flexor Stretch — Deep", description = "Hold 45 seconds. Reach same-side arm overhead for deeper stretch.", sets = 2, reps = "45 sec each side", restSeconds = 15, modifications = "Keep arm low if shoulder is sensitive.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Psoas", injuryConsiderations = "Critical for roundhouse kick height."),
                Exercise(id = exId++, name = "Frog Stretch — Progressive", description = "Wider than week 3. Hold 60 seconds.", sets = 2, reps = "60 seconds", restSeconds = 15, modifications = "Go only as wide as comfortable.", isLowImpact = true, targetMuscleGroup = "Adductors, Groin", injuryConsiderations = "No MCL stress. Progress gradually."),
                Exercise(id = exId++, name = "Pigeon Pose — Deeper", description = "Walk hands forward to increase stretch. Hold 60 sec.", sets = 2, reps = "60 sec each side", restSeconds = 15, modifications = "Towel under hip.", isLowImpact = true, targetMuscleGroup = "Hip Rotators, Glutes", injuryConsiderations = "Excellent for kick flexibility."),
                Exercise(id = exId++, name = "Standing Calf & Achilles Stretch", description = "Wall stretch. Hold 30 sec straight leg, 30 sec bent knee each side.", sets = 2, reps = "30 sec × 2 each leg", restSeconds = 0, modifications = "Bend rear knee to shift stretch to Achilles.", isLowImpact = true, targetMuscleGroup = "Calves, Achilles", injuryConsiderations = "Important for Muay Thai stance.")
            )))

        // ── Week 8 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 8 — Day 1: Foundation Test Cardio",
            description = "Test your cardiovascular progress. How far you've come in 8 weeks!",
            phase = 1, weekNumber = 8, durationMinutes = 35, focusArea = "Cardiovascular Assessment", difficultyLevel = "Easy to Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "30-Minute Brisk Walk", description = "Maintain brisk pace for entire 30 minutes. Note how much easier this is than week 1.", sets = 1, reps = "30 minutes", restSeconds = 0, modifications = "This is your benchmark. Note your pace.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Monitor knee. Celebrate progress!"),
                Exercise(id = exId++, name = "Step-Ups — 3 Minutes Continuous", description = "As many step-ups as comfortable in 3 minutes. Count your reps.", sets = 1, reps = "3 minutes", restSeconds = 0, modifications = "Use low step. Quality over quantity.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes, Cardiovascular", injuryConsiderations = "Low step for MCL safety.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 8 — Day 2: Foundation Test Strength",
            description = "Test your strength progress. Benchmark for Phase 2.",
            phase = 1, weekNumber = 8, durationMinutes = 35, focusArea = "Strength Assessment", difficultyLevel = "Easy to Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Incline Push-Up — Max Reps", description = "Bench height. Do as many as you can with good form. Record the number.", sets = 3, reps = "Max reps (good form)", restSeconds = 90, modifications = "Stop at form breakdown.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "Don't push through shoulder pain."),
                Exercise(id = exId++, name = "Wall Sit — Max Hold", description = "Hold at 45° as long as possible. Record the time.", sets = 2, reps = "Max hold", restSeconds = 120, modifications = "Stop at any knee discomfort.", isLowImpact = true, targetMuscleGroup = "Quadriceps, Glutes", injuryConsiderations = "Partial range protects MCL."),
                Exercise(id = exId++, name = "Glute Bridge — Single Leg", description = "Full set on each leg. Record reps.", sets = 3, reps = "Max reps each leg", restSeconds = 60, modifications = "Both feet if single leg isn't possible yet.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings", injuryConsiderations = "No knee valgus."),
                Exercise(id = exId++, name = "Plank Hold (Modified)", description = "On knees if needed. Hold as long as possible. Record time.", sets = 2, reps = "Max hold", restSeconds = 90, modifications = "Knees down is fine. Record for Phase 2 comparison.", isLowImpact = true, targetMuscleGroup = "Full Core", injuryConsiderations = "Wrists below shoulders. Stop at back pain.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 8 — Day 3: Recovery & Celebration",
            description = "Full recovery session. You completed Phase 1! Your body is ready for Phase 2.",
            phase = 1, weekNumber = 8, durationMinutes = 25, focusArea = "Recovery & Flexibility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Full Body Stretch Flow", description = "Flow through all stretches learned: quads, hamstrings, hip flexors, shoulders.", sets = 1, reps = "2 min per stretch", restSeconds = 0, modifications = "Hold each stretch comfortably.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Gentle celebration stretch."),
                Exercise(id = exId++, name = "Foam Roll — Upper Back", description = "Roller perpendicular to spine. Gently roll mid-back to upper-back.", sets = 1, reps = "90 seconds", restSeconds = 0, modifications = "Slow down on tender spots.", isLowImpact = true, targetMuscleGroup = "Thoracic Spine, Upper Back", injuryConsiderations = "Avoid rolling over clavicle plate."),
                Exercise(id = exId++, name = "Breathing Meditation", description = "Box breathing: 4 counts in, 4 hold, 4 out, 4 hold. Eyes closed.", sets = 1, reps = "5 minutes", restSeconds = 0, modifications = "Reduce counts to 3 if 4 is hard.", isLowImpact = true, targetMuscleGroup = "Parasympathetic Recovery", injuryConsiderations = "Safe for everything. Excellent for stress.")
            )))

        // ══════════════════════════════════════════════════════════════════════
        // PHASE 2: BUILDING (Weeks 9–16) — 3 days/week
        // More resistance, Muay Thai fundamentals, increased intensity
        // ══════════════════════════════════════════════════════════════════════

        // ── Week 9 ────────────────────────────────────────────────────────────
        plans.add(WorkoutPlan(id = id++, name = "Week 9 — Day 1: Cardio + Muay Thai Footwork",
            description = "Introduction to Muay Thai stance and footwork alongside cardio work.",
            phase = 2, weekNumber = 9, durationMinutes = 35, focusArea = "Cardio & Muay Thai Basics", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Brisk Walk — 20 Minutes", description = "Warm up with a solid brisk walk.", sets = 1, reps = "20 minutes", restSeconds = 0, modifications = "Slow if knee twinges.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "Wear supportive shoes."),
                Exercise(id = exId++, name = "Muay Thai Stance Drill", description = "Lead foot forward, rear foot angled 45°, hands at chin. Shift weight forward/back, step L/R.", sets = 3, reps = "2 minutes", restSeconds = 30, modifications = "Practice in front of mirror.", isLowImpact = true, targetMuscleGroup = "Calves, Core, Hip Stabilizers", injuryConsiderations = "No pivoting on MCL knee. Small controlled steps."),
                Exercise(id = exId++, name = "Stationary Bike — 15 Min", description = "Moderate resistance. Build leg endurance.", sets = 1, reps = "15 minutes", restSeconds = 0, modifications = "Seat high for MCL.", isLowImpact = true, targetMuscleGroup = "Quads, Hamstrings, Cardiovascular", injuryConsiderations = "Seated only. No standing.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 9 — Day 2: Strength + Muay Thai Strikes",
            description = "Combine strength work with basic Muay Thai hand strikes.",
            phase = 2, weekNumber = 9, durationMinutes = 40, focusArea = "Strength & Muay Thai", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Jab-Cross Shadowboxing", description = "From stance, extend lead hand (jab), snap back, rotate hips for rear hand (cross). Focus on hip rotation.", sets = 4, reps = "2 minutes", restSeconds = 45, modifications = "Go at 50% speed. Don't overextend shoulder on cross.", isLowImpact = true, targetMuscleGroup = "Shoulders, Core, Chest", injuryConsiderations = "No hyperextending elbows. Monitor rotator cuff."),
                Exercise(id = exId++, name = "Incline Push-Up", description = "Bench height. Solid controlled reps.", sets = 3, reps = "12", restSeconds = 60, modifications = "Higher surface if fatigued.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "Monitor clavicle side."),
                Exercise(id = exId++, name = "Resistance Band Deadlift", description = "Stand on band, hip hinge, drive forward. Medium resistance.", sets = 3, reps = "12", restSeconds = 60, modifications = "Light band if lower back feels it.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings, Lower Back", injuryConsiderations = "No extreme lean. MCL-safe."),
                Exercise(id = exId++, name = "Pallof Press — Extended Hold", description = "Press out and hold 4 seconds. Build rotational core strength for strikes.", sets = 3, reps = "10 each side", restSeconds = 60, modifications = "Reduce hold time if needed.", isLowImpact = true, targetMuscleGroup = "Core, Obliques", injuryConsiderations = "Arms at chest height.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 9 — Day 3: Muay Thai Mobility",
            description = "Stretching focused on ranges of motion needed for Muay Thai technique.",
            phase = 2, weekNumber = 9, durationMinutes = 25, focusArea = "Muay Thai Mobility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Dynamic Leg Swings (All Directions)", description = "20 front-to-back + 20 side-to-side each leg.", sets = 2, reps = "20 each direction per leg", restSeconds = 15, modifications = "Controlled swings.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Hamstrings, Adductors", injuryConsiderations = "Standing knee slightly bent."),
                Exercise(id = exId++, name = "Pigeon Pose — Deep", description = "Hold 60-90 seconds each side.", sets = 2, reps = "75 sec each side", restSeconds = 15, modifications = "Towel under hip.", isLowImpact = true, targetMuscleGroup = "Hip Rotators, Glutes", injuryConsiderations = "Key for kick flexibility."),
                Exercise(id = exId++, name = "World's Greatest Stretch", description = "5 each side with rotation.", sets = 2, reps = "5 each side", restSeconds = 15, modifications = "Back knee on ground.", isLowImpact = true, targetMuscleGroup = "Full Body Mobility", injuryConsiderations = "Arm below shoulder height."),
                Exercise(id = exId++, name = "90/90 Hip Switch", description = "Controlled hip internal/external rotation.", sets = 3, reps = "12 switches", restSeconds = 30, modifications = "Lean back on hands.", isLowImpact = true, targetMuscleGroup = "Hip Rotators", injuryConsiderations = "No MCL stress.")
            )))

        // ── Weeks 10-16: Building Phase Continuation ──────────────────────────
        // Week 10: Introduce teeps and knee strikes
        plans.add(WorkoutPlan(id = id++, name = "Week 10 — Day 1: Cardio Intervals",
            description = "Structured intervals to build fight-ready cardiovascular capacity.",
            phase = 2, weekNumber = 10, durationMinutes = 35, focusArea = "Cardiovascular Intervals", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Walk/Fast Walk Intervals", description = "Alternate 2 min brisk, 1 min very fast walking. Repeat 8 times.", sets = 8, reps = "3 min per interval", restSeconds = 0, modifications = "Reduce fast pace if knee objects.", isLowImpact = true, targetMuscleGroup = "Full Body / Cardiovascular", injuryConsiderations = "No jogging yet if MCL is not ready."),
                Exercise(id = exId++, name = "Bike Intervals", description = "2 min easy, 1 min higher resistance. Repeat 5 times.", sets = 5, reps = "3 min per interval", restSeconds = 0, modifications = "Keep moderate. Conversation during easy phases.", isLowImpact = true, targetMuscleGroup = "Lower Body, Cardiovascular", injuryConsiderations = "Seated only.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 10 — Day 2: Teeps & Knee Strikes + Strength",
            description = "Learn the push kick (teep) and knee strike — two fundamental Muay Thai weapons.",
            phase = 2, weekNumber = 10, durationMinutes = 40, focusArea = "Muay Thai Technique & Strength", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Teep (Push Kick) Drill", description = "From stance, raise lead knee, push foot forward at hip height. Retract quickly.", sets = 3, reps = "10 each leg", restSeconds = 45, modifications = "Start low. Hold wall for balance.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Quads, Core", injuryConsiderations = "Push straight forward. No lateral knee stress."),
                Exercise(id = exId++, name = "Knee Strike Drill (Stationary)", description = "Drive rear knee upward. Pull down with both hands as knee rises.", sets = 3, reps = "10 each side", restSeconds = 45, modifications = "Hold wall with one hand for balance.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Core, Glutes", injuryConsiderations = "Standing leg stays slightly bent."),
                Exercise(id = exId++, name = "Goblet Squat (Light Weight)", description = "Hold light weight at chest. Squat to comfortable depth.", sets = 3, reps = "10", restSeconds = 60, modifications = "Bodyweight only if knees complain.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes, Core", injuryConsiderations = "Don't go below parallel. MCL-friendly range."),
                Exercise(id = exId++, name = "Dumbbell Bicep Curl", description = "Light dumbbells (5-10 lb). Curl to shoulders, elbows tucked.", sets = 3, reps = "12-15", restSeconds = 60, modifications = "Use resistance band instead.", isLowImpact = true, targetMuscleGroup = "Biceps", injuryConsiderations = "Elbows below shoulder level. Rotator-cuff safe.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 10 — Day 3: Deep Stretch & Recovery",
            description = "Recovery and deeper flexibility targeting hips and shoulders.",
            phase = 2, weekNumber = 10, durationMinutes = 25, focusArea = "Flexibility & Recovery", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Hip Flexor — Deep Lunge", description = "Hold 60 seconds. Reach arm overhead for deeper stretch.", sets = 2, reps = "60 sec each side", restSeconds = 15, modifications = "Keep arm low if shoulder sensitive.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Psoas", injuryConsiderations = "Pad kneeling knee."),
                Exercise(id = exId++, name = "Seated Straddle Stretch", description = "Legs wide, hinge forward from hips. Hold 45 sec.", sets = 2, reps = "45 seconds", restSeconds = 15, modifications = "Sit on towel. Don't round back.", isLowImpact = true, targetMuscleGroup = "Adductors, Hamstrings", injuryConsiderations = "No bouncing. Gentle progression."),
                Exercise(id = exId++, name = "Thoracic Spine Rotation", description = "Side-lying. Full rotation with 3-second hold.", sets = 2, reps = "8 reps each side", restSeconds = 15, modifications = "Pillow between knees.", isLowImpact = true, targetMuscleGroup = "Thoracic Spine, Chest, Shoulders", injuryConsiderations = "Excellent for rotator cuff."),
                Exercise(id = exId++, name = "Foam Roll — Full Body", description = "Upper back, quads, hamstrings, calves. 60 sec per area.", sets = 1, reps = "60 sec per area", restSeconds = 0, modifications = "Skip areas that feel too tender.", isLowImpact = true, targetMuscleGroup = "Full Body Recovery", injuryConsiderations = "Avoid rolling directly over clavicle plate.")
            )))

        // Week 11: Elbow strikes, more combinations
        plans.add(WorkoutPlan(id = id++, name = "Week 11 — Day 1: Cardio + Shadowboxing",
            description = "Combine cardio warm-up with Muay Thai shadowboxing rounds.",
            phase = 2, weekNumber = 11, durationMinutes = 35, focusArea = "Cardiovascular & Muay Thai", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Brisk Walk — 15 Minutes", description = "Warm-up walk at solid pace.", sets = 1, reps = "15 minutes", restSeconds = 0, modifications = "Slow if needed.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Flat ground."),
                Exercise(id = exId++, name = "2-Minute Shadowboxing Rounds", description = "Jab, cross, movement. Focus on form and breathing.", sets = 4, reps = "2 minutes", restSeconds = 60, modifications = "50% speed. Focus on technique.", isLowImpact = true, targetMuscleGroup = "Full Body, Cardiovascular", injuryConsiderations = "No hyperextending elbows."),
                Exercise(id = exId++, name = "Elbow Strike Shadowboxing", description = "Horizontal elbows rotating torso. Lead and rear side.", sets = 3, reps = "10 each side", restSeconds = 30, modifications = "Let torso rotate. Power from hips.", isLowImpact = true, targetMuscleGroup = "Core, Obliques, Shoulders", injuryConsiderations = "Keep elbows at chest/chin height. No overhead.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 11 — Day 2: Full Body Strength",
            description = "Compound strength movements with increased resistance.",
            phase = 2, weekNumber = 11, durationMinutes = 40, focusArea = "Full Body Strength", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Push-Up (Knee or Full)", description = "Try full push-ups. Drop to knees when form breaks.", sets = 3, reps = "10-12", restSeconds = 75, modifications = "Knees down is great progress!", isLowImpact = true, targetMuscleGroup = "Chest, Triceps, Core", injuryConsiderations = "Monitor clavicle plate."),
                Exercise(id = exId++, name = "Goblet Squat", description = "Slightly heavier weight or deeper range.", sets = 3, reps = "12", restSeconds = 60, modifications = "Bodyweight if needed.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes", injuryConsiderations = "MCL-friendly range."),
                Exercise(id = exId++, name = "Resistance Band Deadlift", description = "Medium-heavy band. Focus on powerful hip drive.", sets = 3, reps = "12", restSeconds = 60, modifications = "Lighter band if back feels it.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings, Back", injuryConsiderations = "Back straight throughout."),
                Exercise(id = exId++, name = "Single-Leg Glute Bridge", description = "Full sets on one leg.", sets = 3, reps = "10 each leg", restSeconds = 60, modifications = "Both feet if too difficult.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings, Core", injuryConsiderations = "No knee valgus.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 11 — Day 3: Active Recovery",
            description = "Light movement and stretching to support recovery between intense sessions.",
            phase = 2, weekNumber = 11, durationMinutes = 25, focusArea = "Recovery", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "10-Minute Easy Walk", description = "Gentle pace. Recovery walk.", sets = 1, reps = "10 minutes", restSeconds = 0, modifications = "As slow as you want.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Easy on everything."),
                Exercise(id = exId++, name = "Full Body Stretch Flow", description = "Hold each major stretch 45-60 seconds.", sets = 1, reps = "3 min per area", restSeconds = 0, modifications = "Focus on areas that feel tight.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "No forcing."),
                Exercise(id = exId++, name = "Box Breathing", description = "4 in, 4 hold, 4 out, 4 hold. 5 minutes.", sets = 1, reps = "5 minutes", restSeconds = 0, modifications = "3 count if 4 is hard.", isLowImpact = true, targetMuscleGroup = "Parasympathetic Recovery", injuryConsiderations = "Safe for everything.")
            )))

        // Week 12
        plans.add(WorkoutPlan(id = id++, name = "Week 12 — Day 1: Muay Thai Conditioning",
            description = "Muay Thai-specific cardio conditioning. No jump rope — bodyweight cardio.",
            phase = 2, weekNumber = 12, durationMinutes = 35, focusArea = "Muay Thai Cardio", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Shadowboxing Rounds", description = "Jab, cross, hooks, teeps. 2-minute rounds.", sets = 5, reps = "2 minutes", restSeconds = 60, modifications = "Focus on technique. 50-70% power.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Controlled movements."),
                Exercise(id = exId++, name = "Knee Strike Intervals", description = "Alternating knee strikes for 30 sec, rest 30 sec.", sets = 4, reps = "30 seconds", restSeconds = 30, modifications = "Slower pace if winded.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Core, Glutes", injuryConsiderations = "Standing leg soft."),
                Exercise(id = exId++, name = "Bodyweight Sprawl Drill", description = "From stance, drop hands to floor, step legs back. Stand up. No jump.", sets = 3, reps = "8", restSeconds = 60, modifications = "Step back one leg at a time.", isLowImpact = false, targetMuscleGroup = "Full Body, Cardiovascular", injuryConsiderations = "Step-back version is MCL-safe.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 12 — Day 2: Upper & Lower Strength",
            description = "Building power for strikes with compound movements.",
            phase = 2, weekNumber = 12, durationMinutes = 40, focusArea = "Strength", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Push-Up (Full or Knee)", description = "Aim for more full push-ups than last week.", sets = 3, reps = "12-15", restSeconds = 75, modifications = "Mix full and knee reps.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "Monitor clavicle."),
                Exercise(id = exId++, name = "Goblet Squat — Pause", description = "2-second pause at the bottom.", sets = 3, reps = "10 with 2-sec pause", restSeconds = 75, modifications = "Reduce depth if needed.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes", injuryConsiderations = "Don't go below comfortable depth."),
                Exercise(id = exId++, name = "Dumbbell Row", description = "One arm on bench. Row dumbbell to hip.", sets = 3, reps = "12 each arm", restSeconds = 60, modifications = "Light weight. Focus on squeeze.", isLowImpact = true, targetMuscleGroup = "Lats, Biceps, Mid-Back", injuryConsiderations = "No overhead pull. Rotator-cuff safe."),
                Exercise(id = exId++, name = "Plank Hold", description = "Full plank. Work toward 45-60 seconds.", sets = 3, reps = "Max hold (goal: 45 sec)", restSeconds = 60, modifications = "Knees down is fine.", isLowImpact = true, targetMuscleGroup = "Full Core", injuryConsiderations = "Wrists below shoulders.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 12 — Day 3: Stretch & Flow",
            description = "Recovery stretching and controlled breathing.",
            phase = 2, weekNumber = 12, durationMinutes = 25, focusArea = "Recovery & Flexibility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Cat-Cow Flow", description = "Slow 10 cycles connecting breath.", sets = 2, reps = "10 cycles", restSeconds = 0, modifications = "Move gently.", isLowImpact = true, targetMuscleGroup = "Spine, Core", injuryConsiderations = "Safe for all."),
                Exercise(id = exId++, name = "Pigeon Pose — Extended", description = "90 sec hold each side.", sets = 2, reps = "90 sec each side", restSeconds = 15, modifications = "Towel under hip.", isLowImpact = true, targetMuscleGroup = "Hip Rotators, Glutes", injuryConsiderations = "Key for kick flexibility."),
                Exercise(id = exId++, name = "Full Body Stretch", description = "Target every major muscle group. 30-45 sec each.", sets = 1, reps = "30-45 sec per group", restSeconds = 0, modifications = "Focus on tight areas.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Gentle and relaxing.")
            )))

        // Week 13
        plans.add(WorkoutPlan(id = id++, name = "Week 13 — Day 1: Muay Thai Combos + Cardio",
            description = "Flowing strike combinations with cardio conditioning.",
            phase = 2, weekNumber = 13, durationMinutes = 40, focusArea = "Muay Thai & Cardio", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Jab-Cross-Hook Combo", description = "Flow the three punches together. Reset to guard after each combo.", sets = 4, reps = "2 minutes", restSeconds = 45, modifications = "Slow until combo feels natural.", isLowImpact = true, targetMuscleGroup = "Shoulders, Core, Chest", injuryConsiderations = "Keep hooks tight. Monitor rotator cuffs."),
                Exercise(id = exId++, name = "Teep + Knee Combo", description = "Teep with lead leg, immediately drive rear knee up.", sets = 3, reps = "8 each side", restSeconds = 45, modifications = "Practice each strike separately first.", isLowImpact = true, targetMuscleGroup = "Hip Flexors, Quads, Core", injuryConsiderations = "Standing leg stays soft."),
                Exercise(id = exId++, name = "Bike Intervals — Harder", description = "1 min easy, 1 min hard. Repeat 8 times.", sets = 8, reps = "2 min per interval", restSeconds = 0, modifications = "Adjust resistance to your level.", isLowImpact = true, targetMuscleGroup = "Lower Body, Cardiovascular", injuryConsiderations = "Seated only.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 13 — Day 2: Power Building",
            description = "Explosive-ish strength for strike power.",
            phase = 2, weekNumber = 13, durationMinutes = 40, focusArea = "Strength & Power", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Push-Up — Controlled Explosive", description = "Lower slowly (3 sec), push up quickly. Build pressing power.", sets = 3, reps = "10", restSeconds = 75, modifications = "Knees if needed.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "No clapping or jumping push-ups."),
                Exercise(id = exId++, name = "Goblet Squat — Tempo", description = "3 sec down, 1 sec pause, drive up.", sets = 3, reps = "10", restSeconds = 75, modifications = "Reduce weight.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes", injuryConsiderations = "MCL-friendly range."),
                Exercise(id = exId++, name = "Band Pull-Apart + Row Superset", description = "15 pull-aparts immediately followed by 12 seated rows.", sets = 3, reps = "15 + 12", restSeconds = 75, modifications = "Lighter band if fatigued.", isLowImpact = true, targetMuscleGroup = "Upper Back, Rhomboids, Biceps", injuryConsiderations = "Horizontal pulls only. Rotator-cuff safe."),
                Exercise(id = exId++, name = "Weighted Glute Bridge", description = "Light plate across hips.", sets = 3, reps = "15", restSeconds = 60, modifications = "No weight if uncomfortable.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings", injuryConsiderations = "No knee valgus.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 13 — Day 3: Muay Thai Mobility + Recovery",
            description = "Deep stretching and mobility for Muay Thai performance.",
            phase = 2, weekNumber = 13, durationMinutes = 25, focusArea = "Mobility & Recovery", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Frog Stretch — Extended", description = "Widest comfortable position. Hold 90 sec.", sets = 2, reps = "90 seconds", restSeconds = 15, modifications = "Progress is slow — that's normal.", isLowImpact = true, targetMuscleGroup = "Adductors, Groin", injuryConsiderations = "No MCL stress."),
                Exercise(id = exId++, name = "Hip 90/90 + Rotation", description = "90/90 position with added trunk rotation.", sets = 3, reps = "10 each side", restSeconds = 30, modifications = "Lean back on hands.", isLowImpact = true, targetMuscleGroup = "Hip Rotators, Core", injuryConsiderations = "No MCL stress."),
                Exercise(id = exId++, name = "Shoulder Mobility Circles", description = "Towel-assisted shoulder circles to open chest and shoulders.", sets = 2, reps = "10 each direction", restSeconds = 15, modifications = "Wide grip on towel for comfort.", isLowImpact = true, targetMuscleGroup = "Shoulders, Chest", injuryConsiderations = "Stay within comfortable range."),
                Exercise(id = exId++, name = "Body Scan Meditation", description = "5 minutes focusing attention from toes to head. Notice without judgment.", sets = 1, reps = "5 minutes", restSeconds = 0, modifications = "Focus on areas that carried the workout.", isLowImpact = true, targetMuscleGroup = "Mind-Body Recovery", injuryConsiderations = "Builds body awareness for injury prevention.")
            )))

        // Week 14
        plans.add(WorkoutPlan(id = id++, name = "Week 14 — Day 1: Roundhouse Kick Intro",
            description = "Learn the roundhouse kick — the signature Muay Thai technique.",
            phase = 2, weekNumber = 14, durationMinutes = 40, focusArea = "Muay Thai Technique", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Warm-Up: Shadowboxing", description = "3 rounds of jab-cross-hook. Get loose.", sets = 3, reps = "2 minutes", restSeconds = 30, modifications = "Light and loose.", isLowImpact = true, targetMuscleGroup = "Full Body Warm-Up", injuryConsiderations = "Controlled strikes."),
                Exercise(id = exId++, name = "Roundhouse Kick Shadowboxing (Slow)", description = "Pivot on lead foot, rotate hips, swing rear shin in arc. SLOW for form.", sets = 3, reps = "8 each side", restSeconds = 60, modifications = "Start waist height only. Speed comes after form.", isLowImpact = false, targetMuscleGroup = "Hip Rotators, Obliques, Glutes, Calves", injuryConsiderations = "Pivot foot key — turn heel toward target. If MCL hurts, reduce height."),
                Exercise(id = exId++, name = "Clinch Knee Strikes (Solo)", description = "Imagine gripping opponent's head. Pull down driving alternating knees up.", sets = 3, reps = "20 total (10 each)", restSeconds = 45, modifications = "Focus on hip drive.", isLowImpact = false, targetMuscleGroup = "Hip Flexors, Core, Shoulders", injuryConsiderations = "Standing knee stays soft.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 14 — Day 2: Comprehensive Strength",
            description = "Full body strength supporting Muay Thai performance.",
            phase = 2, weekNumber = 14, durationMinutes = 45, focusArea = "Full Body Strength", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Push-Up — Full", description = "Aim for all full push-ups. Quality reps.", sets = 3, reps = "12-15", restSeconds = 75, modifications = "Mix with knee push-ups as needed.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps, Core", injuryConsiderations = "Monitor clavicle."),
                Exercise(id = exId++, name = "Squat — Bodyweight or Light Weight", description = "Full depth squat if MCL allows. Otherwise to comfortable depth.", sets = 4, reps = "12", restSeconds = 60, modifications = "Wall squat if balance is off.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes, Core", injuryConsiderations = "Don't force depth. Listen to MCL."),
                Exercise(id = exId++, name = "Dumbbell Row", description = "Moderate weight. Row to hip.", sets = 3, reps = "12 each arm", restSeconds = 60, modifications = "Lighter weight if form breaks.", isLowImpact = true, targetMuscleGroup = "Lats, Biceps, Mid-Back", injuryConsiderations = "Horizontal pull. Rotator-cuff safe."),
                Exercise(id = exId++, name = "Plank to Side Plank", description = "Hold plank 15 sec, rotate to side plank 15 sec. Alternate sides.", sets = 3, reps = "3 rotations", restSeconds = 60, modifications = "Knees down for side plank.", isLowImpact = true, targetMuscleGroup = "Core, Obliques, Shoulders", injuryConsiderations = "No overhead weight. Monitor clavicle side.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 14 — Day 3: Recovery Stretch",
            description = "Full recovery session with deep stretching.",
            phase = 2, weekNumber = 14, durationMinutes = 25, focusArea = "Recovery", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Full Body Stretch Flow", description = "Hit every major muscle group. 45-60 sec holds.", sets = 1, reps = "45-60 sec per group", restSeconds = 0, modifications = "Focus on areas that need it most.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Gentle, restorative."),
                Exercise(id = exId++, name = "Foam Roll — Legs Focus", description = "Quads, hamstrings, calves, IT band. 60 sec per area.", sets = 1, reps = "60 sec per area", restSeconds = 0, modifications = "Skip tender areas.", isLowImpact = true, targetMuscleGroup = "Lower Body Recovery", injuryConsiderations = "Avoid knee joints directly."),
                Exercise(id = exId++, name = "Breathing & Visualization", description = "5 min box breathing while visualizing perfect Muay Thai technique.", sets = 1, reps = "5 minutes", restSeconds = 0, modifications = "Just breathe if visualization is hard.", isLowImpact = true, targetMuscleGroup = "Mental Recovery", injuryConsiderations = "Safe for everything.")
            )))

        // Week 15
        plans.add(WorkoutPlan(id = id++, name = "Week 15 — Day 1: 3-Minute Rounds",
            description = "Full Muay Thai shadowboxing rounds at fight timing.",
            phase = 2, weekNumber = 15, durationMinutes = 40, focusArea = "Muay Thai Conditioning", difficultyLevel = "Moderate to Hard",
            exercises = listOf(
                Exercise(id = exId++, name = "3-Minute Shadowboxing Rounds", description = "Full toolkit: jab, cross, hooks, elbows, teeps, knees. Move around.", sets = 4, reps = "3 minutes", restSeconds = 60, modifications = "2-minute rounds if too demanding.", isLowImpact = false, targetMuscleGroup = "Full Body, Cardiovascular", injuryConsiderations = "Monitor MCL during pivots. Stay light on feet."),
                Exercise(id = exId++, name = "Clinch Knee Drill — Continuous", description = "30 seconds continuous knee strikes, 30 sec rest.", sets = 4, reps = "30 seconds", restSeconds = 30, modifications = "Slow down pace, not range of motion.", isLowImpact = false, targetMuscleGroup = "Hip Flexors, Core, Shoulders", injuryConsiderations = "Standing knee stays soft.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 15 — Day 2: Strength Endurance",
            description = "Higher reps, shorter rest. Building muscular endurance for rounds.",
            phase = 2, weekNumber = 15, durationMinutes = 40, focusArea = "Strength Endurance", difficultyLevel = "Moderate",
            exercises = listOf(
                Exercise(id = exId++, name = "Push-Up — 20 Rep Sets", description = "Reach 20 reps per set. Mix full and knee.", sets = 3, reps = "20", restSeconds = 60, modifications = "Split into full + knee reps.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "Quality form throughout."),
                Exercise(id = exId++, name = "Squat — Higher Volume", description = "15 reps per set.", sets = 4, reps = "15", restSeconds = 60, modifications = "Bodyweight only.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes", injuryConsiderations = "Comfortable depth only."),
                Exercise(id = exId++, name = "Band Deadlift — High Reps", description = "15 reps with medium band.", sets = 3, reps = "15", restSeconds = 60, modifications = "Lighter band.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings, Back", injuryConsiderations = "Back straight."),
                Exercise(id = exId++, name = "Plank — 60 Seconds", description = "Build to 60-second hold.", sets = 3, reps = "60 seconds", restSeconds = 60, modifications = "Knees down if needed.", isLowImpact = true, targetMuscleGroup = "Full Core", injuryConsiderations = "Wrists below shoulders.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 15 — Day 3: Deep Stretch & Breathwork",
            description = "Extended hold stretching and controlled breathing.",
            phase = 2, weekNumber = 15, durationMinutes = 30, focusArea = "Flexibility & Breathwork", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Pigeon Pose — 2 Minutes", description = "Build to 2-minute holds each side.", sets = 2, reps = "2 min each side", restSeconds = 15, modifications = "Support with towel.", isLowImpact = true, targetMuscleGroup = "Hip Rotators, Glutes", injuryConsiderations = "Essential for kicks."),
                Exercise(id = exId++, name = "Frog Stretch — 2 Minutes", description = "Extended hold. Breathe into the stretch.", sets = 2, reps = "2 minutes", restSeconds = 15, modifications = "Only go as wide as comfortable.", isLowImpact = true, targetMuscleGroup = "Adductors, Groin", injuryConsiderations = "No MCL stress."),
                Exercise(id = exId++, name = "Full Body Flow", description = "World's Greatest Stretch → Cat-Cow → Child's Pose. Repeat.", sets = 3, reps = "Flow for 3 minutes", restSeconds = 0, modifications = "Move at your own pace.", isLowImpact = true, targetMuscleGroup = "Full Body Mobility", injuryConsiderations = "Safe, restorative."),
                Exercise(id = exId++, name = "Box Breathing + Body Scan", description = "5 min box breathing, 5 min body scan.", sets = 1, reps = "10 minutes total", restSeconds = 0, modifications = "Shorter durations if restless.", isLowImpact = true, targetMuscleGroup = "Mental Recovery", injuryConsiderations = "Builds body awareness.")
            )))

        // Week 16 — Phase 2 Test Week
        plans.add(WorkoutPlan(id = id++, name = "Week 16 — Day 1: Phase 2 Muay Thai Test",
            description = "Test your Muay Thai conditioning. How many clean rounds can you do?",
            phase = 2, weekNumber = 16, durationMinutes = 40, focusArea = "Muay Thai Assessment", difficultyLevel = "Moderate to Hard",
            exercises = listOf(
                Exercise(id = exId++, name = "3-Minute Shadowboxing Rounds — Max", description = "Full toolkit. See how many clean 3-min rounds you can complete.", sets = 5, reps = "3 minutes", restSeconds = 60, modifications = "Record your number of rounds. Quality counts.", isLowImpact = false, targetMuscleGroup = "Full Body", injuryConsiderations = "Stop at form breakdown."),
                Exercise(id = exId++, name = "Roundhouse Kick — Form Check", description = "Slow, deliberate roundhouse kicks. Both sides.", sets = 3, reps = "10 each side", restSeconds = 45, modifications = "Note your height and balance improvement.", isLowImpact = false, targetMuscleGroup = "Full Body", injuryConsiderations = "Pivot carefully.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 16 — Day 2: Phase 2 Strength Test",
            description = "Benchmark your strength gains. Compare to Week 8 results.",
            phase = 2, weekNumber = 16, durationMinutes = 40, focusArea = "Strength Assessment", difficultyLevel = "Moderate to Hard",
            exercises = listOf(
                Exercise(id = exId++, name = "Push-Up — Max Reps", description = "Full push-ups, max reps with good form. Compare to Week 8.", sets = 3, reps = "Max reps", restSeconds = 90, modifications = "Record and celebrate!", isLowImpact = true, targetMuscleGroup = "Chest, Triceps", injuryConsiderations = "Stop at form breakdown."),
                Exercise(id = exId++, name = "Wall Sit — Max Hold", description = "45° angle. Hold as long as possible. Compare to Week 8.", sets = 2, reps = "Max hold", restSeconds = 120, modifications = "Record time.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes", injuryConsiderations = "MCL-friendly range."),
                Exercise(id = exId++, name = "Plank — Max Hold", description = "Full plank. Max duration. Compare to Week 8.", sets = 2, reps = "Max hold", restSeconds = 90, modifications = "Record time.", isLowImpact = true, targetMuscleGroup = "Full Core", injuryConsiderations = "Wrists below shoulders."),
                Exercise(id = exId++, name = "Single-Leg Glute Bridge — Max Reps", description = "Each leg, max reps. Compare to Week 8.", sets = 2, reps = "Max reps each leg", restSeconds = 60, modifications = "Record reps.", isLowImpact = true, targetMuscleGroup = "Glutes, Hamstrings", injuryConsiderations = "No knee valgus.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 16 — Day 3: Celebration & Recovery",
            description = "You completed Phase 2! Full recovery session before advancing.",
            phase = 2, weekNumber = 16, durationMinutes = 25, focusArea = "Recovery & Celebration", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Easy Walk — 10 Min", description = "Gentle celebratory walk. Reflect on your journey.", sets = 1, reps = "10 minutes", restSeconds = 0, modifications = "Enjoy the movement.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Easy and enjoyable."),
                Exercise(id = exId++, name = "Full Body Stretch Flow", description = "Every major muscle, 60-sec holds. Longest stretch session yet.", sets = 1, reps = "60 sec per group", restSeconds = 0, modifications = "Savor each stretch.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Gentle celebration."),
                Exercise(id = exId++, name = "Guided Breathing & Gratitude", description = "5 min breathing. Reflect on what you've accomplished. You're incredible.", sets = 1, reps = "5 minutes", restSeconds = 0, modifications = "Just be present.", isLowImpact = true, targetMuscleGroup = "Mental Wellness", injuryConsiderations = "Safe for everything.")
            )))

        // ══════════════════════════════════════════════════════════════════════
        // PHASE 3: ADVANCING (Weeks 17–24) — 3 days/week
        // Full Muay Thai combos, higher intensity, real conditioning
        // ══════════════════════════════════════════════════════════════════════

        // Week 17
        plans.add(WorkoutPlan(id = id++, name = "Week 17 — Day 1: Advanced Muay Thai Combos",
            description = "Multi-strike combinations with fluid transitions.",
            phase = 3, weekNumber = 17, durationMinutes = 45, focusArea = "Muay Thai Combinations", difficultyLevel = "Moderate to Hard",
            exercises = listOf(
                Exercise(id = exId++, name = "Jab-Cross-Hook-Rear Knee", description = "Flow: jab, cross, lead hook, rear knee. Reset to stance.", sets = 4, reps = "10 combos", restSeconds = 45, modifications = "Walk through slowly first.", isLowImpact = false, targetMuscleGroup = "Full Body", injuryConsiderations = "Tight hooks. Straight knee drive."),
                Exercise(id = exId++, name = "Cross-Hook-Roundhouse", description = "Rear cross, lead hook, rear roundhouse kick.", sets = 3, reps = "8 each side", restSeconds = 60, modifications = "Slow pivot. Waist-height kicks.", isLowImpact = false, targetMuscleGroup = "Full Body", injuryConsiderations = "Pivot carefully for MCL."),
                Exercise(id = exId++, name = "3-Minute Shadowboxing Rounds", description = "Full toolkit. Fight an imaginary opponent. Change angles.", sets = 5, reps = "3 minutes", restSeconds = 60, modifications = "Focus on technique over speed.", isLowImpact = false, targetMuscleGroup = "Full Body, Cardiovascular", injuryConsiderations = "Stay light on feet.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 17 — Day 2: Advanced Strength",
            description = "Heavier resistance and demanding compound movements.",
            phase = 3, weekNumber = 17, durationMinutes = 45, focusArea = "Strength & Power", difficultyLevel = "Hard",
            exercises = listOf(
                Exercise(id = exId++, name = "Push-Up — Close Grip", description = "Hands closer together for tricep emphasis. 10-12 reps.", sets = 3, reps = "10-12", restSeconds = 75, modifications = "Wider grip if too difficult.", isLowImpact = true, targetMuscleGroup = "Triceps, Chest, Core", injuryConsiderations = "Monitor wrists and clavicle."),
                Exercise(id = exId++, name = "Squat — Weighted", description = "Dumbbell or kettlebell at chest. Full depth.", sets = 4, reps = "12", restSeconds = 75, modifications = "Bodyweight if knee objects.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes, Core", injuryConsiderations = "Listen to MCL at depth."),
                Exercise(id = exId++, name = "Dumbbell Row — Heavier", description = "Progress to heavier dumbbell.", sets = 3, reps = "12 each arm", restSeconds = 60, modifications = "Don't sacrifice form for weight.", isLowImpact = true, targetMuscleGroup = "Lats, Biceps, Mid-Back", injuryConsiderations = "Horizontal pull. Safe for rotator cuffs."),
                Exercise(id = exId++, name = "Side Plank — Hold", description = "30-45 sec holds each side.", sets = 3, reps = "30-45 sec each side", restSeconds = 45, modifications = "Bottom knee down.", isLowImpact = true, targetMuscleGroup = "Obliques, Core, Shoulders", injuryConsiderations = "Monitor clavicle plate side.")
            )))
        plans.add(WorkoutPlan(id = id++, name = "Week 17 — Day 3: Recovery & Mobility",
            description = "Active recovery with deep mobility work.",
            phase = 3, weekNumber = 17, durationMinutes = 30, focusArea = "Recovery & Mobility", difficultyLevel = "Easy",
            exercises = listOf(
                Exercise(id = exId++, name = "Easy Walk — 10 Min", description = "Gentle recovery walk.", sets = 1, reps = "10 minutes", restSeconds = 0, modifications = "Enjoy the movement.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Easy on everything."),
                Exercise(id = exId++, name = "Full Stretch Flow", description = "All major muscle groups. 60-sec holds.", sets = 1, reps = "60 sec per group", restSeconds = 0, modifications = "Focus on tight areas.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Gentle."),
                Exercise(id = exId++, name = "Foam Roll — Full Body", description = "Thorough foam rolling session.", sets = 1, reps = "90 sec per area", restSeconds = 0, modifications = "Skip tender areas.", isLowImpact = true, targetMuscleGroup = "Full Body Recovery", injuryConsiderations = "Avoid clavicle plate area."),
                Exercise(id = exId++, name = "Meditation — 10 Minutes", description = "Box breathing + body scan + visualization.", sets = 1, reps = "10 minutes", restSeconds = 0, modifications = "Any duration is fine.", isLowImpact = true, targetMuscleGroup = "Mental Recovery", injuryConsiderations = "Safe for everything.")
            )))

        // Weeks 18-24: Continue Phase 3 pattern
        for (week in 18..24) {
            val weekLabel = week
            val dayOneDesc = when {
                week <= 20 -> "Progressive Muay Thai combinations with increased speed."
                week <= 22 -> "Advanced combinations with defensive movement."
                else -> "Fight-simulation rounds. Test your Muay Thai skills."
            }
            val dayTwoDesc = when {
                week <= 20 -> "Progressive strength building."
                week <= 22 -> "Peak strength with compound movements."
                else -> "Strength maintenance and assessment."
            }

            // Day 1: Muay Thai + Cardio
            plans.add(WorkoutPlan(id = id++, name = "Week $weekLabel — Day 1: Muay Thai + Cardio",
                description = dayOneDesc,
                phase = 3, weekNumber = week, durationMinutes = 45, focusArea = "Muay Thai & Conditioning", difficultyLevel = if (week <= 20) "Moderate to Hard" else "Hard",
                exercises = listOf(
                    Exercise(id = exId++, name = "3-Minute Shadowboxing Rounds", description = "Full Muay Thai toolkit. Increase intensity each week.", sets = if (week <= 20) 5 else 6, reps = "3 minutes", restSeconds = 60, modifications = "Quality over aggression.", isLowImpact = false, targetMuscleGroup = "Full Body, Cardiovascular", injuryConsiderations = "Monitor MCL on pivots."),
                    Exercise(id = exId++, name = "Roundhouse Kick Drill", description = "Controlled roundhouse kicks. Increase height and speed gradually.", sets = 3, reps = "10 each side", restSeconds = 45, modifications = "Prioritize form. Height will come.", isLowImpact = false, targetMuscleGroup = "Hip Rotators, Core, Glutes", injuryConsiderations = "Pivot foot — heel toward target."),
                    Exercise(id = exId++, name = "Clinch Knee + Elbow Combo", description = "Knee strike immediately followed by elbow strike. Alternate sides.", sets = 3, reps = "10 combos each side", restSeconds = 45, modifications = "Slow and controlled.", isLowImpact = false, targetMuscleGroup = "Full Body, Core", injuryConsiderations = "Standing knee stays soft. Elbows at chin height."),
                    Exercise(id = exId++, name = "Bodyweight Sprawl Drill", description = "Fight-ready conditioning. Step back, chest to floor, push up, return to stance.", sets = 3, reps = if (week <= 20) "8" else "10", restSeconds = 60, modifications = "Step back one leg at a time.", isLowImpact = false, targetMuscleGroup = "Full Body, Cardiovascular", injuryConsiderations = "Step-back version is MCL-safe.")
                )))

            // Day 2: Strength
            plans.add(WorkoutPlan(id = id++, name = "Week $weekLabel — Day 2: Strength",
                description = dayTwoDesc,
                phase = 3, weekNumber = week, durationMinutes = 45, focusArea = "Full Body Strength", difficultyLevel = if (week <= 20) "Moderate to Hard" else "Hard",
                exercises = listOf(
                    Exercise(id = exId++, name = "Push-Up Variation", description = if (week <= 20) "Standard push-ups. Build volume." else "Close-grip or diamond push-ups.", sets = 4, reps = if (week <= 20) "15" else "12", restSeconds = 60, modifications = "Knees as needed.", isLowImpact = true, targetMuscleGroup = "Chest, Triceps, Core", injuryConsiderations = "Monitor clavicle."),
                    Exercise(id = exId++, name = "Squat — Progressive", description = if (week <= 20) "Bodyweight or light weight. Higher volume." else "Weighted squat. Build power.", sets = 4, reps = if (week <= 20) "15" else "12", restSeconds = 60, modifications = "Bodyweight is always fine.", isLowImpact = true, targetMuscleGroup = "Quads, Glutes, Core", injuryConsiderations = "MCL-friendly depth."),
                    Exercise(id = exId++, name = "Row — Progressive", description = "Dumbbell or band row. Increasing resistance.", sets = 3, reps = "12 each arm", restSeconds = 60, modifications = "Lighter as needed.", isLowImpact = true, targetMuscleGroup = "Lats, Biceps, Mid-Back", injuryConsiderations = "Rotator-cuff safe."),
                    Exercise(id = exId++, name = "Core Circuit", description = "Plank 45s → Side Plank 30s each → Dead Bug 10 each. Minimal rest.", sets = 3, reps = "Full circuit", restSeconds = 60, modifications = "Knees down as needed.", isLowImpact = true, targetMuscleGroup = "Full Core", injuryConsiderations = "Monitor wrists and shoulders.")
                )))

            // Day 3: Stretch & Recovery
            plans.add(WorkoutPlan(id = id++, name = "Week $weekLabel — Day 3: Stretch & Recovery",
                description = "Full recovery session to support intense training.",
                phase = 3, weekNumber = week, durationMinutes = 30, focusArea = "Recovery & Flexibility", difficultyLevel = "Easy",
                exercises = listOf(
                    Exercise(id = exId++, name = "Dynamic Warm-Up", description = "Leg swings, arm circles, trunk rotations. 5 minutes.", sets = 1, reps = "5 minutes", restSeconds = 0, modifications = "Gentle and flowing.", isLowImpact = true, targetMuscleGroup = "Full Body", injuryConsiderations = "Safe for all."),
                    Exercise(id = exId++, name = "Deep Stretch — Hips & Legs", description = "Pigeon pose, frog stretch, hip flexor, hamstrings. 60-90 sec holds.", sets = 1, reps = "60-90 sec per stretch", restSeconds = 0, modifications = "Support with props.", isLowImpact = true, targetMuscleGroup = "Hips, Legs", injuryConsiderations = "No MCL stress."),
                    Exercise(id = exId++, name = "Upper Body Stretch", description = "Shoulders, chest, thoracic rotation. 45-60 sec holds.", sets = 1, reps = "45-60 sec per stretch", restSeconds = 0, modifications = "Gentle on clavicle side.", isLowImpact = true, targetMuscleGroup = "Shoulders, Chest, Back", injuryConsiderations = "Rotator cuff safe range."),
                    Exercise(id = exId++, name = "Breathing & Meditation", description = "Box breathing + body scan. 5-10 minutes." , sets = 1, reps = "10 minutes", restSeconds = 0, modifications = "Any duration is good.", isLowImpact = true, targetMuscleGroup = "Mental Recovery", injuryConsiderations = "Builds awareness.")
                )))
        }

        return plans
    }
}
