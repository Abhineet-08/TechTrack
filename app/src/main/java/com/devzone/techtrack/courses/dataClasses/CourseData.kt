package com.devzone.techtrack.courses.dataClasses

// OS Course Sections
val osSections = listOf(
    Section("Introduction", listOf(
        Lecture("What is an OS?"),
        Lecture("Types of OS")
    )),
    Section("Processes", listOf(
        Lecture("Process Scheduling"),
        Lecture("Thread Management")
    )),
    Section("Memory Management", listOf(
        Lecture("Memory Allocation"),
        Lecture("Paging")
    ))
)

// DBMS Course Sections
val dbmsSections = listOf(
    Section("Basics", listOf(
        Lecture("Introduction to DBMS"),
        Lecture("Database Models")
    )),
    Section("SQL", listOf(
        Lecture("Basic SQL Queries"),
        Lecture("Join Operations")
    )),
    Section("Transactions", listOf(
        Lecture("ACID Properties"),
        Lecture("Transaction Control")
    ))
)

// Web Course Sections
val webSections = listOf(
    Section("Frontend", listOf(
        Lecture("HTML Basics"),
        Lecture("CSS for Styling")
    )),
    Section("JavaScript", listOf(
        Lecture("Introduction to JS"),
        Lecture("DOM Manipulation")
    )),
    Section("Backend", listOf(
        Lecture("Node.js Introduction"),
        Lecture("Express.js Framework")
    ))
)

// Android Course Sections
val androidSections = listOf(
    Section("Intro to Android", listOf(
        Lecture("Android Architecture"),
        Lecture("Setting Up Android Studio")
    )),
    Section("UI Development", listOf(
        Lecture("Layouts and Views"),
        Lecture("RecyclerView and Adapters")
    )),
    Section("Advanced Android", listOf(
        Lecture("Background Tasks"),
        Lecture("Firebase in Android")
    ))
)

// DSA Course Sections
val dsaSections = listOf(
    Section("Getting Started", listOf(
        Lecture("Introduction to DSA"),
        Lecture("Complexity Analysis")
    )),
    Section("Data Structures", listOf(
        Lecture("Arrays"),
        Lecture("Linked Lists"),
        Lecture("Stacks and Queues")
    )),
    Section("Algorithms", listOf(
        Lecture("Sorting Algorithms"),
        Lecture("Searching Algorithms")
    ))
)

// Map of All Courses
val allCourses = mapOf(
    "OS" to osSections,
    "DBMS" to dbmsSections,
    "Web" to webSections,
    "Android" to androidSections,
    "DSA" to dsaSections
)
