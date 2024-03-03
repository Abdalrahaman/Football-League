package com.example.footballleague.data.source.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.footballleague.data.model.pojo.Area
import com.example.footballleague.data.model.pojo.Competition

@Entity(tableName = "competitions")
data class CompetitionDTO(
    @PrimaryKey
    val id: Int,
    val competitionName: String,
    val area: Area?,
    val emblem: String?
)

fun List<CompetitionDTO>.asDomainModel(): List<Competition> {
    return map {
        Competition(
            id = it.id,
            name = it.competitionName,
            area = it.area,
            emblem = it.emblem,
            currentSeason = null,
            code = null,
            numberOfAvailableSeasons = null,
            plan = null,
            type = null,
            lastUpdated = null
        )
    }
}