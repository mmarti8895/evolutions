package com.evolutions.app.data.models

data class NutritionItem(
    val id: Int,
    val name: String,
    val category: String, // "Protein", "Carb", "Fat", "Recovery", "Anti-inflammatory"
    val description: String,
    val benefits: String,
    val crohnsFriendly: Boolean,
    val lowFiber: Boolean,
    val antiInflammatory: Boolean,
    val servingSuggestion: String,
    val caloriesPerServing: Int
)
