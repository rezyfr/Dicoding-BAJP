package com.rezyfr.dicoding.bajp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rezyfr.dicoding.bajp.data.IMainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: IMainRepository
):ViewModel() {
    fun getFavoriteMovies(sort: String): LiveData<PagedList<MovieEntity>> = repository.getFavoriteMovies(sort)
    fun getFavoriteTv(sort: String): LiveData<PagedList<TvEntity>> = repository.getFavoriteTvs(sort)
}
