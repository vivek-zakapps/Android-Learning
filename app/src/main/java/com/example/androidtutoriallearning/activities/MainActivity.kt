package com.example.androidtutoriallearning.activities

// imported for mutableStateOf
// -----------------------------------------
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTutorialLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                   Column (
                       modifier =Modifier.fillMaxSize() ,
                       verticalArrangement= Arrangement.Center,
                       horizontalAlignment=  CenterHorizontally,
                   ){


                       // Android text-field data passing to another screen
                       FilledTonalButton(
                           onClick = {
                               val intent = Intent(this@MainActivity, TextFieldActivity::class.java)
                               startActivity(intent)
                           },
                           modifier = Modifier.width(300.dp),
                       ) {
                           Text(text = "Text Field", fontWeight = FontWeight.Bold,)
                       }
                       
                       Spacer(modifier = Modifier.padding(20.dp))

                       // Bottom nav bar
                       FilledTonalButton(
                           onClick = {
                               val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                               startActivity(intent)
                           },
                           modifier = Modifier.width(300.dp),
                       ) {
                           Text(text = "Fragment Activity", fontWeight = FontWeight.Bold,)
                       }


                   }
                }
            }
        }


    }
}

// Vivek's components


