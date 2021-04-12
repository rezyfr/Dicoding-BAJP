package com.rezyfr.dicoding.bajp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rezyfr.dicoding.bajp.data.source.IMainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: IMainRepository
) : ViewModel() {
    fun getMovieById(id: Int): LiveData<MovieEntity> = repository.getMovieDetail(id)
    fun getTvById(id: Int): LiveData<TvEntity> = repository.getTvDetail(id)
}