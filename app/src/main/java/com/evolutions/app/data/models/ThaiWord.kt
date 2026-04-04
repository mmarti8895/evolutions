package com.evolutions.app.data.models

data class ThaiWord(
    val id: Int,
    val english: String,
    val thai: String,
    val phonetic: String,
    val category: String,
    val audioUrl: String,
    val usageExample: String
)
