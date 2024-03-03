package com.example.footballleague.data.source

import com.example.footballleague.data.model.pojo.Competition
import kotlinx.coroutines.flow.Flow

interface CompetitionDataSource {
    suspend fun getCompetitions(): Flow<List<Competition>>
    suspend fun saveCompetitions(competitions: List<Competition>)
}