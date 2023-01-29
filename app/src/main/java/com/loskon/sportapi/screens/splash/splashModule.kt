package com.loskon.sportapi.screens.splash

import com.loskon.sportapi.screens.splash.data.SplashRepositoryImpl
import com.loskon.sportapi.screens.splash.domain.SplashInteractor
import com.loskon.sportapi.screens.splash.domain.SplashRepository
import com.loskon.sportapi.screens.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    single<SplashRepository> { SplashRepositoryImpl(get()) }
    factory { SplashInteractor(get()) }
    viewModel { SplashViewModel(get()) }
}