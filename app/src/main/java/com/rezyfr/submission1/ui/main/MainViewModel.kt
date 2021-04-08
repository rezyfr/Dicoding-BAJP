package com.rezyfr.submission1.ui.main

import androidx.lifecycle.ViewModel
import com.rezyfr.submission1.data.ItemEntity
import com.rezyfr.submission1.utils.Constant
import com.rezyfr.submission1.utils.DataDummy.generateDummyMovies
import com.rezyfr.submission1.utils.DataDummy.generateDummyTvShows

class MainViewModel : ViewModel() {

    fun getDataList(key: String): List<ItemEntity> {
        return if (key == Constant.KEY_MOVIE) generateDummyMovies()
        else generateDummyTvShows()
    }

}