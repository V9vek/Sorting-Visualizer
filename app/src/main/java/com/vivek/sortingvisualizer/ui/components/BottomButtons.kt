package com.vivek.sortingvisualizer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.sortingvisualizer.ui.theme.Blue
import com.vivek.sortingvisualizer.ui.theme.GreenDark
import com.vivek.sortingvisualizer.ui.theme.Red

@Composable
fun BottomButtons(
    isSortRunning: Boolean,
    onStartSorting: () -> Unit,
    onRandomize: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Sort Button
        Box(modifier = Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight()
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (!isSortRunning) GreenDark else Red)
            .clickable { onStartSorting() }
        ) {
            Text(
                text = if (!isSortRunning) "SORT" else "STOP",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }

        // Refresh Button
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 16.dp, end = 16.dp, bottom = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (!isSortRunning) Blue else Blue.copy(alpha = 0.5f))
            .clickable { onRandomize() }
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset",
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.Center)
            )
        }
    }
}