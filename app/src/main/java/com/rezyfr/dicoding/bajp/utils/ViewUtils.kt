package com.rezyfr.dicoding.bajp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    try {
        Glide.with(context)
            .load(url)
            .into(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}