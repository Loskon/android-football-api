package com.loskon.sportapi.splash.domain

import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.flow.Flow

class SplashInteractor(
    private val splashRepository: SplashRepository
) {
    suspend fun getMatchesAsFlow(
        fromDate: String,
        toDate: String
    ): Flow<List<MatchModel>> {
        return splashRepository.getMatchesAsFlow(fromDate, toDate)
    }
}