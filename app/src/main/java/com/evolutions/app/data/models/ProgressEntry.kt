package com.evolutions.app.data.models

data class ProgressEntry(
    val id: Int,
    val date: Long,
    val weightLbs: Float,
    val workoutsCompleted: Int,
    val strengthScore: Int,  // 1-100
    val staminaScore: Int,   // 1-100
    val wellbeingScore: Int, // 1-100
    val notes: String
)
