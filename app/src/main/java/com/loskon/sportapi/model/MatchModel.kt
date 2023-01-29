package com.loskon.sportapi.model

import android.os.Parcelable
import com.loskon.network.dto.MatchDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchModel(
    val eventKey: Long = 0L,
    val eventDate: String = "",
    val eventHomeTeam: String = "",
    val homeTeamKey: Long = 0L,
    val eventAwayTeam: String = "",
    val awayTeamKey: Long = 0L,
    val countryName: String = "",
    val leagueName: String = "",
    val leagueKey: Long = 0L,
    val leagueRound: String = "",
    val leagueSeason: String = "",
    val eventLive: String = "",
    val eventStadium: String = "",
    val homeTeamLogo: String = "",
    val awayTeamLogo: String = "",
    val eventCountryKey: Long = 0L,
    val leagueLogo: String = "",
    val countryLogo: String = "",
    val fkStageKey: Long = 0L,
    val stageName: String = ""
) : Parcelable

fun MatchDto.toMatchModel(): MatchModel {
    return MatchModel(
        eventKey = eventKey ?: 0L,
        eventDate = eventDate ?: "",
        eventHomeTeam = eventHomeTeam ?: "",
        homeTeamKey = homeTeamKey ?: 0L,
        eventAwayTeam = eventAwayTeam ?: "",
        awayTeamKey = awayTeamKey ?: 0L,
        countryName = countryName ?: "",
        leagueName = leagueName ?: "",
        leagueKey = leagueKey ?: 0L,
        leagueRound = leagueRound ?: "",
        leagueSeason = leagueSeason ?: "",
        eventLive = eventLive ?: "",
        eventStadium = eventStadium ?: "",
        homeTeamLogo = homeTeamLogo ?: "",
        awayTeamLogo = awayTeamLogo ?: "",
        eventCountryKey = eventCountryKey ?: 0L,
        leagueLogo = leagueLogo ?: "",
        countryLogo = countryLogo ?: "",
        fkStageKey = fkStageKey ?: 0L,
        stageName = stageName ?: ""
    )
}