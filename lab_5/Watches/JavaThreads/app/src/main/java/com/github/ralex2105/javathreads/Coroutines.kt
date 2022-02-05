package com.github.ralex2105.javathreads

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class Coroutines : AppCompatActivity() {

    private val log_threads = "watches"
    private val sec = "sec"

    private var secondsElapsed: Double = 0.0
    private lateinit var textSecondsElapsed: TextView
    private var timeStart: Long = 0
    private var timeEnd: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        lifecycleScope.launchWhenResumed {
            Log.i(log_threads, "started $this")
            while (isActive) {
                Log.i(log_threads, "Coroutine is working")
                delay(1000)
                updateTime()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(log_threads, "onStart")
        timeStart = System.currentTimeMillis()
    }

    private fun updateTime() {
        timeEnd = System.currentTimeMillis()
        secondsElapsed += (timeEnd - timeStart) / 1000.0
        timeStart = timeEnd
        Log.i(log_threads, "$secondsElapsed")
        MainScope().launch {
            textSecondsElapsed.text = resources.getQuantityString(
                R.plurals.secCounter,
                secondsElapsed.toInt(),
                secondsElapsed.toInt()
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putDouble(sec, secondsElapsed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getDouble(sec)
        }
    }
}