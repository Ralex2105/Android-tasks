package com.example.lab5_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private val imageURI = "https://upload.wikimedia.org/wikipedia/ru/thumb/0/08/Picasso01.jpg/480px-Picasso01.jpg"
    private val imageDownloader = ImageDownloader()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<View>(R.id.imageView) as ImageView

        imageDownloader.downloadImage(imageURI)
        imageDownloader.getBitmapData().observe(this) {
            imageView.setImageBitmap(it)
        }
    }
}