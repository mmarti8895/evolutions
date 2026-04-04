package com.evolutions.app.data.models

data class WorkoutPlan(
    val id: Int,
    val name: String,
    val description: String,
    val phase: Int, // 1=Foundation, 2=Building, 3=Advancing
    val weekNumber: Int,
    val exercises: List<Exercise>,
    val durationMinutes: Int,
    val focusArea: String,
    val difficultyLevel: String
)
