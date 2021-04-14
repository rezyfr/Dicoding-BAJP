package com.rezyfr.dicoding.bajp.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class MovieResponse(

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,
)

