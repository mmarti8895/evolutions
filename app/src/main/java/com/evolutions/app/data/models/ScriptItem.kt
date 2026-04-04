package com.evolutions.app.data.models

data class ScriptItem(
    val id: Int,
    val type: String,
    val character: String,
    val thaiName: String,
    val meaning: String,
    val consonantClass: String,
    val ipa: String,
    val romanization: String,
    val strokeOrder: String = ""
)
