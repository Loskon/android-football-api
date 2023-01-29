package com.loskon.sportapi.screens.playerlist.presentation

import com.loskon.base.presentation.viewmodel.BaseViewModel
import com.loskon.sportapi.screens.playerlist.domain.PlayerListInteractor
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest

class PlayerListViewModel(
    private val playerListInteractor: PlayerListInteractor
) : BaseViewModel() {

    private val playerListState = MutableStateFlow<PlayerListState>(PlayerListState.Loading)
    val getPlayerListState get() = playerListState.asStateFlow()

    private var job: Job? = null

    fun getPlayerList(teamName: String) {
        job?.cancel()
        job = launchErrorJob(
            errorBlock = { playerListState.tryEmit(PlayerListState.Failure) }
        ) {
            playerListState.tryEmit(PlayerListState.Loading)
            playerListInteractor.getPlayersAsFlow(teamName).collectLatest {
                playerListState.emit(PlayerListState.Success(it))
            }
        }
    }
}