package com.loskon.network.api

import com.loskon.network.BuildConfig
import com.loskon.network.dto.FixtureDto
import com.loskon.network.dto.TeamDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AllSportsApi {

    @GET("football/?met=Fixtures")
    suspend fun getFixtures(
        @Query("APIkey") apyKey: String = BuildConfig.API_KEY,
        @Query("from") fromDate: String,
        @Query("to") toDate: String
    ): Response<FixtureDto>

    @GET("football/?met=Teams")
    suspend fun getTeams(
        @Query("APIkey") apyKey: String = BuildConfig.API_KEY,
        @Query("teamName") teamName: String
    ): Response<TeamDto>
}