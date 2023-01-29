package com.loskon.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamDto(
    @Json(name = "success")
    val success: Long? = null,

    @Json(name = "result")
    val teamInfo: List<TeamInfoDto>? = null
)

@JsonClass(generateAdapter = true)
data class TeamInfoDto(
    @Json(name = "team_key")
    val teamKey: Long? = null,

    @Json(name = "players")
    val players: List<PlayerDto>? = null,
)

@JsonClass(generateAdapter = true)
data class PlayerDto(
    @Json(name = "player_key")
    val playerKey: Long? = null,

    @Json(name = "player_name")
    val playerName: String? = null,

    @Json(name = "player_number")
    val playerNumber: String? = null,

    @Json(name = "player_type")
    val playerType: String? = null,

    @Json(name = "player_age")
    val playerAge: String? = null,

    @Json(name = "player_match_played")
    val playerMatchPlayed: String? = null,

    @Json(name = "player_goals")
    val playerGoals: String? = null,

    @Json(name = "player_yellow_cards")
    val playerYellowCards: String? = null,

    @Json(name = "player_red_cards")
    val playerRedCards: String? = null
)