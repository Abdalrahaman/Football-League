package com.example.footballleague.data.model.pojo

import android.os.Parcelable
import androidx.annotation.Keep
import com.example.footballleague.data.source.local.dto.CompetitionDTO
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Keep
@Parcelize
data class Competition(
    val area: @RawValue Area?,
    val code: String?,
    val currentSeason: @RawValue CurrentSeason?,
    val emblem: String?,
    val id: Int,
    val lastUpdated: String?,
    val name: String,
    val numberOfAvailableSeasons: Int?,
    val plan: String?,
    val type: String?
) : Parcelable

fun List<Competition>.asDatabaseModel(): Array<CompetitionDTO> {
    return map {
        CompetitionDTO(
            id = it.id,
            competitionName = it.name,
            area = it.area,
            emblem = it.emblem
        )
    }.toTypedArray()
}