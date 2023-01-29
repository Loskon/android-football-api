package com.loskon.network.source

import com.loskon.network.api.AllSportsApi
import com.loskon.network.dto.MatchDto
import com.loskon.network.dto.PlayerDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkDataSource(
    private val allSportsApi: AllSportsApi
) {

    suspend fun getMatchesAsFlow(
        fromDate: String,
        toDate: String
    ): Flow<List<MatchDto>> {
        return flow {
            val response = allSportsApi.getFixtures(fromDate = fromDate, toDate = toDate)

            if (response.isSuccessful) {
                emit(response.body()?.matches?.reversed() ?: emptyList())
            } else {
                emit(emptyList())
            }
        }
    }

    suspend fun getPlayersAsFlow(
        teamName: String
    ): Flow<List<PlayerDto>> {
        return flow {
            val response = allSportsApi.getTeams(teamName = teamName)

            if (response.isSuccessful) {
                emit(response.body()?.teamInfo?.get(0)?.players ?: emptyList())
            } else {
                emit(emptyList())
            }
        }
    }
}