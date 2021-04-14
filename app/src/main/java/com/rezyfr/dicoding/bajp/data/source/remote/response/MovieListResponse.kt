package com.rezyfr.dicoding.bajp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @field:SerializedName("results")
    val results: List<MovieResponse>? = null,
)
