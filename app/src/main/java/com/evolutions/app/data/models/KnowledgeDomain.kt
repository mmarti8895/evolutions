package com.evolutions.app.data.models

data class KnowledgeDomain(
    val id: Int,
    val name: String,
    val description: String,
    val icon: String,
    val topics: List<String>,
    val dailyChallengeQuestion: String,
    val resourceLinks: List<String>,
    val progressPercent: Int
)
