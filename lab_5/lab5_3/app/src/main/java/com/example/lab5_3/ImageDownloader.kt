package com.example.lab5_3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import java.net.URL
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageDownloader: ViewModel() {
    private val bitmapData = MutableLiveData<Bitmap>()
    private lateinit var job : Job
    fun getBitmapData() : LiveData<Bitmap> = bitmapData

    fun downloadImage(uri:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val imageURL = URL(uri)
            val bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream())
            withContext(Dispatchers.Main) {
                bitmapData.value = bitmap
            }
        }
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}