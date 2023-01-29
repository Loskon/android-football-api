package com.loskon.sportapi.screens.matchlist.domain

import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.flow.Flow

class MatchListInteractor(
    private val matchListRepository: MatchListRepository
) {
    suspend fun getMatchesAsFlow(
        fromDate: String,
        toDate: String
    ): Flow<List<MatchModel>> {
        return matchListRepository.getMatchesAsFlow(fromDate, toDate)
    }
}