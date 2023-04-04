package com.example.anothertestapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anothertestapp.data.BootData

@Database(
    entities = [BootData::class],
    version = 1,
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getBootDao(): BootDao
}