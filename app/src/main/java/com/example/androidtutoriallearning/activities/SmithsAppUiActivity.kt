package com.example.androidtutoriallearning.activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.androidtutoriallearning.R
import com.example.androidtutoriallearning.ui.theme.AndroidTutorialLearningTheme

class SmithsAppUiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidTutorialLearningTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.blue) ) {
                Column(
                    modifier =  Modifier.fillMaxSize() ,
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment= Alignment.CenterHorizontally,
                ) {
                    
                    Spacer(modifier = Modifier.padding(35.dp))
                    AsyncImage(
                        modifier = Modifier.size(200.dp),
                        model = "https://logowik.com/content/uploads/images/smiths-chips3901.logowik.com.webp",
                        placeholder = painterResource(id = R.drawable.ic_launcher_background),
                        error = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "The smiths logo",
                    )

                    Spacer(modifier = Modifier.padding(15.dp))
                    Text(
                        text = "Start with one of the following methods",
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.padding(15.dp))
                    BuildStartMethods(generateItemList())

                    Spacer(modifier = Modifier.padding(30.dp))
                    RectangleOutlineButton(onClick = { /*TODO*/ }, text = "New Employees, tap here")

                    }
                }
            }
        }
    }

}
@Composable
fun generateItemList(): List<Map<String, String>> {
    return listOf(
        mapOf("title" to "Mobile NFC", "image" to stringResource(R.string.nfc_network_image)),
        mapOf("title" to "Scan QR", "image" to stringResource(R.string.qr_network_image)),
        mapOf("title" to "Tap ID card", "image" to stringResource(R.string.id_card_network_image)),
        mapOf("title" to "Key in pin", "image" to stringResource(R.string.key_pad_network_image))
    )
}
@Composable
fun BuildStartMethods(list: List<Map<String, String>>) {
    Row(
        horizontalArrangement = Arrangement.Center,
    ){
        for (method  in list) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment= Alignment.CenterHorizontally,
            ) {
                ColoredContainer( method["image"] ?: "", method["title"] ?: "")
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = method["title"] ?: "", fontWeight = FontWeight.Bold, fontSize =20.sp )
            }
            Spacer(modifier = Modifier.padding(15.dp))

        }
    }

}

@Composable
fun ColoredContainer(image:String, title:String) {
    Box(
        modifier = Modifier.size(100.dp)
    ) {
        if (title!="Mobile NFC"){
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = image,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds,
            )
        }
        else{
            // TODO: Stack IMages
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = image,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds,
            )
            }
        }
    }



@Composable
fun RectangleOutlineButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    OutlinedButton(
        border = BorderStroke(2.dp, Color.White),
        onClick = onClick,
        modifier = modifier
            .padding(8.dp)
            .width(300.dp),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            disabledContentColor = Color.White
        )


    ) {
        // Text displayed inside the button
        Text(text = text, fontSize = 20.sp)
    }
}