package com.example.androidtutoriallearning.xml_activities

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidtutoriallearning.R
import java.util.concurrent.Executors

class SmithsXMLUi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_smiths_xml_ui)


        val smithLogoView = findViewById<ImageView>(R.id.smith_image);
        val smithUrl = getString(R.string.smiths_network_image);
        loadWithGlide(this, smithLogoView,smithUrl)

//        var ll_dynamic_images = findViewById<LinearLayout>(R.id.ll_dynamic_images)
//        for (i in 0 until 2){
//            val l = LayoutInflater.from(this@SmithsXMLUi).inflate(R.layout.row_view,null,false)
//            val image = l as ImageView
//            image.id = i
//
//            val nfcUrl = getString(R.string.nfc_network_image);
//            loadWithGlide(this, image,nfcUrl)
//            ll_dynamic_images.addView(l)
//        }


        // Nfc Image
        val nfcView = findViewById<ImageView>(R.id.nfc_logo);
        val nfcUrl = getString(R.string.nfc_network_image);
        loadWithGlide(this, nfcView,nfcUrl)


        // Qr Code Image
        val qrView = findViewById<ImageView>(R.id.qr_logo);
        val qrUrl = getString(R.string.qr_network_image);
        loadWithGlide(this, qrView,qrUrl)

        //  Pin number Image
        val pinView = findViewById<ImageView>(R.id.pic_number_logo);
        val pinUrl = getString(R.string.key_pad_network_image);
        loadWithGlide(this, pinView,pinUrl)


        // Id card logo
        val idView = findViewById<ImageView>(R.id.id_card_logo);
        val idUrl = getString(R.string.id_card_network_image);
        loadWithGlide(this, idView,idUrl)






    }
}

fun loadWithGlide(context: Context, imageView: ImageView, imageUrl: String) {


    Glide.with(context)
        .load(imageUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.downloading) // Placeholder image
                .error(R.drawable.error) // Error image in case of loading failure
        )
        .into(imageView)
}