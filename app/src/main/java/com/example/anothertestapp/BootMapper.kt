package com.example.anothertestapp

import com.example.anothertestapp.data.BootData

class BootMapper {

    fun map(list: List<BootData>): String {
        if (list.isEmpty())
            return "No boots detected"

        val stringBuilder = StringBuilder()
        list.forEach { stringBuilder.append("${it.id} - ${it.timestamp}\n") }
        return stringBuilder.toString()
    }
}