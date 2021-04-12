package com.rezyfr.dicoding.bajp.data.source

import androidx.lifecycle.LiveData
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity

interface IMainRepository {
    fun getMovieList(): LiveData<List<MovieEntity>>
    fun getTvList(): LiveData<List<TvEntity>>
    fun getMovieDetail(id: Int): LiveData<MovieEntity>
    fun getTvDetail(id: Int): LiveData<TvEntity>
}