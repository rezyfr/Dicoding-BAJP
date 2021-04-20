package com.rezyfr.dicoding.bajp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.Resource

interface IMainRepository {
    fun getMovieList(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getTvList(): LiveData<Resource<PagedList<TvEntity>>>
    fun getMovieDetail(id: Int): LiveData<Resource<MovieEntity>>
    fun getTvDetail(id: Int): LiveData<Resource<TvEntity>>
    fun setFavoriteMovie(movieEntity: MovieEntity, isFavorite: Boolean)
    fun setFavoriteTv(tvEntity: TvEntity, isFavorite: Boolean)
    fun getFavoriteMovies(sort: String): LiveData<PagedList<MovieEntity>>
    fun getFavoriteTvs(sort: String): LiveData<PagedList<TvEntity>>
}