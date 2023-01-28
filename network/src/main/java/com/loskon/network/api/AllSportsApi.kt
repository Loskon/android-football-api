package com.loskon.network.api

import com.loskon.network.dto.FixtureDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AllSportsApi {

    @GET("football/?met=Fixtures")
    suspend fun getFixtures(
        @Query("APIkey") apyKey: String,
        @Query("from") fromDate: String,
        @Query("to") toDate: String
    ): Response<FixtureDto>
}