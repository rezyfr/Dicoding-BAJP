package com.rezyfr.dicoding.bajp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rezyfr.dicoding.bajp.data.IMainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: IMainRepository) : ViewModel() {
    fun movieList(): LiveData<Resource<PagedList<MovieEntity>>> = repository.getMovieList()
    fun tvList(): LiveData<Resource<PagedList<TvEntity>>> = repository.getTvList()
}