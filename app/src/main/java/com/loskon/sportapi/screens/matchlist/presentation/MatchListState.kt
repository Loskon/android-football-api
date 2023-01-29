package com.loskon.sportapi.screens.matchlist.presentation

import com.loskon.sportapi.model.MatchModel

sealed class MatchListState {
    object Loading : MatchListState()
    data class Success(val matches: List<MatchModel>) : MatchListState()
    object Failure : MatchListState()
}