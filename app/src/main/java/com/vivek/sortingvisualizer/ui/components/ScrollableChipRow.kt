package com.vivek.sortingvisualizer.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vivek.sortingvisualizer.model.Algorithm
import com.vivek.sortingvisualizer.model.getAllAlgorithms
import com.vivek.sortingvisualizer.ui.theme.GreenDark

@Composable
fun CustomChip(
    algoName: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) GreenDark else GreenDark.copy(alpha = 0.5f))
    ) {
        Text(
            text = algoName,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }
}

@Composable
fun CustomChipRow(
    scrollState: ScrollState,
    selectedAlgorithm: Algorithm,
    onSelectedAlgorithmChanged: (Algorithm) -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        onSelectedAlgorithmChanged(Algorithm.BUBBLE_SORT)
    }

    Row(
        modifier = Modifier
            .padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
            .horizontalScroll(scrollState)
    ) {
        for (algorithm in getAllAlgorithms()) {
            CustomChip(
                algoName = algorithm.value,
                isSelected = selectedAlgorithm == algorithm,
                onClick = { onSelectedAlgorithmChanged(algorithm) },
            )
        }
    }
}




















