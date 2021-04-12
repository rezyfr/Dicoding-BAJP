package com.rezyfr.dicoding.bajp.data.source.remote.response

import com.google.gson.annotations.SerializedName

open class BaseListResponse<T>(
    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<T>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)