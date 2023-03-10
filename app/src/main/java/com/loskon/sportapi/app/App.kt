package com.loskon.sportapi.app

import android.app.Application
import com.loskon.network.networkModule
import com.loskon.sportapi.BuildConfig
import com.loskon.sportapi.screens.matchinfo.matchInfoModule
import com.loskon.sportapi.screens.matchlist.matchListModule
import com.loskon.sportapi.screens.playerlist.playerListModule
import com.loskon.sportapi.screens.splash.splashModule
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        installOneSignal()
        initializeKoin(this)
    }

    private fun installOneSignal() {
        if (BuildConfig.DEBUG) OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

    private fun initializeKoin(application: Application) {
        startKoin {
            androidContext(application)
            modules(listOf(networkModule, splashModule, matchListModule, matchInfoModule, playerListModule))
        }
    }

    companion object {
        private const val ONESIGNAL_APP_ID = "d8a6da42-ad9f-43e3-b775-0c6854aa2591"
    }
}