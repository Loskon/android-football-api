package com.loskon.sportapi.web.webclient

import android.os.Message
import android.webkit.WebChromeClient
import android.webkit.WebView

class AppWebChromeClient : WebChromeClient() {

    private var onProgressChanged: ((Int) -> Unit)? = null

    override fun onProgressChanged(view: WebView, progress: Int) {
        onProgressChanged?.invoke(progress)
    }

    override fun onCreateWindow(
        view: WebView,
        isDialog: Boolean,
        isUserGesture: Boolean,
        resultMsg: Message?
    ): Boolean {
        return true
    }

    fun setOnProgressChanged(onProgressChanged: ((Int) -> Unit)?) {
        this.onProgressChanged = onProgressChanged
    }
}