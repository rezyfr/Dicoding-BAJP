package com.rezyfr.dicoding.bajp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rezyfr.dicoding.bajp.BuildConfig

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false) var id: Int?,
    var itemTitle: String?,
    var itemDesc: String?,
    var itemPhoto: String?,
    var itemDate: String?,
    var isFavorite: Boolean = false
){

    fun getPosterImage() =
        if (itemPhoto.isNullOrBlank()) null else BuildConfig.IMAGE_URL + itemPhoto
}
