package com.loskon.sportapi.matchlist.data

import com.loskon.network.source.NetworkDataSource
import com.loskon.sportapi.matchlist.domain.MatchListRepository
import com.loskon.sportapi.model.MatchModel
import com.loskon.sportapi.model.toMatchModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MatchListRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : MatchListRepository {

    override suspend fun getMatchesAsFlow(
        apyKey: String,
        fromDate: String,
        toDate: String
    ): Flow<List<MatchModel>> {
        return networkDataSource.getMatchesAsFlow(
            apyKey,
            fromDate,
            toDate
        ).map { matches ->
            matches.map { it.toMatchModel() }
        }
    }
}