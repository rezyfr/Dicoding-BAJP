package com.rezyfr.submission1.ui.main

import com.rezyfr.submission1.data.ItemEntity
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var vm: MainViewModel
    private lateinit var items: List<ItemEntity>

    @Before
    fun before() {
        items = mockk()
        vm = MainViewModel()
    }

    @Test
    fun getItem() {
        items = DummyListTest.returnDummyData()
        val data = vm.getDataList("key_movie")
        assertEquals(items, data)
    }

    @Test
    fun getWrongItems() {
        items = DummyListTest.returnDummyData()
        val data = vm.getDataList("key_tv")
        assertNotEquals(items, data)
    }

}