package com.loskon.sportapi.screens.matchinfo.presentation

import com.loskon.base.presentation.viewmodel.BaseViewModel
import com.loskon.sportapi.model.MatchModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MatchInfoViewModel : BaseViewModel() {

    private val matchInfoState = MutableStateFlow(MatchModel())
    val getMatchInfoState get() = matchInfoState.asStateFlow()

    fun setMatch(match: MatchModel) = matchInfoState.tryEmit(match)
}