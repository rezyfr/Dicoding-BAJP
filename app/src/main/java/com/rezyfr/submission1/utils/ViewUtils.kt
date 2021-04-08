package com.rezyfr.submission1.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadEclipseImage(drawable: Int) {
    try {
        Glide.with(context)
            .load(drawable)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}