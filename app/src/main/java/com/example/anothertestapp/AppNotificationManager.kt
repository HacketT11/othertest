package com.example.anothertestapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build

class AppNotificationManager(private val context: Context) {

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(description: String) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                "channelid",
                "channelname",
                NotificationManager.IMPORTANCE_HIGH
            ).also {
                it.description = "testchannel"
                notificationManager.createNotificationChannel(it)
            }
        }

        val pendingIntent: PendingIntent = Intent(context, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(
                    context,
                    0,
                    notificationIntent,
                    PendingIntent.FLAG_IMMUTABLE
                )
            }

        val notification: Notification.Builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            Notification.Builder(context, "channelid")
        else
            Notification.Builder(context)

        notification.setContentTitle("TEST APP")
            .setContentText(description)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)

        notificationManager.notify(1, notification.build())
    }
}