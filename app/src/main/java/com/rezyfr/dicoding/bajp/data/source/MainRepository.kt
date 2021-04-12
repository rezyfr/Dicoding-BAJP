package com.rezyfr.dicoding.bajp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.bajp.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.MovieResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.TvDetailResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.TvResponse
import com.rezyfr.dicoding.bajp.utils.EspressoIdlingResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : IMainRepository {
    override fun getMovieList(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        EspressoIdlingResource.increment()
        remoteDataSource.getMovieList(object : RemoteDataSource.GetMovieListCallback {
            override fun onResponse(response: List<MovieResponse>) {
                val movieEntities = response.map {
                    MovieEntity(
                        it.id, it.title, it.overview, it.posterPath, it.releaseDate
                    )
                }
                movieResults.postValue(movieEntities)
                EspressoIdlingResource.decrement()
            }
        })
        return movieResults
    }

    override fun getTvList(): LiveData<List<TvEntity>> {
        val tvResults = MutableLiveData<List<TvEntity>>()
        EspressoIdlingResource.increment()
        remoteDataSource.getTvList(object : RemoteDataSource.GetTvListCallback {
            override fun onResponse(response: List<TvResponse>) {
                val tvEntities = response.map {
                    TvEntity(
                        it.id, it.name, it.overview, it.posterPath, it.firstAirDate
                    )
                }
                tvResults.postValue(tvEntities)
                EspressoIdlingResource.decrement()
            }
        })
        return tvResults
    }

    override fun getMovieDetail(id: Int): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        EspressoIdlingResource.increment()
        remoteDataSource.getMovieDetail(object : RemoteDataSource.GetMovieDetailCallback {
            override fun onResponse(response: MovieDetailResponse) {
                val movieEntity = MovieEntity(
                    response.id,
                    response.title,
                    response.overview,
                    response.posterPath,
                    response.releaseDate
                )
                movieResult.postValue(movieEntity)
                EspressoIdlingResource.decrement()
            }
        }, id)
        return movieResult
    }

    override fun getTvDetail(id: Int): LiveData<TvEntity> {
        val tvResult = MutableLiveData<TvEntity>()
        EspressoIdlingResource.increment()
        remoteDataSource.getTvDetail(object : RemoteDataSource.GetTvDetailCallback {
            override fun onResponse(response: TvDetailResponse) {
                val tvEntity = TvEntity(
                    response.id,
                    response.name,
                    response.overview,
                    response.posterPath,
                    if (response.lastAirDate.isNullOrEmpty()) response.firstAirDate
                    else "${response.firstAirDate} - ${response.lastAirDate}"
                )

                tvResult.postValue(tvEntity)
                EspressoIdlingResource.decrement()
            }
        }, id)
        return tvResult
    }
}