package com.rezyfr.dicoding.bajp.data.source.local.entity

import com.rezyfr.dicoding.bajp.BuildConfig

data class TvEntity(
    val id: Int?,
    val tvTitle: String?,
    val tvDesc: String?,
    val tvPhoto: String?,
    val tvDate: String?
){
    fun getPosterImage() =
        if (tvPhoto.isNullOrBlank()) null else BuildConfig.IMAGE_URL + tvPhoto
}
