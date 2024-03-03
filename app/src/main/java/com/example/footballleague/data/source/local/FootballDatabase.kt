package com.example.footballleague.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.footballleague.data.source.local.dto.CompetitionDTO

@Database(entities = [CompetitionDTO::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class FootballDatabase : RoomDatabase() {
    abstract fun competitionDao(): CompetitionDao
}