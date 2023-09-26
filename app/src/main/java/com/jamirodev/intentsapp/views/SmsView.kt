package com.jamirodev.intentsapp.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmsView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        var number by remember { mutableStateOf("") }
        var message by remember { mutableStateOf("") }
        val context = LocalContext.current
        Text(text = "SMS", fontSize = 50.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            label = { Text(text = "Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
            )

        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text(text = "Number") },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(10.dp)
        )
        
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto:$number")
            intent.putExtra("sms_body", message)
            context.startActivity(intent)
        }) {
            Text(text = "Send")
        }

    }
}