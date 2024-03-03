package com.example.footballleague.data.source.local

import androidx.room.TypeConverter
import com.example.footballleague.data.model.pojo.Area
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Converters {
    @OptIn(ExperimentalStdlibApi::class)
    @TypeConverter
    fun stringToArea(string: String?): Area? {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter<Area>().fromJson(string.toString())
    }

    @OptIn(ExperimentalStdlibApi::class)
    @TypeConverter
    fun areaToString(area: Area?): String? {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter<Area>().toJson(area)
    }
}