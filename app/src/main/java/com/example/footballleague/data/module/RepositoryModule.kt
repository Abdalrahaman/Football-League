package com.example.footballleague.data.module

import com.example.footballleague.data.repository.DefaultRepository
import com.example.footballleague.data.repository.DefaultRepositoryImpl
import com.example.footballleague.data.source.CompetitionDataSource
import com.example.footballleague.data.source.local.CompetitionDao
import com.example.footballleague.data.source.local.CompetitionLocalDataSource
import com.example.footballleague.data.source.remote.ApiService
import com.example.footballleague.data.source.remote.CompetitionRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDefaultRepository(
        apiService: ApiService,
        competitionDao: CompetitionDao,
    ): DefaultRepository =
        DefaultRepositoryImpl(
            CompetitionRemoteDataSource(apiService),
            CompetitionLocalDataSource(competitionDao)
        )
}