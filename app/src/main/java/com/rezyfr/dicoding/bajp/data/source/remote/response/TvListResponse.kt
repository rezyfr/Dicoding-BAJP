package com.rezyfr.dicoding.bajp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvListResponse(
    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<TvResponse>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)
