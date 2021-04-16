package com.rezyfr.dicoding.bajp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rezyfr.dicoding.bajp.data.source.MainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.ui.main.ListViewModel
import com.rezyfr.dicoding.bajp.ui.utils.MovieItemDummy
import com.rezyfr.dicoding.bajp.ui.utils.TvItemDummy
import junit.framework.Assert.assertNotSame
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class ListViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: ListViewModel? = null
    private var data = Mockito.mock(MainRepository::class.java)

    @Before
    fun setUp() {
        viewModel = ListViewModel(data)
    }

    @Test
    fun getMovieList() {
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = MovieItemDummy.getMovieListResponse().results?.map {
            MovieEntity(
                it.id,
                it.title,
                it.overview,
                it.posterPath,
                it.releaseDate
            )
        }
        `when`(data.getMovieList()).thenReturn(movie)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.movieList()?.observeForever(observer as Observer<List<MovieEntity>>)
        verify(data).getMovieList()
    }

    @Test
    fun getWrongMovieList() {
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = MovieItemDummy.getMovieListResponse().results?.map {
            MovieEntity(
                it.id,
                it.title,
                it.overview,
                it.posterPath,
                it.releaseDate
            )
        }
        `when`(data.getMovieList()).thenReturn(movie)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.movieList()?.observeForever(observer as Observer<List<MovieEntity>>)
        verify(data).getMovieList()
        assertNotSame(movie.value, viewModel?.tvList()?.value)
    }

    @Test
    fun getTvList() {
        val tv = MutableLiveData<List<TvEntity>>()
        tv.value = TvItemDummy.getTvListResponse().results?.map {
            TvEntity(
                it.id,
                it.name,
                it.overview,
                it.posterPath,
                it.firstAirDate
            )
        }
        `when`(data.getTvList()).thenReturn(tv)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.tvList()?.observeForever(observer as Observer<List<TvEntity>>)
        verify(data).getTvList()
    }

    @Test
    fun getWrongTvList() {
        val tv = MutableLiveData<List<TvEntity>>()
        tv.value = TvItemDummy.getTvListResponse().results?.map {
            TvEntity(
                it.id,
                it.name,
                it.overview,
                it.posterPath,
                it.firstAirDate
            )
        }
        `when`(data.getTvList()).thenReturn(tv)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.tvList()?.observeForever(observer as Observer<List<TvEntity>>)
        verify(data).getTvList()
        assertNotSame(tv.value, viewModel?.movieList()?.value)
    }

}