package com.loskon.sportapi

import android.app.Application
import com.loskon.network.networkModule
import com.loskon.sportapi.matchlist.matchListModule
import com.loskon.sportapi.splash.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        initializeKoin(this)
    }

    private fun initializeKoin(application: Application) {
        startKoin {
            androidContext(application)
            modules(listOf(networkModule, splashModule, matchListModule))
        }
    }
}