package com.loskon.sportapi.utils

import android.widget.ImageView
import coil.load
import com.loskon.sportapi.R

object ImageLoader {

    fun load(view: ImageView, url: String) {
        view.load(url) {
            crossfade(false)
            placeholder(R.drawable.placeholder)
        }
    }
}