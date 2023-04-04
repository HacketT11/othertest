package com.example.anothertestapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.anothertestapp.data.BootData

@Dao
interface BootDao {

    @Insert
    fun insert(bootData: BootData)

    @Query("SELECT * FROM bootdata")
    fun getAll(): List<BootData>
}