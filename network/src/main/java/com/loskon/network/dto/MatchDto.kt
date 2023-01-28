package com.loskon.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FixtureDto(
    @Json(name = "success")
    val success: Long? = null,

    @Json(name = "result")
    val matches: List<MatchDto>? = null
)

@JsonClass(generateAdapter = true)
data class MatchDto(
    @Json(name = "event_key")
    val eventKey: Long? = null,

    @Json(name = "event_date")
    val eventDate: String? = null,

    @Json(name = "event_home_team")
    val eventHomeTeam: String? = null,

    @Json(name = "home_team_key")
    val homeTeamKey: Long? = null,

    @Json(name = "event_away_team")
    val eventAwayTeam: String? = null,

    @Json(name = "away_team_key")
    val awayTeamKey: Long? = null,

    @Json(name = "country_name")
    val countryName: String? = null,

    @Json(name = "league_name")
    val leagueName: String? = null,

    @Json(name = "league_key")
    val leagueKey: Long? = null,

    @Json(name = "league_round")
    val leagueRound: String? = null,

    @Json(name = "league_season")
    val leagueSeason: String? = null,

    @Json(name = "event_live")
    val eventLive: String? = null,

    @Json(name = "event_stadium")
    val eventStadium: String? = null,

    @Json(name = "home_team_logo")
    val homeTeamLogo: String? = null,

    @Json(name = "away_team_logo")
    val awayTeamLogo: String? = null,

    @Json(name = "event_country_key")
    val eventCountryKey: Long? = null,

    @Json(name = "league_logo")
    val leagueLogo: String? = null,

    @Json(name = "country_logo")
    val countryLogo: String? = null,

    @Json(name = "fk_stage_key")
    val fkStageKey: Long? = null,

    @Json(name = "stage_name")
    val stageName: String? = null
)