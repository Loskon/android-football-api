package com.loskon.sportapi.screens.matchlist

import com.loskon.sportapi.screens.matchlist.data.MatchListRepositoryImpl
import com.loskon.sportapi.screens.matchlist.domain.MatchListInteractor
import com.loskon.sportapi.screens.matchlist.domain.MatchListRepository
import com.loskon.sportapi.screens.matchlist.presentation.MatchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchListModule = module {
    single<MatchListRepository> { MatchListRepositoryImpl(get()) }
    factory { MatchListInteractor(get()) }
    viewModel { MatchListViewModel(get()) }
}