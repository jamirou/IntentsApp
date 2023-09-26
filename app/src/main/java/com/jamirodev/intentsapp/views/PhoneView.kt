package com.jamirodev.intentsapp.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jamirodev.intentsapp.R
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
        var number by remember { mutableStateOf("") }
        val context = LocalContext.current

        Text(text = number, fontSize = 50.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(items) { item ->
                CircleNumber(number = item) {
                    number += item
                }
            }
        }

        Row() {
            if (number != "") {
                Button(onClick = {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${number}"))
                    context.startActivity(intent)
                }) {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Call",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = {
                    number = number.dropLast(1)
                }) {
                    Icon(
                        painter =
                        painterResource(id = R.drawable.ic_backspace),
                        contentDescription = "Delete number",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }

    }
}










