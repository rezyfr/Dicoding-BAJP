package com.rezyfr.dicoding.bajp.ui.detail

import com.rezyfr.dicoding.bajp.data.ItemEntity
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var vm: DetailViewModel
    private lateinit var item: ItemEntity

    @Before
    fun before() {
        item = mockk()
        vm = DetailViewModel()
    }

    @Test
    fun getItem() {
        item = DummyItemTest.returnDummyItem()
        vm.setSelectedItem(1)
        val data = vm.getItemById("key_movie")
        assertEquals(item, data)
    }

    @Test
    fun getWrongItems() {
        item = DummyItemTest.returnDummyItem()
        vm.setSelectedItem(1)
        val data = vm.getItemById("key_tv")
        assertNotEquals(item, data)
    }

}