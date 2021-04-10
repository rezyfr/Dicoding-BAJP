package com.rezyfr.dicoding.bajp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingUtils {

    @BindingAdapter(("imageUrl"))
    fun loadImageUrl(view: ImageView, url: Int?) {
        url?.let { view.loadEclipseImage(url) }
    }
}