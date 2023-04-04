package com.example.anothertestapp.data

import com.example.anothertestapp.data.db.BootDao

interface BootDataRepository {

    suspend fun insert(data: BootData)

    suspend fun getAll(): List<BootData>
}

class BootDataRepositoryImpl(private val bootDao: BootDao) : BootDataRepository {

    override suspend fun getAll(): List<BootData> = bootDao.getAll()

    override suspend fun insert(data: BootData) {
        bootDao.insert(data)
    }
}