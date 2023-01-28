package com.loskon.sportapi.matchlist

import com.loskon.sportapi.matchlist.data.MatchListRepositoryImpl
import com.loskon.sportapi.matchlist.domain.MatchListInteractor
import com.loskon.sportapi.matchlist.domain.MatchListRepository
import com.loskon.sportapi.matchlist.presentation.MatchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchListModule = module {
    single<MatchListRepository> { MatchListRepositoryImpl(get()) }
    factory { MatchListInteractor(get()) }
    viewModel { MatchListViewModel(get()) }
}