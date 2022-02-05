package com.example.lab5_4_picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<View>(R.id.image_view) as ImageView
        val url = "https://upload.wikimedia.org/wikipedia/ru/b/b9/%D0%9F%D0%BE%D1%80%D1%82%D1%80%D0%B5%D1%82_%D0%94%D0%B0%D0%BD%D0%B8%D1%8D%D0%BB%D1%8F_%D0%90%D0%BD%D1%80%D0%B8_%D0%9A%D0%B0%D0%BD%D0%B2%D0%B5%D0%B9%D0%BB%D0%B5%D1%80%D0%B0._%D0%9F%D0%B0%D0%B1%D0%BB%D0%BE_%D0%9F%D0%B8%D0%BA%D0%B0%D1%81%D1%81%D0%BE._1910.jpeg"
        Picasso.get().load(url).into(imageView)
    }
}   