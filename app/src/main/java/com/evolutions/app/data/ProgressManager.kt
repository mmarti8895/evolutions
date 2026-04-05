package com.evolutions.app.data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object ProgressManager {

    private const val PREFS_NAME = "evolutions_progress"
    private const val KEY_COMPLETED_WORKOUTS = "completed_workouts"
    private const val KEY_COMPLETED_KNOWLEDGE = "completed_knowledge"
    private const val KEY_COMPLETED_THAI = "completed_thai"
    private const val KEY_TOTAL_WORKOUTS_LOGGED = "total_workouts_logged"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        val masterKey = MasterKey.Builder(context.applicationContext)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        prefs = EncryptedSharedPreferences.create(
            context.applicationContext,
            PREFS_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    // ── Workout Completion ────────────────────────────────────────────────

    fun isWorkoutCompleted(workoutId: Int): Boolean {
        return getCompletedWorkoutIds().contains(workoutId)
    }

    fun toggleWorkoutCompleted(workoutId: Int): Boolean {
        val completed = getCompletedWorkoutIds().toMutableSet()
        val nowCompleted: Boolean
        if (completed.contains(workoutId)) {
            completed.remove(workoutId)
            nowCompleted = false
            prefs.edit().putInt(KEY_TOTAL_WORKOUTS_LOGGED, maxOf(0, getTotalWorkoutsLogged() - 1)).apply()
        } else {
            completed.add(workoutId)
            nowCompleted = true
            prefs.edit().putInt(KEY_TOTAL_WORKOUTS_LOGGED, getTotalWorkoutsLogged() + 1).apply()
        }
        prefs.edit().putStringSet(KEY_COMPLETED_WORKOUTS, completed.map { it.toString() }.toSet()).apply()
        return nowCompleted
    }

    fun getCompletedWorkoutIds(): Set<Int> {
        return prefs.getStringSet(KEY_COMPLETED_WORKOUTS, emptySet())
            ?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    fun getTotalWorkoutsLogged(): Int {
        return prefs.getInt(KEY_TOTAL_WORKOUTS_LOGGED, 0)
    }

    // ── Knowledge Completion ──────────────────────────────────────────────

    fun isKnowledgeCompleted(topicId: Int): Boolean {
        return getCompletedKnowledgeIds().contains(topicId)
    }

    fun toggleKnowledgeCompleted(topicId: Int): Boolean {
        val completed = getCompletedKnowledgeIds().toMutableSet()
        val nowCompleted: Boolean
        if (completed.contains(topicId)) {
            completed.remove(topicId)
            nowCompleted = false
        } else {
            completed.add(topicId)
            nowCompleted = true
        }
        prefs.edit().putStringSet(KEY_COMPLETED_KNOWLEDGE, completed.map { it.toString() }.toSet()).apply()
        return nowCompleted
    }

    fun getCompletedKnowledgeIds(): Set<Int> {
        return prefs.getStringSet(KEY_COMPLETED_KNOWLEDGE, emptySet())
            ?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    // ── Thai Word Completion ──────────────────────────────────────────────

    fun isThaiWordCompleted(wordId: Int): Boolean {
        return getCompletedThaiIds().contains(wordId)
    }

    fun toggleThaiWordCompleted(wordId: Int): Boolean {
        val completed = getCompletedThaiIds().toMutableSet()
        val nowCompleted: Boolean
        if (completed.contains(wordId)) {
            completed.remove(wordId)
            nowCompleted = false
        } else {
            completed.add(wordId)
            nowCompleted = true
        }
        prefs.edit().putStringSet(KEY_COMPLETED_THAI, completed.map { it.toString() }.toSet()).apply()
        return nowCompleted
    }

    fun getCompletedThaiIds(): Set<Int> {
        return prefs.getStringSet(KEY_COMPLETED_THAI, emptySet())
            ?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    // ── Computed Scores ───────────────────────────────────────────────────

    fun getFitnessScore(): Int {
        val totalWorkouts = getTotalWorkoutsLogged()
        // Each workout contributes to fitness score, capped at 100
        return minOf(100, totalWorkouts * 2)
    }

    fun getKnowledgePercentByCategory(category: String, totalInCategory: Int): Int {
        if (totalInCategory == 0) return 0
        val completedIds = getCompletedKnowledgeIds()
        // We'll compute this from the caller who knows category-to-id mapping
        return 0 // Placeholder — actual calculation done in ViewModel
    }

    /**
     * Grade system: every 3 weeks of completed workouts advances the grade.
     * A "week" = 3 workouts completed (since 3 days/week).
     * So every 9 workouts = new grade tier.
     * 
     * Grade progression:
     * 0-8:   F-     (weeks 1-2)
     * 9-17:  F      (weeks 3-5)  
     * 18-26: F+     (weeks 6-8)
     * 27-35: D-
     * 36-44: D
     * 45-53: D+
     * 54-62: C-
     * 63-71: C
     * 72-80: C+
     * 81-89: B-
     * 90-98: B
     * 99-107: B+
     * 108-116: A-
     * 117-125: A
     * 126-134: A+
     * 135-143: S-
     * 144-152: S
     * 153+: S+
     */
    fun getEvolutionGrade(): String {
        val total = getTotalWorkoutsLogged()
        return when {
            total < 9 -> "F-"
            total < 18 -> "F"
            total < 27 -> "F+"
            total < 36 -> "D-"
            total < 45 -> "D"
            total < 54 -> "D+"
            total < 63 -> "C-"
            total < 72 -> "C"
            total < 81 -> "C+"
            total < 90 -> "B-"
            total < 99 -> "B"
            total < 108 -> "B+"
            total < 117 -> "A-"
            total < 126 -> "A"
            total < 135 -> "A+"
            total < 144 -> "S-"
            total < 153 -> "S"
            else -> "S+"
        }
    }

    fun getGradeColor(): String {
        return when (getEvolutionGrade().first()) {
            'F' -> "#B00020"
            'D' -> "#F57C00"
            'C' -> "#FFB300"
            'B' -> "#0288D1"
            'A' -> "#00796B"
            'S' -> "#6200EE"
            else -> "#757575"
        }
    }
}
