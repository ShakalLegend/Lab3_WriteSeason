package com.example.lab3_writeseason

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab3_writeseason.ui.theme.Lab3_WriteSeasonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3_WriteSeasonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SeasonScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SeasonScreen(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = text,
            onValueChange = {newText -> text=newText},
            label = {Text("Введите текст")}
        )
        Text(result)
        Button(
            onClick = {result=text}
        ){
            Text("Нажми")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Lab3_WriteSeasonTheme {
        SeasonScreen()
    }
}