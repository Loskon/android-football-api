package com.loskon.sportapi.matchlist.presentation

import com.loskon.base.presentation.viewmodel.BaseViewModel
import com.loskon.network.BuildConfig.API_KEY
import com.loskon.sportapi.matchlist.domain.MatchListInteractor
import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest

class MatchListViewModel(
    private val matchListInteractor: MatchListInteractor
) : BaseViewModel() {

    private val matchListState = MutableStateFlow<List<MatchModel>>(emptyList())
    val getMatchListState get() = matchListState.asStateFlow()

    private var job: Job? = null

    fun getMatchList() {
        job?.cancel()
        job = launchErrorJob(errorBlock = { disableLoading() }) {
            matchListInteractor.getMatchesAsFlow(API_KEY, "2023-01-28", "2023-02-12").collectLatest {  matchListState.emit(it) }
        }
    }

    private fun disableLoading() {}
}