package com.example.androidtutoriallearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme

class EmptyScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidTutorialLearningTheme {
                val data = intent.getStringExtra("data")
                Column(
                    modifier =  Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Activity 2 / MainActivity2",
                        color = Color.Red, fontSize =20.sp,
                        modifier =  Modifier.align(alignment = Alignment.CenterHorizontally)
                        )
                    Spacer(modifier = Modifier.padding(20.dp))
                    
                    Text(
                        text = data ?: "NO DATA",
                        color= Color.Blue,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        modifier =  Modifier.align(alignment = Alignment.CenterHorizontally ),

                        )
                }
            }
        }

    }
}