package com.loskon.sportapi.model

import com.loskon.network.dto.PlayerDto

data class PlayerModel(
    val playerKey: Long = 0L,
    val playerName: String = "",
    val playerNumber: String = "",
    val playerType: String = "",
    val playerAge: String = "",
    val playerMatchPlayed: String = "",
    val playerGoals: String = "",
    val playerYellowCards: String = "",
    val playerRedCards: String = ""
)

fun PlayerDto.toPlayerModel(): PlayerModel {
    return PlayerModel(
        playerKey = playerKey ?: 0L,
        playerName = playerName ?: "",
        playerNumber = playerNumber ?: "",
        playerType = playerType ?: "",
        playerAge = playerAge ?: "",
        playerMatchPlayed = playerMatchPlayed ?: "",
        playerGoals = playerGoals ?: "",
        playerYellowCards = playerYellowCards ?: "",
        playerRedCards = playerRedCards ?: "",
    )
}