package com.example.footballleague.data.repository

import com.example.footballleague.data.model.pojo.Competition
import com.example.footballleague.data.model.pojo.asDatabaseModel
import com.example.footballleague.data.source.CompetitionDataSource
import com.example.footballleague.data.source.local.CompetitionDao
import com.example.footballleague.data.source.local.CompetitionLocalDataSource
import com.example.footballleague.data.source.remote.ApiService
import com.example.footballleague.data.source.remote.CompetitionRemoteDataSource
import com.example.footballleague.utils.Result
import com.example.footballleague.utils.asResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepositoryImpl @Inject constructor(
    private val competitionRemoteDataSource: CompetitionDataSource,
    private val competitionLocalDataSource: CompetitionDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DefaultRepository {
    override suspend fun getCompetitions(): Flow<List<Competition>> {
        updateCompetitionsFromRemoteDataSource()
        return competitionLocalDataSource.getCompetitions()
    }

    override suspend fun saveCompetitions(competitions: List<Competition>) {
        TODO("Not yet implemented")
    }

    private suspend fun updateCompetitionsFromRemoteDataSource() {
        competitionRemoteDataSource.getCompetitions().asResult().collectLatest {
            when (it) {
                is Result.Loading -> {
                }

                is Result.Error -> {
                }

                is Result.Success -> {
                    competitionLocalDataSource.saveCompetitions(it.data)
                }
            }
        }
    }
}