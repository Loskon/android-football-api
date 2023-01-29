package com.loskon.sportapi.splash

import com.loskon.sportapi.splash.data.SplashRepositoryImpl
import com.loskon.sportapi.splash.domain.SplashInteractor
import com.loskon.sportapi.splash.domain.SplashRepository
import com.loskon.sportapi.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    single<SplashRepository> { SplashRepositoryImpl(get()) }
    factory { SplashInteractor(get()) }
    viewModel { SplashViewModel(get()) }
}