package com.loskon.sportapi.playerlist.presentation

import com.loskon.sportapi.model.PlayerModel

sealed class PlayerListState {
    object Loading : PlayerListState()
    data class Success(val players: List<PlayerModel>) : PlayerListState()
    object Failure : PlayerListState()
}