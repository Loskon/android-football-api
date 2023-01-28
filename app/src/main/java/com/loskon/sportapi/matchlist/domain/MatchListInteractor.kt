package com.loskon.sportapi.matchlist.domain

import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.flow.Flow

class MatchListInteractor(
    private val matchListRepository: MatchListRepository
) {
    suspend fun getMatchesAsFlow(
        apyKey: String,
        fromDate: String,
        toDate: String
    ): Flow<List<MatchModel>> {
        return matchListRepository.getMatchesAsFlow(apyKey, fromDate, toDate)
    }
}