package com.example.footballleague.data.source.remote

import com.example.footballleague.data.model.response.CompetitionResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v4/competitions")
    suspend fun getCompetitions(): CompetitionResponse
}