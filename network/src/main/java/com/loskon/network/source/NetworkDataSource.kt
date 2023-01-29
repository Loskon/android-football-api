package com.loskon.network.source

import com.loskon.network.api.AllSportsApi
import com.loskon.network.dto.MatchDto
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
                emit(response.body()?.matches ?: emptyList())
            } else {
                emit(emptyList())
            }
        }
    }
}