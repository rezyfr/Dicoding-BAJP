package com.rezyfr.dicoding.bajp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rezyfr.dicoding.bajp.data.IMainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: IMainRepository
) : ViewModel() {

    private var itemId = MutableLiveData<Int>()

    fun setSelectedItem(id: Int) {
        this.itemId.value = id
    }

    var detailMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(itemId){
        repository.getMovieDetail(it)
    }

    var detailTv: LiveData<Resource<TvEntity>> = Transformations.switchMap(itemId){
        repository.getTvDetail(it)
    }

    fun setMovieFavorite() {
        val movieRes = detailMovie.value
        if (movieRes != null) {
            val detailMovie = movieRes.data
            if (detailMovie != null) {
                val newState = !detailMovie.isFavorite
                repository.setFavoriteMovie(detailMovie, newState)
            }
        }
    }

    fun setTvFavorite() {
        val tvRes = detailTv.value
        if (tvRes != null) {
            val detailTv = tvRes.data
            if (detailTv != null) {
                val newState = !detailTv.isFavorite
                repository.setFavoriteTv(detailTv, newState)
            }
        }
    }
}