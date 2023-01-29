package com.loskon.sportapi.splash.presentation

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.loskon.base.countdowntimer.ShortCountDownTimer
import com.loskon.base.datetime.toFormatString
import com.loskon.cryptocoins.base.extension.coroutines.observe
import com.loskon.sportapi.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDateTime

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel by viewModel<SplashViewModel>()

    private var timer: CountDownTimer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        installObserver()
    }

    private fun installObserver() {
        viewModel.getMatchListState.observe(this) {
            when (it) {
                is SplashState.Success -> findNavController().navigate(SplashFragmentDirections.openMatchList(it.matches.toTypedArray()))
                is SplashState.Error -> findNavController().navigate(SplashFragmentDirections.openMatchList(null))
                null -> {}
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val fromDate = LocalDateTime.now().toFormatString()
        val toDate = LocalDateTime.now().plusDays(RANGE_DAYS).toFormatString()

        ShortCountDownTimer(SPLASH_DURATION) { viewModel.getMatchList(fromDate, toDate) }.start()
    }

    override fun onStop() {
        super.onStop()

        timer?.cancel()
        timer = null
    }

    companion object {
        private const val RANGE_DAYS = 15L
        private const val SPLASH_DURATION = 700L
    }
}