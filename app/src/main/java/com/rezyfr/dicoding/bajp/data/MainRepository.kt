package com.rezyfr.dicoding.bajp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rezyfr.dicoding.bajp.data.source.local.LocalDataSource
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.remote.ApiResponse
import com.rezyfr.dicoding.bajp.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.bajp.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.MovieResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.TvDetailResponse
import com.rezyfr.dicoding.bajp.data.source.remote.response.TvResponse
import com.rezyfr.dicoding.bajp.data.source.utils.Resource
import com.rezyfr.dicoding.bajp.utils.AppExecutors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMainRepository {
    override fun getMovieList(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                Log.d("MainRepo: ", "${localDataSource.getMovies()}")
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovieList()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = data.map {
                    MovieEntity(it.id, it.title, it.overview, it.posterPath, it.releaseDate)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getTvList(): LiveData<Resource<PagedList<TvEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvEntity>, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(3)
                    .setPageSize(3)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvList(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getTvList()

            override fun saveCallResult(data: List<TvResponse>) {
                val movieList = data.map {
                    TvEntity(it.id, it.name, it.overview, it.posterPath, it.firstAirDate)
                }
                localDataSource.insertTvs(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(id: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(id)

            override fun shouldFetch(data: MovieEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getMovieDetail(id)

            override fun saveCallResult(data: MovieDetailResponse) {
                val entity = MovieEntity(
                    data.id, data.title, data.overview, data.posterPath, data.releaseDate
                )
                localDataSource.insertMovie(entity)
            }
        }.asLiveData()
    }

    override fun getTvDetail(id: Int): LiveData<Resource<TvEntity>> {
        return object : NetworkBoundResource<TvEntity, TvDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvEntity> = localDataSource.getTvDetail(id)

            override fun shouldFetch(data: TvEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<TvDetailResponse>> =
                remoteDataSource.getTvDetail(id)

            override fun saveCallResult(data: TvDetailResponse) {
                val entity = TvEntity(
                    data.id,
                    data.name,
                    data.overview,
                    data.posterPath,
                    "${data.firstAirDate} - ${data.lastAirDate}"
                )
                localDataSource.insertTv(entity)
            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(movieEntity: MovieEntity, isFavorite: Boolean) {
        appExecutors.diskIO().execute{
            localDataSource.setMovieFavorite(movieEntity, isFavorite)
        }
    }

    override fun setFavoriteTv(tvEntity: TvEntity, isFavorite: Boolean) {
        appExecutors.diskIO().execute{
            localDataSource.setTvFavorite(tvEntity, isFavorite)
        }
    }

    override fun getFavoriteMovies(sort: String): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(3)
            .setPageSize(3)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(sort), config).build()
    }

    override fun getFavoriteTvs(sort: String): LiveData<PagedList<TvEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(3)
            .setPageSize(3)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvs(sort), config).build()
    }
}