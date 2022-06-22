package com.example.util

import com.example.features.getSneakers.model.SneakerCollection
import com.google.gson.Gson
import java.io.File

interface JSONConvertable {
    fun toJSON(): String = Gson().toJson(this)
}

inline fun <reified T: JSONConvertable> String.toObject(): T = Gson().fromJson(this, T::class.java)

inline fun <reified T: JSONConvertable> dataFromJson(fileDir: String) : T {
    val jsonText = readFileDirectlyAsText(fileDir)
    return jsonText.toObject()
}

fun readFileDirectlyAsText(fileName: String): String
        = File(fileName).readText(Charsets.UTF_8)