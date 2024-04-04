package com.example.androidtutoriallearning.jetpack_activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidtutoriallearning.jetpack_components.ImageCard
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme

class Material3ThemActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            AndroidTutorialLearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    Scaffold(
                        containerColor = MaterialTheme.colorScheme.background,
                        topBar = {
                            TopAppBar(
                                title = @androidx.compose.runtime.Composable {
                                    Text(
                                        text = "WEeelellcome",
                                        style = MaterialTheme.typography.titleLarge
                                    )

                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                    titleContentColor = MaterialTheme.colorScheme.onSurface
                                )

                            )
                        }
                    ) { padding ->
                        LazyColumn(
                            contentPadding = padding,
                            modifier = Modifier.padding(15.dp)
                        ) {
                            items(10) { index ->
                                ImageCard(
                                    title = "Title $index",
                                    decryption = "Description for item $index",
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                            }
                        }
                    }
                }
            }

        }
    }
}