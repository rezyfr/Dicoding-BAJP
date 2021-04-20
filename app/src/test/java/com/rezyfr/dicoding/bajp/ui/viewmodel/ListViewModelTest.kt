package com.rezyfr.dicoding.bajp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.rezyfr.dicoding.bajp.data.MainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.Resource
import com.rezyfr.dicoding.bajp.ui.main.ListViewModel
import com.rezyfr.dicoding.bajp.ui.utils.MovieItemDummy
import com.rezyfr.dicoding.bajp.ui.utils.PagedListUtil
import com.rezyfr.dicoding.bajp.ui.utils.TvItemDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ListViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: ListViewModel? = null
    private var repo = Mockito.mock(MainRepository::class.java)

    @Before
    fun setUp() {
        viewModel = ListViewModel(repo)
    }

    @Test
    fun getMovieList() {
        val pagedList = PagedListUtil.mockPagedList(MovieItemDummy.getMovieListResponse())
        val movie = Resource.success(pagedList)
        `when`(movie.data?.size).thenReturn(3)
        val movieEntity = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movieEntity.value = movie
        `when`(repo.getMovieList()).thenReturn(movieEntity)
        val movieEntities = viewModel?.movieList()?.value?.data
        Mockito.verify(repo).getMovieList()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(3, movieEntities?.size)
        val observer = Mockito.mock(Observer::class.java) as Observer<in Resource<PagedList<MovieEntity>>>
        viewModel?.movieList()?.observeForever(observer)
        Mockito.verify(observer).onChanged(movie)
    }

    @Test
    fun getWrongMovieList() {
        val pagedList = PagedListUtil.mockPagedList(MovieItemDummy.getMovieListResponse())
        val movie = Resource.success(pagedList)
        `when`(movie.data?.size).thenReturn(0)
        val movieEntity = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movieEntity.value = movie
        `when`(repo.getMovieList()).thenReturn(movieEntity)
        val movieEntities = viewModel?.movieList()?.value?.data
        Mockito.verify(repo).getMovieList()
        Assert.assertNotNull(movieEntities)
        Assert.assertNotEquals(3, movieEntities?.size)
        val observer = Mockito.mock(Observer::class.java) as Observer<in Resource<PagedList<MovieEntity>>>
        viewModel?.movieList()?.observeForever(observer)
        Mockito.verify(observer).onChanged(movie)
    }

    @Test
    fun getTvList() {
        val pagedList = PagedListUtil.mockPagedList(TvItemDummy.getTvListResponse())
        val tv = Resource.success(pagedList)
        `when`(tv.data?.size).thenReturn(3)
        val tvEntity = MutableLiveData<Resource<PagedList<TvEntity>>>()
        tvEntity.value = tv
        `when`(repo.getTvList()).thenReturn(tvEntity)
        val tvEntities = viewModel?.tvList()?.value?.data
        Mockito.verify(repo).getTvList()
        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(3, tvEntities?.size)
        val observer = Mockito.mock(Observer::class.java) as Observer<in Resource<PagedList<TvEntity>>>
        viewModel?.tvList()?.observeForever(observer)
        Mockito.verify(observer).onChanged(tv)
    }

    @Test
    fun getWrongTvList() {
        val pagedList = PagedListUtil.mockPagedList(TvItemDummy.getTvListResponse())
        val tv = Resource.success(pagedList)
        `when`(tv.data?.size).thenReturn(0)
        val tvEntity = MutableLiveData<Resource<PagedList<TvEntity>>>()
        tvEntity.value = tv
        `when`(repo.getTvList()).thenReturn(tvEntity)
        val tvEntities = viewModel?.tvList()?.value?.data
        Mockito.verify(repo).getTvList()
        Assert.assertNotNull(tvEntities)
        Assert.assertNotEquals(3, tvEntities?.size)
        val observer = Mockito.mock(Observer::class.java) as Observer<in Resource<PagedList<TvEntity>>>
        viewModel?.tvList()?.observeForever(observer)
        Mockito.verify(observer).onChanged(tv)
    }

}