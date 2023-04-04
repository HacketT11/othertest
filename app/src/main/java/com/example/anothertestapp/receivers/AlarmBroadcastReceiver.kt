package com.example.anothertestapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.anothertestapp.App
import com.example.anothertestapp.AppAlarmManager
import com.example.anothertestapp.AppNotificationManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class AlarmBroadcastReceiver : BroadcastReceiver() {

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onReceive(context: Context, intent: Intent) {
        val alarmManager = AppAlarmManager(context)
        val notificationManager = AppNotificationManager(context)

        scope.launch {
            val ts = App.bootDao?.getAll()?.last()?.timestamp ?: 0
            notificationManager.showNotification(ts.toString())
        }

        alarmManager.scheduleAlarm(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15))
    }
}