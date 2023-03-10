package com.loskon.sportapi.screens.splash.domain

import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.flow.Flow

interface SplashRepository {
    suspend fun getMatchesAsFlow(fromDate: String, toDate: String): Flow<List<MatchModel>>
}