package com.evolutions.app.data.models

data class Exercise(
    val id: Int,
    val name: String,
    val description: String,
    val sets: Int,
    val reps: String, // Can be "10-15" or "30 seconds"
    val restSeconds: Int,
    val modifications: String, // Injury-specific modifications
    val isLowImpact: Boolean,
    val targetMuscleGroup: String,
    val injuryConsiderations: String
)
