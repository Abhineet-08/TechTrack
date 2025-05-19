package com.devzone.techtrack.courses.dataClasses

data class RoadmapItem(
    val topic: String,
    val subtopics: List<String>,
    var isExpanded: Boolean = false
)