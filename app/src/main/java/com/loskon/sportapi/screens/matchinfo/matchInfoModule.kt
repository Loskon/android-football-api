package com.loskon.sportapi.screens.matchinfo

import com.loskon.sportapi.screens.matchinfo.presentation.MatchInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchInfoModule = module {
    viewModel { MatchInfoViewModel() }
}