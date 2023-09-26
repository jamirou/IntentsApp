package com.jamirodev.intentsapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jamirodev.intentsapp.components.CircleNumber

@Composable
fun PhoneView() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Phone", fontSize = 50.sp, fontWeight = FontWeight.Bold)
        val items = listOf(
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "*", "0", "#"
        )
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(items) { item ->
                CircleNumber(number = item) {
                    
                }
            }
        }
    }
}










