package com.evolutions.app.data.models

data class KnowledgeTopic(
    val id: Int,
    val title: String,
    val category: String,
    val content: String,
    val keyTakeaway: String
)
