package com.demo.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object StringListConverter {
    @TypeConverter
    fun fromStringList(value: String?): ArrayList<String>? {
        val listType: Type = object : TypeToken<ArrayList<String>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}