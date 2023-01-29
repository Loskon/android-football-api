package com.loskon.sportapi.screens.playerlist.domain

import com.loskon.sportapi.model.PlayerModel
import kotlinx.coroutines.flow.Flow

interface PlayerListRepository {
    suspend fun getPlayersAsFlow(teamName: String): Flow<List<PlayerModel>>
}