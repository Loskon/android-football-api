package com.loskon.sportapi.matchinfo

import com.loskon.sportapi.matchinfo.presentation.MatchInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchInfoModule = module {
    viewModel { MatchInfoViewModel() }
}