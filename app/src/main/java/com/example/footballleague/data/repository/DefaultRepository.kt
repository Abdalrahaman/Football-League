package com.example.footballleague.data.repository

import com.example.footballleague.data.model.pojo.Competition
import kotlinx.coroutines.flow.Flow

interface DefaultRepository {
    suspend fun getCompetitions(): Flow<List<Competition>>
    suspend fun saveCompetitions(competitions: List<Competition>)
}