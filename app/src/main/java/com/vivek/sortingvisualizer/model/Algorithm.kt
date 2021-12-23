package com.vivek.sortingvisualizer.model

enum class Algorithm(val value: String) {
    BUBBLE_SORT("Bubble Sort"),
    SELECTION_SORT("Selection Sort"),
    INSERTION_SORT("Insertion Sort"),
    QUICK_SORT("Quick Sort"),
    TWO_POINTER_QUICK_SORT("Two Pointer Quick Sort"),
    MERGE_SORT("Merge Sort")
}

fun getAllAlgorithms(): List<Algorithm> {
    return Algorithm.values().toList()
}

fun getAlgorithm(value: String): Algorithm? {
    val map = Algorithm.values().associateBy(Algorithm::value)
    return map[value]
}