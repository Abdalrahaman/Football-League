package com.example.footballleague.data.module

import android.content.Context
import androidx.room.Room
import com.example.footballleague.data.source.local.CompetitionDao
import com.example.footballleague.data.source.local.FootballDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): FootballDatabase {
        return Room.databaseBuilder(
            context,
            FootballDatabase::class.java,
            "football-league"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCompetitionDao(footballDatabase: FootballDatabase): CompetitionDao {
        return footballDatabase.competitionDao()
    }
}