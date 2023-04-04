package com.example.anothertestapp

import android.app.Application
import androidx.room.Room
import com.example.anothertestapp.data.db.AppDatabase
import com.example.anothertestapp.data.db.BootDao

class App : Application() {

    companion object {
        var bootDao: BootDao? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        initDatabase()
    }

    private fun initDatabase() {
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database"
        ).build()
        bootDao = db.getBootDao()
    }
}