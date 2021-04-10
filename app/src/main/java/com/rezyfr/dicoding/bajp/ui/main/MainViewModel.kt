package com.rezyfr.dicoding.bajp.ui.main

import androidx.lifecycle.ViewModel
import com.rezyfr.dicoding.bajp.data.ItemEntity
import com.rezyfr.dicoding.bajp.utils.Constant
import com.rezyfr.dicoding.bajp.utils.DataDummy.generateDummyMovies
import com.rezyfr.dicoding.bajp.utils.DataDummy.generateDummyTvShows

class MainViewModel : ViewModel() {

    fun getDataList(key: String): List<ItemEntity> {
        return if (key == Constant.KEY_MOVIE) generateDummyMovies()
        else generateDummyTvShows()
    }

}