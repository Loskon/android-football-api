package com.loskon.sportapi.playerlist.domain

import com.loskon.sportapi.model.PlayerModel
import kotlinx.coroutines.flow.Flow

class PlayerListInteractor(
    private val playerListRepository: PlayerListRepository
) {
    suspend fun getPlayersAsFlow(
        teamName: String
    ): Flow<List<PlayerModel>> {
        return playerListRepository.getPlayersAsFlow(teamName)
    }
}