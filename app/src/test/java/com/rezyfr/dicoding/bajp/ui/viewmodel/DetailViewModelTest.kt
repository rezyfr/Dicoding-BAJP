package com.rezyfr.dicoding.bajp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rezyfr.dicoding.bajp.data.source.MainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.ui.detail.DetailViewModel
import com.rezyfr.dicoding.bajp.ui.utils.MovieItemDummy
import com.rezyfr.dicoding.bajp.ui.utils.TvItemDummy
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DetailViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: DetailViewModel? = null
    private var data = mock(MainRepository::class.java)

    @Before
    fun setUp(){
        viewModel = DetailViewModel(data)
    }

    @Test
    fun getMovieDetail(){
        val movie = MutableLiveData<MovieEntity>()
        val detail = MovieItemDummy.getMovieDetail()
        movie.value = MovieEntity(
            detail.id,
            detail.title,
            detail.overview,
            detail.posterPath,
            detail.releaseDate
        )
        `when`(data.getMovieDetail(movie.value?.id!!)).thenReturn(movie)
        val observer = mock(Observer::class.java)
        viewModel?.getMovieById(movie.value?.id!!)?.observeForever(observer as Observer<MovieEntity>)
        verify(data).getMovieDetail(791373)

        assertEquals(movie.value!!.id, viewModel?.getMovieById(movie.value?.id!!)?.value?.id)
        assertEquals(movie.value!!.itemTitle, viewModel?.getMovieById(movie.value?.id!!)?.value?.itemTitle)
        assertEquals(movie.value!!.itemDesc, viewModel?.getMovieById(movie.value?.id!!)?.value?.itemDesc)
        assertEquals(movie.value!!.itemPhoto, viewModel?.getMovieById(movie.value?.id!!)?.value?.itemPhoto)
        assertEquals(movie.value!!.itemDate, viewModel?.getMovieById(movie.value?.id!!)?.value?.itemDate)
    }

    @Test
    fun getTvDetail(){
        val tv = MutableLiveData<TvEntity>()
        val detail = TvItemDummy.getTvDetail()
        tv.value = TvEntity(
            detail.id,
            detail.name,
            detail.overview,
            detail.posterPath,
            detail.firstAirDate
        )
        `when`(data.getTvDetail(tv.value?.id!!)).thenReturn(tv)
        val observer = mock(Observer::class.java)
        viewModel?.getTvById(tv.value?.id!!)?.observeForever(observer as Observer<TvEntity>)
        verify(data).getTvDetail(88396)

        assertEquals(tv.value!!.id, viewModel?.getTvById(tv.value?.id!!)?.value?.id)
        assertEquals(tv.value!!.tvTitle, viewModel?.getTvById(tv.value?.id!!)?.value?.tvTitle)
        assertEquals(tv.value!!.tvDesc, viewModel?.getTvById(tv.value?.id!!)?.value?.tvDesc)
        assertEquals(tv.value!!.tvPhoto, viewModel?.getTvById(tv.value?.id!!)?.value?.tvPhoto)
        assertEquals(tv.value!!.tvDate, viewModel?.getTvById(tv.value?.id!!)?.value?.tvDate)
    }
}