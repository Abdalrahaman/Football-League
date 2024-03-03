package com.example.footballleague.data.source.local

import com.example.footballleague.data.model.pojo.Competition
import com.example.footballleague.data.model.pojo.asDatabaseModel
import com.example.footballleague.data.source.CompetitionDataSource
import com.example.footballleague.data.source.local.dto.asDomainModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompetitionLocalDataSource @Inject constructor(
    private val competitionDao: CompetitionDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CompetitionDataSource {
    override suspend fun getCompetitions(): Flow<List<Competition>> = flow {
        emit(competitionDao.getCompetitions().asDomainModel())
    }.flowOn(ioDispatcher)

    override suspend fun saveCompetitions(competitions: List<Competition>) =
        withContext(ioDispatcher) {
            competitionDao.insertAll(*competitions.asDatabaseModel())
        }
}