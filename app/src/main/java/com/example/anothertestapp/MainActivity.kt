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

    /**
     * TODO list:
     * - Took a large amount of time to catch BOOT event, still working not good
     * - Need to check and request permissions, push notifications won't work on API33 +
     * - I dont have any presenters/viewmodels ets (sort of architecture in this project)
     * - Some logic not moved to the right places
     * -Alarm schedules in onCreate of activity (i don't remember if in this implementation it replace the old alarm event),
     *   we need to properly handle this event, because it schedules every time when we launch app
     * - DI
     * - Incorrect handling of data for push notifications (didn't have enough time for this)
     * Ps. no gitignore :)
     */

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