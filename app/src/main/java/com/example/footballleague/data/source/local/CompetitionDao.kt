package com.example.footballleague.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballleague.data.source.local.dto.CompetitionDTO

@Dao
interface CompetitionDao {
    @Query("select * from competitions")
    fun getCompetitions(): List<CompetitionDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg competitions: CompetitionDTO)
}