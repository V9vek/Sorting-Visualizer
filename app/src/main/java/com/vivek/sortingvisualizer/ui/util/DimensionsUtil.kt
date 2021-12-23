package com.vivek.sortingvisualizer.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun getScreenWidth(): Int {
    val metrics = LocalContext.current.resources.displayMetrics
    return metrics.widthPixels
}

@Composable
fun getScreenHeight(): Int {
    val metrics = LocalContext.current.resources.displayMetrics
    return metrics.heightPixels
}