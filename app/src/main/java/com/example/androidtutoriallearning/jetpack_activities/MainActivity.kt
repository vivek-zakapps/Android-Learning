package com.example.androidtutoriallearning.jetpack_activities

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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme
import com.example.androidtutoriallearning.xml_activities.SmithsXMLUi

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTutorialLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally,
                    ) {


                        // Android text-field data passing to another screen
                        FilledTonalButton(
                            onClick = {
                                val intent =
                                    Intent(this@MainActivity, TextFieldActivity::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier.width(300.dp),
                        ) {
                            Text(text = "Text Field", fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        // Fragments
                        FilledTonalButton(
                            onClick = {
                                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier.width(300.dp),
                        ) {
                            Text(text = "Fragment Activity", fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))
                        BuildSmithUiButton()
                    }
                }
            }
        }
    }
}

// Vivek's components

@Composable
fun BuildSmithUiButton() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    // Dropdown items
    val items = listOf("Jetpack Compose", "XML")

    FilledTonalButton(
        onClick = { expanded = !expanded },
        modifier = Modifier.width(300.dp)
    ) {
        Text(text = "Smiths App", fontWeight = FontWeight.Bold)
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { label ->
                DropdownMenuItem(
                    modifier = Modifier.width(260.dp), // Set the width

                    text = { Text(label) },
                    onClick = {

                        expanded = false // Close the dropdown menu

                        val screen =
                            if (label == "XML")
                                SmithsXMLUi::class.java
                            else
                                SmithsAppUiActivity::class.java

                            val intent = Intent(context,screen)
                            intent.putExtra("screen", label)
                            context.startActivity(intent)


                    }
                )
            }
        }
    }
}

