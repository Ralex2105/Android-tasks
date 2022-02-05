package com.github.ralex2105.javathreads

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class ExecutorApp: AppCompatActivity() {

    private val log_threads = "WATHCES"
    private val SEC = "sec"


    private var secondsElapsed: Double = 0.0
    private var timeStart: Long = 0
    private var timeEnd: Long = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var timeExecutor: Future<*>

    private val executorService by lazy { (application as ExecutorServiceApp).execution }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        executorService.shutdownNow()
        timeExecutor = executorService.submit(getThread())
        timeStart = System.currentTimeMillis()
    }

    override fun onStop() {
        updateTime()
        timeExecutor.cancel(true)
        super.onStop()
    }

    private fun getThread(): Thread = Thread {
        while (!Thread.currentThread().isInterrupted) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                Log.i(log_threads, "${Thread.currentThread()} is stopped")
                return@Thread
            }
            Log.i(log_threads, "${Thread.currentThread()} iterating")
            updateTime()
        }
    }

    private fun updateTime() {
        timeEnd = System.currentTimeMillis()
        secondsElapsed += (timeEnd - timeStart) / 1000.0
        timeStart = timeEnd
        Log.i(log_threads, "$secondsElapsed")
        textSecondsElapsed.post {
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
            putDouble(SEC, secondsElapsed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getDouble(SEC)
        }
    }
}

class ExecutorServiceApp: Application() {
    var execution: ExecutorService = Executors.newSingleThreadExecutor()
}