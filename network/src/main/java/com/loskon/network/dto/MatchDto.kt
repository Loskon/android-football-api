package com.loskon.network.dto

import com.squareup.moshi.Json

data class MatchDto(
    @Json(name = "event_key")
    val eventKey: Long,

    @Json(name = "event_date")
    val eventDate: String,

    @Json(name = "event_time")
    val eventTime: String,

    @Json(name = "event_home_team")
    val eventHomeTeam: String,

    @Json(name = "home_team_key")
    val homeTeamKey: Long,

    @Json(name = "event_away_team")
    val eventAwayTeam: String,

    @Json(name = "away_team_key")
    val awayTeamKey: Long,

    @Json(name = "country_name")
    val countryName: String,

    @Json(name = "league_name")
    val leagueName: String,

    @Json(name = "league_key")
    val leagueKey: Long,

    @Json(name = "league_round")
    val leagueRound: String,

    @Json(name = "league_season")
    val leagueSeason: String,

    @Json(name = "event_live")
    val eventLive: String,

    @Json(name = "event_stadium")
    val eventStadium: String,

    @Json(name = "home_team_logo")
    val homeTeamLogo: String,

    @Json(name = "away_team_logo")
    val awayTeamLogo: String,

    @Json(name = "event_country_key")
    val eventCountryKey: Long,

    @Json(name = "league_logo")
    val leagueLogo: String,

    @Json(name = "country_logo")
    val countryLogo: String,

    @Json(name = "fk_stage_key")
    val fkStageKey: Long,

    @Json(name = "stage_name")
    val stageName: String
)