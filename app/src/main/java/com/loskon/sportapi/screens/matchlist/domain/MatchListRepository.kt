package com.loskon.sportapi.screens.matchlist.domain

import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.flow.Flow

interface MatchListRepository {
    suspend fun getMatchesAsFlow(fromDate: String, toDate: String): Flow<List<MatchModel>>
}