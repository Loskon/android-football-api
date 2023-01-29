package com.loskon.sportapi.splash.data

import com.loskon.network.source.NetworkDataSource
import com.loskon.sportapi.model.MatchModel
import com.loskon.sportapi.model.toMatchModel
import com.loskon.sportapi.splash.domain.SplashRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SplashRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : SplashRepository {

    override suspend fun getMatchesAsFlow(
        fromDate: String,
        toDate: String
    ): Flow<List<MatchModel>> {
        return networkDataSource.getMatchesAsFlow(
            fromDate,
            toDate
        ).map { matches ->
            matches.map { it.toMatchModel() }
        }
    }
}