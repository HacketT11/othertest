package com.example.anothertestapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        CoroutineScope(Dispatchers.Main).launch {
            val text = withContext(Dispatchers.IO) {
                val mapper = BootMapper()
                mapper.map(App.bootDao?.getAll() ?: listOf())
            }
            textView.text = text
        }

        val timeToAlarm = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)
        AppAlarmManager(this).scheduleAlarm(timeToAlarm)
    }
}