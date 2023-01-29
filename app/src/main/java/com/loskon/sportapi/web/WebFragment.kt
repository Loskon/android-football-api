package com.loskon.sportapi.web

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.loskon.base.viewbinding.viewBinding
import com.loskon.sportapi.R
import com.loskon.sportapi.databinding.FragmentWebBinding
import com.loskon.sportapi.web.webclient.AppWebChromeClient
import com.loskon.sportapi.web.webclient.AppWebViewClient

@SuppressLint("SetJavaScriptEnabled")
class WebFragment : Fragment(R.layout.fragment_web) {

    private val binding by viewBinding(FragmentWebBinding::bind)

    private val webChromeClient = AppWebChromeClient()
    private val webViewClient = AppWebViewClient()
    private var currentUrl: String = HOME_URL

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentUrl = savedInstanceState?.getString(KEY_STATE_URL) ?: HOME_URL
        configureWevView()
        setupViewListeners()
    }

    private fun configureWevView() {
        with(binding.webView) {
            with(settings) {
                javaScriptEnabled = true
                loadsImagesAutomatically = true
                loadWithOverviewMode = true
                useWideViewPort = true
                setSupportZoom(true)
                builtInZoomControls = true
                displayZoomControls = false
            }
            webViewClient = this@WebFragment.webViewClient
            webChromeClient = this@WebFragment.webChromeClient
            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            loadUrl(currentUrl)
        }
    }

    private fun setupViewListeners() {
        binding.swWeb.setOnRefreshListener {
            binding.swWeb.isRefreshing = false
            binding.webView.loadUrl(HOME_URL)
        }
        webViewClient.setOnPageLoading {
            binding.indicatorWeb.isVisible = it
        }
        webChromeClient.setOnProgressChanged {
            binding.indicatorWeb.progress = it
        }
        binding.bottomBarWeb.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_STATE_URL, binding.webView.url)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.webView.destroy()
    }

    companion object {
        private const val HOME_URL = "https://www.google.com/"
        private const val KEY_STATE_URL = "KEY_STATE_URL"
    }
}