package com.rezyfr.dicoding.bajp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rezyfr.dicoding.bajp.BuildConfig

@Entity(tableName = "tv")
data class TvEntity(
    @PrimaryKey(autoGenerate = false) val id: Int?,
    val tvTitle: String?,
    val tvDesc: String?,
    val tvPhoto: String?,
    val tvDate: String?,
    var isFavorite: Boolean = false
){

    fun getPosterImage() =
        if (tvPhoto.isNullOrBlank()) null else BuildConfig.IMAGE_URL + tvPhoto
}
