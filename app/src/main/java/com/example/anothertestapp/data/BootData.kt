package com.example.anothertestapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bootdata")
data class BootData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("timestamp") val timestamp: Long
)