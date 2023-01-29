package com.loskon.sportapi.screens.matchlist.presentation

import com.loskon.base.presentation.viewmodel.BaseViewModel
import com.loskon.sportapi.screens.matchlist.domain.MatchListInteractor
import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest

class MatchListViewModel(
    private val matchListInteractor: MatchListInteractor
) : BaseViewModel() {

    private val matchListState = MutableStateFlow<MatchListState>(MatchListState.Loading)
    val getMatchListState get() = matchListState.asStateFlow()

    private var job: Job? = null

    fun getMatchList(fromDate: String, toDate: String) {
        job?.cancel()
        job = launchErrorJob(
            errorBlock = { matchListState.tryEmit(MatchListState.Failure) }
        ) {
            matchListState.tryEmit(MatchListState.Loading)
            matchListInteractor.getMatchesAsFlow(fromDate, toDate).collectLatest {
                matchListState.emit(MatchListState.Success(it))
            }
        }
    }

    fun setMatches(matches: List<MatchModel>) {
        matchListState.tryEmit(MatchListState.Success(matches))
    }
}