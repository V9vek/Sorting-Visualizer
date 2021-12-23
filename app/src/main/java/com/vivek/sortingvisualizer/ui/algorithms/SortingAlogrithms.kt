package com.vivek.sortingvisualizer.ui.algorithms

import kotlinx.coroutines.delay
import kotlin.random.Random

fun randomize(width: Int, height: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    for (i in 0..width) {
        list.add(Random.nextInt(height))
    }
    return list
}

suspend fun bubbleSort(
    list: MutableList<Int>,
    onUpdateItems: (MutableList<Int>) -> Unit
) {
    val n = list.size

    for (i in 0 until n - 1) {
        var swapped = false
        for (j in 0 until (n - i - 1)) {
            if (list[j] > list[j + 1]) {
                // swap
                val t = list[j]
                list[j] = list[j + 1]
                list[j + 1] = t
                swapped = true
            }
        }

        delay(10)
        onUpdateItems(list)
        if (!swapped) break
    }
}

suspend fun selectionSort(
    list: MutableList<Int>,
    onUpdateItems: (MutableList<Int>) -> Unit
) {
    val n = list.size

    for (i in 0 until n - 1) {
        var indexMin = i

        for (j in i + 1 until n) {
            if (list[j] < list[indexMin]) {
                indexMin = j
            }
        }
        // swap
        val temp = list[i]
        list[i] = list[indexMin]
        list[indexMin] = temp

        delay(10)
        onUpdateItems(list)
    }
}

suspend fun insertionSort(
    list: MutableList<Int>,
    onUpdateItems: (MutableList<Int>) -> Unit
) {
    val n = list.size

    for (i in 1 until n) {
        val value = list[i]
        var hole = i

        while (hole > 0 && list[hole - 1] > value) {
            list[hole] = list[hole - 1]
            --hole
        }
        delay(10)
        list[hole] = value
        onUpdateItems(list)
    }
}

suspend fun quickSort(
    list: MutableList<Int>,
    start: Int,
    end: Int,
    onUpdateItems: (MutableList<Int>) -> Unit
) {
    if (start >= end) {
        return
    }

    val pivotIndex = partition(list, start, end, onUpdateItems)
    quickSort(list, start, pivotIndex - 1, onUpdateItems)
    quickSort(list, pivotIndex + 1, end, onUpdateItems)

    delay(10)
    onUpdateItems(list)
}

suspend fun partition(
    list: MutableList<Int>,
    start: Int,
    end: Int,
    onUpdateItems: (MutableList<Int>) -> Unit
): Int {
    var pivotIndex = start
    val pivotValue = list[end]

    for (i in start until end) {
        if (list[i] < pivotValue) {
            // swap list[i] and list[pivotIndex]
            val temp = list[i]
            list[i] = list[pivotIndex]
            list[pivotIndex] = temp

            ++pivotIndex
        }

        delay(1)
        onUpdateItems(list)
    }

    // swap list[pivotIndex] and list[end]
    val temp = list[pivotIndex]
    list[pivotIndex] = list[end]
    list[end] = temp

    onUpdateItems(list)

    return pivotIndex
}

suspend fun twoPointerQuickSort(
    list: MutableList<Int>,
    left: Int,
    right: Int,
    onUpdateItems: (MutableList<Int>) -> Unit
) {
    if (left >= right) {
        return
    }

    val pivotValue = list[left]
    val pivotIndex = twoPQSPartition(list, left, right, pivotValue, onUpdateItems)
    twoPointerQuickSort(list, left, pivotIndex - 1, onUpdateItems)
    twoPointerQuickSort(list, pivotIndex + 1, right, onUpdateItems)
}

suspend fun twoPQSPartition(
    list: MutableList<Int>,
    left: Int,
    right: Int,
    pivotValue: Int,
    onUpdateItems: (MutableList<Int>) -> Unit
): Int {
    var leftI = left
    var rightI = right

    while (leftI < rightI) {
        while (list[leftI] <= pivotValue && leftI < rightI) {
            ++leftI
        }

        while (list[rightI] > pivotValue) {
            --rightI
        }

        if (leftI < rightI) {
            // swap list[leftI] and list[rightI]
            val temp = list[leftI]
            list[leftI] = list[rightI]
            list[rightI] = temp
        }

        delay(2)
        onUpdateItems(list)
    }

    // swap list[left] and list[rightI]
    val temp = list[left]
    list[left] = list[rightI]
    list[rightI] = temp

    onUpdateItems(list)

    return rightI
}


suspend fun mergeSort(
    list: MutableList<Int>,
    temp: MutableList<Int>,
    leftStart: Int,
    rightEnd: Int,
    onUpdateItems: (MutableList<Int>) -> Unit
) {
    if (leftStart >= rightEnd) {
        return
    }

    val mid = (leftStart + rightEnd) / 2

    mergeSort(list, temp, leftStart, mid, onUpdateItems)
    mergeSort(list, temp, mid + 1, rightEnd, onUpdateItems)
    merge(list, temp, leftStart, rightEnd, onUpdateItems)
}

suspend fun merge(
    list: MutableList<Int>,
    temp: MutableList<Int>,
    leftStart: Int,
    rightEnd: Int,
    onUpdateItems: (MutableList<Int>) -> Unit
) {
    val leftEnd = (leftStart + rightEnd) / 2
    val rightStart = leftEnd + 1
    val size = rightEnd - leftStart + 1

    var left = leftStart
    var right = rightStart
    var index = leftStart

    while (left <= leftEnd && right <= rightEnd) {
        if (list[left] <= list[right]) {
            temp[index] = list[left]
            left++
        } else {
            temp[index] = list[right]
            right++
        }
        index++
    }

    while (left <= leftEnd) {
        temp[index] = list[left]
        left++
        index++
    }

    while (right <= rightEnd) {
        temp[index] = list[right]
        right++
        index++
    }

    for (i in 0 until size) {
        list[leftStart + i] = temp[leftStart + i]
    }

    delay(10)
    onUpdateItems(list)
}






















