package com.example.androidtutoriallearning.xml_activities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutoriallearning.R
import java.util.concurrent.Executors

class SmithsXMLUi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_smiths_xml_ui)

        // Find views
        val logoImageView = findViewById<ImageView>(R.id.smiths_logo_image)
        val loadingIndicator = findViewById<ProgressBar>(R.id.loading_indicator)

        // Get URL from resources
        val imageUrl = getString(R.string.smiths_logo)

        // Executor for background task
        val executor = Executors.newSingleThreadExecutor()

        // Handler to update UI
        val handler = Handler(Looper.getMainLooper())

        executor.execute {
            try {
                //  loading indicator
                handler.post { loadingIndicator.visibility = ProgressBar.VISIBLE }

                // Download image
                val inputStream = java.net.URL(imageUrl).openStream()
                val bitmap = BitmapFactory.decodeStream(inputStream)

                // Update UI
                handler.post {
                    loadingIndicator.visibility = ProgressBar.GONE
                    logoImageView.setImageBitmap(bitmap)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                handler.post { loadingIndicator.visibility = ProgressBar.GONE }
            }
        }
    }
}
