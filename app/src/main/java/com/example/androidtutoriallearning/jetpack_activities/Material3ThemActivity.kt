package com.example.androidtutoriallearning.jetpack_activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidtutoriallearning.jetpack_components.ImageCard
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme

class Material3ThemActivity : AppCompatActivity() {

    private var currentThemeMode: MutableState<ThemeMode> = mutableStateOf(ThemeMode.SYSTEM)

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        currentThemeMode.value = when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> ThemeMode.LIGHT
            Configuration.UI_MODE_NIGHT_YES -> ThemeMode.DARK
            else -> ThemeMode.SYSTEM
        }

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


                        if (currentThemeMode.value == ThemeMode.LIGHT) {
                            LazyColumn(
                                contentPadding = padding,
                                modifier = Modifier.padding(15.dp)
                            ) {

                                //currentThemeMode == ThemeMode.DARK ||

                                items(
                                    10
                                ) { index ->
                                    ImageCard(
                                        title = "Title $index",
                                        decryption = "Description for item $index",
                                        modifier = Modifier,
                                        verticalDirection = true
                                    )
                                    Spacer(modifier = Modifier.height(15.dp))
                                }

                            }
                        } else {
                            LazyRow(
                                contentPadding = padding,
                                modifier = Modifier.padding(15.dp).width(400.dp).height(400.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)

                            ) {
                                items(10) { i ->
                                    ImageCard(
                                        title = "Title $i",
                                        decryption = "Description for item $i",
                                        modifier = Modifier,
                                        verticalDirection = false
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

    enum class ThemeMode {
        LIGHT,
        DARK,
        SYSTEM
    }
}