package com.loskon.sportapi.screens.playerlist

import com.loskon.sportapi.screens.playerlist.data.PlayerListRepositoryImpl
import com.loskon.sportapi.screens.playerlist.domain.PlayerListInteractor
import com.loskon.sportapi.screens.playerlist.domain.PlayerListRepository
import com.loskon.sportapi.screens.playerlist.presentation.PlayerListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val playerListModule = module {
    single<PlayerListRepository> { PlayerListRepositoryImpl(get()) }
    factory { PlayerListInteractor(get()) }
    viewModel { PlayerListViewModel(get()) }
}