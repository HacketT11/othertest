package com.example.anothertestapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.anothertestapp.App
import com.example.anothertestapp.data.BootData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BootBroadcastReceiver : BroadcastReceiver() {

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onReceive(context: Context?, intent: Intent?) {
        scope.launch {
            App.bootDao?.insert(BootData(timestamp = System.currentTimeMillis()))
        }
    }
}