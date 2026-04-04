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

    private val _filteredPlans = MutableLiveData<List<WorkoutPlan>>()
    val filteredPlans: LiveData<List<WorkoutPlan>> = _filteredPlans

    init {
        loadWorkoutPlans()
    }

    fun selectPhase(phase: Int) {
        _selectedPhase.value = phase
        _filteredPlans.value = _workoutPlans.value?.filter { it.phase == phase }
    }

    private fun loadWorkoutPlans() {
        val plans = buildWorkoutPlans()
        _workoutPlans.value = plans
        _filteredPlans.value = plans.filter { it.phase == 1 }
    }

    private fun buildWorkoutPlans(): List<WorkoutPlan> = listOf(

        // ── PHASE 1: FOUNDATION (Weeks 1–4) ──────────────────────────────────

        WorkoutPlan(
            id = 1,
            name = "Week 1: Gentle Awakening — Cardio",
            description = "Reintroduce your body to movement. This is about waking up muscles that have been resting, not pushing limits.",
            phase = 1,
            weekNumber = 1,
            exercises = listOf(
                Exercise(
                    id = 1,
                    name = "10-Minute Gentle Walk",
                    description = "Walk at a comfortable, conversational pace on flat ground. Focus on breathing deeply and maintaining good posture.",
                    sets = 1,
                    reps = "10 minutes",
                    restSeconds = 0,
                    modifications = "If knee aches, shorten to 5 minutes. Use supportive footwear.",
                    isLowImpact = true,
                    targetMuscleGroup = "Full Body / Cardiovascular",
                    injuryConsiderations = "Flat ground only. Safe for MCL, rotator cuffs, and clavicle plate."
                ),
                Exercise(
                    id = 2,
                    name = "Seated Marching",
                    description = "Sit in a sturdy chair and alternate lifting each knee. Engages core and hip flexors gently.",
                    sets = 2,
                    reps = "20 total (10 each leg)",
                    restSeconds = 30,
                    modifications = "Hold the sides of the chair for balance if needed.",
                    isLowImpact = true,
                    targetMuscleGroup = "Hip Flexors, Core",
                    injuryConsiderations = "No stress on MCL or upper body injuries."
                ),
                Exercise(
                    id = 3,
                    name = "Standing Calf Raises",
                    description = "Hold a chair or wall for balance. Rise up on your toes slowly, then lower. Builds lower leg strength safely.",
                    sets = 2,
                    reps = "12-15",
                    restSeconds = 45,
                    modifications = "Hold a wall or chair for balance. Do not lock out the knee.",
                    isLowImpact = true,
                    targetMuscleGroup = "Calves",
                    injuryConsiderations = "No MCL stress. Gentle on all joints."
                )
            ),
            durationMinutes = 20,
            focusArea = "Cardiovascular / Lower Body",
            difficultyLevel = "Very Easy"
        ),

        WorkoutPlan(
            id = 2,
            name = "Week 1: Gentle Awakening — Strength",
            description = "Begin activating major muscle groups with very gentle, body-weight and band exercises.",
            phase = 1,
            weekNumber = 1,
            exercises = listOf(
                Exercise(
                    id = 4,
                    name = "Wall Push-Up",
                    description = "Stand an arm's length from a wall. Place hands shoulder-width at shoulder height. Slowly lower your nose toward the wall, then push back.",
                    sets = 2,
                    reps = "8-10",
                    restSeconds = 60,
                    modifications = "Move feet further from wall to increase difficulty, closer to decrease. Never lock elbows at the top.",
                    isLowImpact = true,
                    targetMuscleGroup = "Chest, Anterior Shoulder (rotator-cuff safe)",
                    injuryConsiderations = "No overhead press. Safe for rotator cuffs. Avoid placing hands too high."
                ),
                Exercise(
                    id = 5,
                    name = "Glute Bridge",
                    description = "Lie on your back with knees bent, feet flat on floor. Press through your heels and lift your hips until your body forms a straight line from knees to shoulders.",
                    sets = 2,
                    reps = "10-12",
                    restSeconds = 60,
                    modifications = "Place a pillow under lower back if uncomfortable on the floor. Keep knee bend at 90° or wider.",
                    isLowImpact = true,
                    targetMuscleGroup = "Glutes, Hamstrings, Core",
                    injuryConsiderations = "Avoids direct MCL stress. No shoulder involvement. Excellent Crohn's-safe exercise."
                ),
                Exercise(
                    id = 6,
                    name = "Bird Dog",
                    description = "Start on hands and knees. Extend your right arm forward and left leg back simultaneously, hold 2 seconds, return. Repeat on the other side.",
                    sets = 2,
                    reps = "8 each side",
                    restSeconds = 45,
                    modifications = "Start with leg-only extension until balance improves. Do not arch the lower back.",
                    isLowImpact = true,
                    targetMuscleGroup = "Core, Glutes, Lower Back",
                    injuryConsiderations = "No spinal compression. No knee flex. Safe for all listed injuries."
                ),
                Exercise(
                    id = 7,
                    name = "Resistance Band Pull-Apart",
                    description = "Hold a light resistance band at chest height, arms slightly bent. Pull the band apart until arms are wide, squeezing shoulder blades. Slowly return.",
                    sets = 2,
                    reps = "12-15",
                    restSeconds = 60,
                    modifications = "Use the lightest resistance band. Focus on squeezing shoulder blades, not arm strength.",
                    isLowImpact = true,
                    targetMuscleGroup = "Posterior Shoulder, Rotator Cuff Stabilizers, Upper Back",
                    injuryConsiderations = "Specifically rehabilitates rotator cuffs. No overhead movement. Gentle on clavicle plate."
                )
            ),
            durationMinutes = 30,
            focusArea = "Upper & Lower Body Strength",
            difficultyLevel = "Very Easy"
        ),

        WorkoutPlan(
            id = 3,
            name = "Week 1: Gentle Awakening — Core & Recovery",
            description = "Core stability and gentle stretching to begin building the foundation and aid recovery.",
            phase = 1,
            weekNumber = 1,
            exercises = listOf(
                Exercise(
                    id = 8,
                    name = "Dead Bug",
                    description = "Lie on your back. Raise arms straight up, bend knees 90°. Slowly lower opposite arm and leg toward floor while breathing out, then return. Never let your back arch.",
                    sets = 2,
                    reps = "6 each side",
                    restSeconds = 60,
                    modifications = "Only extend the leg (no arm) if coordination is challenging at first.",
                    isLowImpact = true,
                    targetMuscleGroup = "Deep Core (Transverse Abdominis)",
                    injuryConsiderations = "No joint loading. No spinal compression. Safe for all injuries listed."
                ),
                Exercise(
                    id = 9,
                    name = "Gentle Supine Spinal Twist",
                    description = "Lie on your back, bring one knee to your chest, then gently drop it across your body while keeping shoulders flat. Hold 30 seconds each side.",
                    sets = 1,
                    reps = "30 seconds each side",
                    restSeconds = 15,
                    modifications = "Place a pillow between knees if hip feels tight.",
                    isLowImpact = true,
                    targetMuscleGroup = "Spine, Hips, IT Band",
                    injuryConsiderations = "Do not force the stretch. Safe for arthritis if done gently."
                ),
                Exercise(
                    id = 10,
                    name = "Child's Pose",
                    description = "Kneel and sit back toward heels, arms extended forward on the floor. Breathe deeply and hold.",
                    sets = 1,
                    reps = "60 seconds",
                    restSeconds = 0,
                    modifications = "Place a folded blanket under knees if uncomfortable. Widen knees if belly is in the way.",
                    isLowImpact = true,
                    targetMuscleGroup = "Lower Back, Hips, Shoulders (gentle)",
                    injuryConsiderations = "Avoid if knees are acutely painful. Very gentle on all injuries."
                ),
                Exercise(
                    id = 11,
                    name = "Foam Roll — Upper Back",
                    description = "Place foam roller perpendicular to your spine at mid-back. Support your head with hands. Gently roll from mid-back upward. Do NOT roll the lower back.",
                    sets = 1,
                    reps = "60-90 seconds",
                    restSeconds = 0,
                    modifications = "Slow down on tender spots. Place hands lightly behind head — do not pull on neck.",
                    isLowImpact = true,
                    targetMuscleGroup = "Thoracic Spine, Upper Back",
                    injuryConsiderations = "Avoid rolling directly over the clavicle plate. Do not roll the neck."
                )
            ),
            durationMinutes = 25,
            focusArea = "Core Stability & Flexibility",
            difficultyLevel = "Very Easy"
        ),

        // ── PHASE 2: BUILDING (Weeks 5–12) ───────────────────────────────────

        WorkoutPlan(
            id = 4,
            name = "Week 5: Building Momentum — Cardio",
            description = "Gradually increase cardiovascular duration and introduce light interval variation.",
            phase = 2,
            weekNumber = 5,
            exercises = listOf(
                Exercise(
                    id = 12,
                    name = "Brisk Walk — 25 Minutes",
                    description = "Walk at a pace where you can speak in short sentences but feel slightly breathless. Build to 25 steady minutes.",
                    sets = 1,
                    reps = "25 minutes",
                    restSeconds = 0,
                    modifications = "If right knee twinges, slow to comfortable pace for 2 minutes before resuming.",
                    isLowImpact = true,
                    targetMuscleGroup = "Full Body / Cardiovascular",
                    injuryConsiderations = "Wear supportive shoes. Avoid uneven terrain."
                ),
                Exercise(
                    id = 13,
                    name = "Stationary Bike — Low Resistance",
                    description = "Pedal at comfortable resistance for 15 minutes. Keep seat height so knee barely bends past 90°.",
                    sets = 1,
                    reps = "15 minutes",
                    restSeconds = 0,
                    modifications = "Raise seat height to reduce knee bend angle. Never stand on the pedals.",
                    isLowImpact = true,
                    targetMuscleGroup = "Quads, Hamstrings, Cardiovascular",
                    injuryConsiderations = "No stress on MCL when seat is adjusted correctly. No upper body involvement."
                ),
                Exercise(
                    id = 14,
                    name = "Standing Calf Raises — Progression",
                    description = "3 sets now, with single-leg option introduced. Rise slowly, hold at top for 1 second.",
                    sets = 3,
                    reps = "15",
                    restSeconds = 45,
                    modifications = "Stay on both feet if single-leg feels unstable. Always hold a wall for balance.",
                    isLowImpact = true,
                    targetMuscleGroup = "Calves, Ankle Stabilizers",
                    injuryConsiderations = "Safe for all listed injuries at this resistance level."
                )
            ),
            durationMinutes = 45,
            focusArea = "Cardiovascular Endurance",
            difficultyLevel = "Easy"
        ),

        WorkoutPlan(
            id = 5,
            name = "Week 5: Building Momentum — Strength",
            description = "Introduce more resistance and additional exercises as your body has adapted.",
            phase = 2,
            weekNumber = 5,
            exercises = listOf(
                Exercise(
                    id = 15,
                    name = "Seated Row with Resistance Band",
                    description = "Sit on the floor, wrap a band around your feet. Hold both ends and row back, squeezing shoulder blades together. Keep elbows tucked.",
                    sets = 3,
                    reps = "12-15",
                    restSeconds = 60,
                    modifications = "Loop band around a sturdy anchor if seated floor is uncomfortable. Focus on scapular retraction.",
                    isLowImpact = true,
                    targetMuscleGroup = "Mid-Back, Rhomboids, Biceps",
                    injuryConsiderations = "Horizontal pull — safe for rotator cuffs. No overhead motion. Gentle on clavicle."
                ),
                Exercise(
                    id = 16,
                    name = "Partial Wall Sit",
                    description = "Stand with back against wall. Slide down to a 45° bend — do NOT go to 90°. Hold for 15–20 seconds.",
                    sets = 3,
                    reps = "15-20 seconds",
                    restSeconds = 75,
                    modifications = "Only go as low as feels comfortable. Stop at any knee discomfort.",
                    isLowImpact = true,
                    targetMuscleGroup = "Quadriceps, Glutes",
                    injuryConsiderations = "Partial range protects the MCL. Do not go below 45°."
                ),
                Exercise(
                    id = 17,
                    name = "Pallof Press with Band",
                    description = "Anchor a band to a fixed point at chest height. Stand sideways to the anchor, hold band at chest with both hands, press straight out and hold 2 seconds. Resist rotation.",
                    sets = 3,
                    reps = "10 each side",
                    restSeconds = 60,
                    modifications = "Stand closer to the anchor for less resistance. Feet shoulder-width apart.",
                    isLowImpact = true,
                    targetMuscleGroup = "Core (Anti-Rotation), Obliques",
                    injuryConsiderations = "Arms stay at chest height — no overhead motion. Rotator-cuff safe."
                ),
                Exercise(
                    id = 18,
                    name = "Side-Lying Hip Abduction",
                    description = "Lie on your side, legs stacked. Keeping hips stacked and core engaged, slowly raise the top leg to ~45°, then lower.",
                    sets = 3,
                    reps = "12-15 each side",
                    restSeconds = 45,
                    modifications = "Add a light ankle weight when bodyweight becomes easy.",
                    isLowImpact = true,
                    targetMuscleGroup = "Gluteus Medius, Hip Stabilizers",
                    injuryConsiderations = "Zero knee stress. Excellent for MCL-injured individuals. No shoulder involvement."
                ),
                Exercise(
                    id = 19,
                    name = "Seated Leg Extension (Bodyweight)",
                    description = "Sit at the edge of a chair. Slowly extend one leg until nearly straight, hold 1 second, lower slowly. Keep movement controlled.",
                    sets = 3,
                    reps = "12 each leg",
                    restSeconds = 60,
                    modifications = "Do not lock out the knee. Stop if you feel any knee discomfort.",
                    isLowImpact = true,
                    targetMuscleGroup = "Quadriceps",
                    injuryConsiderations = "MCL-friendly — avoids lateral knee stress. No deep knee bend."
                )
            ),
            durationMinutes = 40,
            focusArea = "Upper & Lower Body Strength",
            difficultyLevel = "Easy to Moderate"
        ),

        // ── PHASE 3: ADVANCING (Weeks 13+) ───────────────────────────────────

        WorkoutPlan(
            id = 6,
            name = "Week 13: Advancing — Cardio Intervals",
            description = "Introduce structured interval training. Alternate between moderate and easy effort to build cardiovascular capacity.",
            phase = 3,
            weekNumber = 13,
            exercises = listOf(
                Exercise(
                    id = 20,
                    name = "Walk/Jog Intervals",
                    description = "Walk 3 minutes, jog lightly for 1 minute. Repeat 6 times. The 'jog' should be barely faster than your walk — focus on form.",
                    sets = 6,
                    reps = "4 minutes per interval (3 walk + 1 jog)",
                    restSeconds = 0,
                    modifications = "If MCL prevents jogging, do fast walking vs. regular walking intervals instead.",
                    isLowImpact = false,
                    targetMuscleGroup = "Full Body / Cardiovascular",
                    injuryConsiderations = "Monitor right knee during jog phase. Stop at any sharp pain."
                ),
                Exercise(
                    id = 21,
                    name = "Stationary Bike Intervals",
                    description = "2 minutes easy pedaling, 1 minute at higher resistance (still seated). Repeat 5 times.",
                    sets = 5,
                    reps = "3 minutes per interval",
                    restSeconds = 0,
                    modifications = "Keep resistance moderate — you should be able to maintain conversation during easy phases.",
                    isLowImpact = true,
                    targetMuscleGroup = "Lower Body, Cardiovascular",
                    injuryConsiderations = "Seated only. No standing on pedals. Seat height adjusted for MCL safety."
                )
            ),
            durationMinutes = 35,
            focusArea = "Cardiovascular Intervals",
            difficultyLevel = "Moderate"
        ),

        WorkoutPlan(
            id = 7,
            name = "Week 13: Advancing — Full Body Strength",
            description = "Compound movements and increased resistance. Building real-world strength while protecting injuries.",
            phase = 3,
            weekNumber = 13,
            exercises = listOf(
                Exercise(
                    id = 22,
                    name = "Incline Push-Up (Bench/Counter)",
                    description = "Hands on a sturdy bench or kitchen counter, body in a plank position. Lower chest to surface, push back up. More demanding than wall push-up.",
                    sets = 3,
                    reps = "10-12",
                    restSeconds = 75,
                    modifications = "Return to wall push-up on days when shoulders feel sensitive. Never push through shoulder pain.",
                    isLowImpact = true,
                    targetMuscleGroup = "Chest, Triceps, Anterior Shoulder",
                    injuryConsiderations = "Still avoids overhead press. Monitor clavicle plate side carefully."
                ),
                Exercise(
                    id = 23,
                    name = "Resistance Band Deadlift",
                    description = "Stand on band with feet hip-width. Hold both ends, hinge at hips and lower, then drive hips forward to stand. Keep back straight throughout.",
                    sets = 3,
                    reps = "12",
                    restSeconds = 90,
                    modifications = "Keep weight light. Focus on hip hinge movement pattern. Do not round the back.",
                    isLowImpact = true,
                    targetMuscleGroup = "Glutes, Hamstrings, Lower Back",
                    injuryConsiderations = "Avoid extreme forward lean. No MCL or shoulder stress. Excellent bone-loading exercise."
                ),
                Exercise(
                    id = 24,
                    name = "Dumbbell Bicep Curl (Light)",
                    description = "Hold light dumbbells (5–10 lb) at sides, curl toward shoulders. Keep elbows tucked.",
                    sets = 3,
                    reps = "12-15",
                    restSeconds = 60,
                    modifications = "Use resistance band instead of dumbbells. Avoid curling on days with clavicle ache.",
                    isLowImpact = true,
                    targetMuscleGroup = "Biceps",
                    injuryConsiderations = "Elbow below shoulder level at all times. Safe for rotator cuffs."
                ),
                Exercise(
                    id = 25,
                    name = "Glute Bridge — Weighted",
                    description = "Standard glute bridge with a light weight plate or small sandbag across the hips for added resistance.",
                    sets = 3,
                    reps = "12-15",
                    restSeconds = 60,
                    modifications = "Remove weight if lower back feels strained. Focus on squeezing glutes at the top.",
                    isLowImpact = true,
                    targetMuscleGroup = "Glutes, Hamstrings",
                    injuryConsiderations = "No knee valgus. No upper body stress. Safe for all injuries."
                )
            ),
            durationMinutes = 50,
            focusArea = "Full Body Strength",
            difficultyLevel = "Moderate"
        )
    )
}
