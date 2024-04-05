package com.example.androidtutoriallearning.jetpack_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random

@Composable
fun ImageCard(
    title: String,
    decryption: String,
    modifier: Modifier,
    verticalDirection: Boolean
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = MaterialTheme.shapes.large
    ) {
        if (verticalDirection) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                ImageContent(modifier)
                TextContent(title = title, decryption = decryption)
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageContent(modifier)
                TextContent(title = title, decryption = decryption)
            }
        }
    }
}

@Composable
private fun ImageContent(modifier: Modifier) {
    Image(
        painter = rememberAsyncImagePainter(model = "https://picsum.photos/seed/${Random.nextInt()}/308/200"),
        contentDescription = null,
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .aspectRatio(3f / 2f)
            .size(200.dp)
    )
}

@Composable
private fun TextContent(title: String, decryption: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = decryption, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(10.dp))
    }
}
