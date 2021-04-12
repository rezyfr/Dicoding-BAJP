package com.rezyfr.dicoding.bajp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rezyfr.dicoding.bajp.data.source.IMainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: IMainRepository) : ViewModel() {
    fun movieList(): LiveData<List<MovieEntity>> = repository.getMovieList()
    fun tvList(): LiveData<List<TvEntity>> = repository.getTvList()
}