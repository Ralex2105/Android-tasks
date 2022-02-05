package com.github.ralex2105.javathreads

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JavaThreads : AppCompatActivity() {

    companion object {
        const val SEC = "KEY"
        const val log_threads = "WATCHES"
    }

    private var secondsElapsed: Double = 0.0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var backgroundThread: Thread
    private var timeStart: Long = 0
    private var timeEnd: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        backgroundThread = getThread()
        backgroundThread.start()
        Log.i(log_threads, "$backgroundThread is started")
        timeStart = System.currentTimeMillis()
    }

    private fun getThread(): Thread = Thread {
        while (!Thread.currentThread().isInterrupted) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                Log.i(log_threads, "stopped ${Thread.currentThread()}")
                return@Thread
            }
            Log.i(log_threads, " iterating ${Thread.currentThread()}")
            update()
        }
    }

    override fun onStop() {
        super.onStop()
        update()
        backgroundThread.interrupt()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putDouble(SEC, secondsElapsed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getDouble(SEC)
        }
    }

    private fun update() {
        timeEnd = System.currentTimeMillis()
        secondsElapsed += (timeEnd - timeStart) / 1000.0
        timeStart = timeEnd
        Log.i(log_threads, "$secondsElapsed now")
        textSecondsElapsed.post {
            textSecondsElapsed.text = resources.getQuantityString(
                R.plurals.secCounter,
                secondsElapsed.toInt(),
                secondsElapsed.toInt()
            )
        }
    }
}