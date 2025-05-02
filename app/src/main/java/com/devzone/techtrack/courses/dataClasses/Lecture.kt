package com.devzone.techtrack.courses.dataClasses

data class Lecture(
    val title: String,  // Title of the lecture/video
    val videoLink: String? = null  // This will be fetched from Firebase later
)

