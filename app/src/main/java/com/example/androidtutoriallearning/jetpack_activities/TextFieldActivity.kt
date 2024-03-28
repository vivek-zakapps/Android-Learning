package com.example.androidtutoriallearning.jetpack_activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTutorialLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    Column (
                        modifier = Modifier.fillMaxSize() ,
                        verticalArrangement= Arrangement.Center,
                        horizontalAlignment=  Alignment.CenterHorizontally,
                    ){
                        Text(
                            text = "Activity 1 / Main Activity",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            modifier =  Modifier.align(alignment = Alignment.CenterHorizontally )

                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        var text by remember {
                            mutableStateOf(value="")
                        }
                        OutlinedTextField(
                            value = text,
                            onValueChange = {text= it},
                            modifier =  Modifier.align(alignment = Alignment.CenterHorizontally ),
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        FilledTonalButton(

                            onClick = {
                                val intent = Intent(this@TextFieldActivity, EmptyScreenActivity::class.java)
                                intent.putExtra("data",text)
                                startActivity(intent)
                            },

                            modifier = Modifier.width(300.dp),
                        ) {
                            Text(text = "Send", fontWeight = FontWeight.Bold,)
                        }
                    }
                }
            }
        }

    }
}