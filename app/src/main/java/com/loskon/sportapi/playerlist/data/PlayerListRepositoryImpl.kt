package com.loskon.sportapi.playerlist.data

import com.loskon.network.source.NetworkDataSource
import com.loskon.sportapi.model.PlayerModel
import com.loskon.sportapi.model.toPlayerModel
import com.loskon.sportapi.playerlist.domain.PlayerListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlayerListRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : PlayerListRepository {

    override suspend fun getPlayersAsFlow(
        teamName: String
    ): Flow<List<PlayerModel>> {
        return networkDataSource.getPlayersAsFlow(
            teamName
        ).map { players ->
            players.map { it.toPlayerModel() }
        }
    }
}