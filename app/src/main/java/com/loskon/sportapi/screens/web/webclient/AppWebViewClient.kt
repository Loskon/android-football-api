package com.loskon.sportapi.screens.web.webclient

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient

class AppWebViewClient : WebViewClient() {

    private var onPageLoading: ((Boolean) -> Unit)? = null

    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
        onPageLoading?.invoke(true)
    }

    override fun onPageFinished(view: WebView, url: String?) {
        onPageLoading?.invoke(false)
    }

    fun setOnPageLoading(onPageLoading: ((Boolean) -> Unit)?) {
        this.onPageLoading = onPageLoading
    }
}