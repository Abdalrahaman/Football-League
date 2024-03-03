package com.example.footballleague.data.source.remote

import com.example.footballleague.data.model.pojo.Competition
import com.example.footballleague.data.source.CompetitionDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompetitionRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CompetitionDataSource {
    override suspend fun getCompetitions(): Flow<List<Competition>> = flow {
        emit(apiService.getCompetitions().competitions)
    }.flowOn(ioDispatcher)

    override suspend fun saveCompetitions(competitions: List<Competition>) {
        TODO("Not yet implemented")
    }
}