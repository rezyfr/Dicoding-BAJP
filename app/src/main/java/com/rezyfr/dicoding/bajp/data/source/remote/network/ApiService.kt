package com.rezyfr.dicoding.bajp.data.source.remote.network

import com.rezyfr.dicoding.bajp.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.MovieListResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.TvDetailResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.TvListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("3/discover/movie")
    fun getDiscoverMovie(): Call<MovieListResponse>

    @GET("3/discover/tv")
    fun getDiscoverTv(): Call<TvListResponse>

    @GET("3/movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movie_id: Int
    ): Call<MovieDetailResponse>

    @GET("3/tv/{tv_id}")
    fun getTvDetail(
        @Path("tv_id") tv_id: Int
    ): Call<TvDetailResponse>
}