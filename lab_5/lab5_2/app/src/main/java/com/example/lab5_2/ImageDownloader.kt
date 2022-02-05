package com.example.lab5_2


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL
import java.util.concurrent.ExecutorService

import java.util.concurrent.Executors.newSingleThreadExecutor

class ImageDownloader : ViewModel() {
    private val bitmap = MutableLiveData<Bitmap>()
    private lateinit var executor: ExecutorService
    fun getBitmapData() : LiveData<Bitmap> = bitmap

    fun download(url: String) {
        executor = newSingleThreadExecutor()
        executor.execute {
            val imageURL = URL(url)
            val bitmapImage = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream())
            bitmap.postValue(bitmapImage)
        }
    }

    override fun onCleared() {
        executor.shutdown()
        super.onCleared()
    }
}