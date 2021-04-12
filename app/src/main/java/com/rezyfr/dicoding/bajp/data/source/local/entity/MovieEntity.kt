package com.rezyfr.dicoding.bajp.data.source.local.entity

import com.rezyfr.dicoding.bajp.BuildConfig

data class MovieEntity(
    val id: Int?,
    val itemTitle: String?,
    val itemDesc: String?,
    val itemPhoto: String?,
    val itemDate: String?,
){

    fun getPosterImage() =
        if (itemPhoto.isNullOrBlank()) null else BuildConfig.IMAGE_URL + itemPhoto
}
