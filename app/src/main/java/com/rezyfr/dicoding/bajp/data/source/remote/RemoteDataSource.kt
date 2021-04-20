package com.rezyfr.dicoding.bajp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rezyfr.dicoding.bajp.data.source.remote.network.ApiService
import com.rezyfr.dicoding.bajp.data.source.remote.response.*
import com.rezyfr.dicoding.bajp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getMovieList(): LiveData<ApiResponse<List<MovieResponse>>> {
        val result = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        EspressoIdlingResource.increment()
        apiService.getDiscoverMovie().enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>
            ) {
                response.body()?.results?.let {
                    result.postValue(ApiResponse.success(it))
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
                Log.e("RemoteDataSource", "${t.message}")
                ApiResponse.error("${t.message}", null)
            }
        })
        return result
    }

    fun getMovieDetail(id: Int): MutableLiveData<ApiResponse<MovieDetailResponse>> {
        val result = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        EspressoIdlingResource.increment()
        apiService.getMovieDetail(id).enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                response.body()?.let { result.postValue(ApiResponse.success(it)) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
                Log.e("RemoteDataSource", "${t.message}")
                ApiResponse.error("${t.message}", null)
            }

        })
        return result
    }

    fun getTvList(): MutableLiveData<ApiResponse<List<TvResponse>>> {
        val result = MutableLiveData<ApiResponse<List<TvResponse>>>()
        EspressoIdlingResource.increment()
        apiService.getDiscoverTv().enqueue(object : Callback<TvListResponse> {
            override fun onResponse(
                call: Call<TvListResponse>,
                response: Response<TvListResponse>
            ) {
                response.body()?.results?.let { result.postValue(ApiResponse.success(it)) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvListResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "${t.message}")
                ApiResponse.error("${t.message}", null)
                EspressoIdlingResource.decrement()
            }

        })
        return result
    }

    fun getTvDetail(id: Int): MutableLiveData<ApiResponse<TvDetailResponse>> {
        val result = MutableLiveData<ApiResponse<TvDetailResponse>>()
        EspressoIdlingResource.increment()
        apiService.getTvDetail(id).enqueue(object : Callback<TvDetailResponse> {
            override fun onResponse(
                call: Call<TvDetailResponse>,
                response: Response<TvDetailResponse>
            ) {
                response.body()?.let { result.postValue(ApiResponse.success(it)) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                EspressoIdlingResource.decrement()
                Log.e("RemoteDataSource", "${t.message}")
                ApiResponse.error("${t.message}", null)
            }

        })
        return result
    }
}