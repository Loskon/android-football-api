package com.loskon.sportapi.splash.presentation

import com.loskon.base.presentation.viewmodel.BaseViewModel
import com.loskon.sportapi.splash.domain.SplashInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest

class SplashViewModel(
    private val matchListInteractor: SplashInteractor
) : BaseViewModel() {

    private val matchListState = MutableStateFlow<SplashState?>(null)
    val getMatchListState get() = matchListState.asStateFlow()

    fun getMatchList(fromDate: String, toDate: String) {
        launchErrorJob(
            errorBlock = { matchListState.tryEmit(SplashState.Error) }
        ) {
            matchListInteractor.getMatchesAsFlow(
                fromDate,
                toDate
            ).collectLatest {
                matchListState.emit(SplashState.Success(it))
            }
        }
    }
}