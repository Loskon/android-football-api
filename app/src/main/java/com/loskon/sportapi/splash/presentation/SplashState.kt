package com.loskon.sportapi.splash.presentation

import com.loskon.sportapi.model.MatchModel

sealed class SplashState {
    class Success(val matches: List<MatchModel>) : SplashState()
    object Failure : SplashState()
}