package com.rezyfr.dicoding.bajp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvListResponse(
    @field:SerializedName("results")
    val results: List<TvResponse>? = null,
)
