package com.rezyfr.dicoding.bajp.ui.detail

import androidx.lifecycle.ViewModel
import com.rezyfr.dicoding.bajp.data.ItemEntity
import com.rezyfr.dicoding.bajp.utils.Constant
import com.rezyfr.dicoding.bajp.utils.DataDummy

class DetailViewModel : ViewModel() {

    private var itemId = 0

    fun setSelectedItem(itemId: Int) {
        this.itemId = itemId
    }

    fun getItemById(key: String): ItemEntity {
        lateinit var item: ItemEntity

        val itemsEntities = if (key == Constant.KEY_MOVIE) DataDummy.generateDummyMovies()
        else DataDummy.generateDummyTvShows()

        for (itemEntity in itemsEntities) {
            if (itemEntity.id == itemId) {
                item = itemEntity
            }
        }
        return item
    }
}