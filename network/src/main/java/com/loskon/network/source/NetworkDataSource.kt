package com.loskon.network.source

import com.loskon.network.api.AllSportsApi
import com.loskon.network.dto.MatchDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkDataSource(
    private val allSportsApi: AllSportsApi
) {

    suspend fun getMatchesAsFlow(
        apyKey: String,
        fromDate: String,
        toDate: String
    ): Flow<List<MatchDto>> {
        return flow {
            val response = allSportsApi.getFixtures(apyKey, fromDate, toDate)

            if (response.isSuccessful) {
                emit(response.body()?.matches ?: emptyList())
            } else {
                emit(emptyList())
            }
        }
    }
}