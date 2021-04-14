package com.rezyfr.dicoding.bajp.data.source.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.rezyfr.dicoding.bajp.data.source.remote.network.ApiService
import com.rezyfr.dicoding.bajp.data.source.remote.response.*
import com.rezyfr.dicoding.bajp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    private val handler = Handler(Looper.getMainLooper())
    companion object{

        private const val LATENCY_IN_MILLIS: Long = 2000
    }

    fun getMovieList(callback: GetMovieListCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            apiService.getDiscoverMovie().enqueue(object : Callback<MovieListResponse>{
                override fun onResponse(
                    call: Call<MovieListResponse>,
                    response: Response<MovieListResponse>
                ) {
                    response.body()?.results?.let { callback.onResponse(it) }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                    Log.e("RemoteDataSource", "${t.message}")
                }

            })
        }, LATENCY_IN_MILLIS)
    }

    fun getMovieDetail(callback: GetMovieDetailCallback, id: Int) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            apiService.getMovieDetail(id).enqueue(object : Callback<MovieDetailResponse>{
                override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
                ) {
                    response.body()?.let { callback.onResponse(it) }
                EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.e("RemoteDataSource", "${t.message}")
                }

            })
        }, LATENCY_IN_MILLIS)
    }

    fun getTvList(callback: GetTvListCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            apiService.getDiscoverTv().enqueue(object : Callback<TvListResponse>{
                override fun onResponse(
                    call: Call<TvListResponse>,
                    response: Response<TvListResponse>
                ) {
                    response.body()?.results?.let { callback.onResponse(it) }
                EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvListResponse>, t: Throwable) {
                    Log.e("RemoteDataSource", "${t.message}")
                }

            })
        }, LATENCY_IN_MILLIS)
    }

    fun getTvDetail(callback: GetTvDetailCallback, id: Int) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            apiService.getTvDetail(id).enqueue(object : Callback<TvDetailResponse>{
                override fun onResponse(
                    call: Call<TvDetailResponse>,
                    response: Response<TvDetailResponse>
                ) {
                    response.body()?.let { callback.onResponse(it) }
                EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                    Log.e("RemoteDataSource", "${t.message}")
                }

            })
        }, LATENCY_IN_MILLIS)
    }

    interface GetMovieListCallback{
        fun onResponse(response: List<MovieResponse>)
    }

    interface GetMovieDetailCallback{
        fun onResponse(response: MovieDetailResponse)
    }

    interface GetTvListCallback{
        fun onResponse(response: List<TvResponse>)
    }

    interface GetTvDetailCallback{
        fun onResponse(response: TvDetailResponse)
    }
}