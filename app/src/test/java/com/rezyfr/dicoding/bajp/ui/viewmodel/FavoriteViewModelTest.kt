package com.rezyfr.dicoding.bajp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.rezyfr.dicoding.bajp.data.MainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.SortUtils
import com.rezyfr.dicoding.bajp.ui.favorite.FavoriteViewModel
import com.rezyfr.dicoding.bajp.ui.utils.PagedListUtil
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private var repo = mock(MainRepository::class.java)
    private var viewModel: FavoriteViewModel? = null

    @Mock
    private lateinit var favMovieObserver: Observer<PagedList<MovieEntity>>
    @Mock
    private lateinit var favTvObserver: Observer<PagedList<TvEntity>>

    private var moviePagedList =  PagedListUtil.mockPagedList(listOf<MovieEntity>())
    private var tvPagedList =  PagedListUtil.mockPagedList(listOf<TvEntity>())

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(repo)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavoriteMovies = moviePagedList
        Mockito.`when`(dummyFavoriteMovies.size).thenReturn(5)
        val favoriteMovies = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovies.value = dummyFavoriteMovies
        Mockito.`when`(repo.getFavoriteMovies(SortUtils.DEFAULT)).thenReturn(favoriteMovies)
        val movieEntities = viewModel?.getFavoriteMovies(SortUtils.DEFAULT)?.value
        Mockito.verify(repo).getFavoriteMovies(SortUtils.DEFAULT)
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(5, movieEntities?.size)
        viewModel?.getFavoriteMovies(SortUtils.DEFAULT)?.observeForever(favMovieObserver)
        Mockito.verify(favMovieObserver).onChanged(dummyFavoriteMovies)
    }

    @Test
    fun getFavoriteTvList() {
        val dummyFavoriteTv = tvPagedList
        Mockito.`when`(dummyFavoriteTv.size).thenReturn(5)
        val favoriteTv = MutableLiveData<PagedList<TvEntity>>()
        favoriteTv.value = dummyFavoriteTv
        Mockito.`when`(repo.getFavoriteTvs(SortUtils.DEFAULT)).thenReturn(favoriteTv)
        val tvEntities = viewModel?.getFavoriteTv(SortUtils.DEFAULT)?.value
        Mockito.verify(repo).getFavoriteTvs(SortUtils.DEFAULT)
        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(5, tvEntities?.size)
        viewModel?.getFavoriteTv(SortUtils.DEFAULT)?.observeForever(favTvObserver)
        Mockito.verify(favTvObserver).onChanged(dummyFavoriteTv)
    }
}