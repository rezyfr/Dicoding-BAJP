package com.rezyfr.dicoding.bajp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rezyfr.dicoding.bajp.data.MainRepository
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.Resource
import com.rezyfr.dicoding.bajp.ui.detail.DetailViewModel
import com.rezyfr.dicoding.bajp.ui.utils.MovieItemDummy
import com.rezyfr.dicoding.bajp.ui.utils.TvItemDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DetailViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: DetailViewModel? = null
    private var repo = mock(MainRepository::class.java)
    private var movieDetail = MovieItemDummy.getMovieDetail()
    private var movieId = movieDetail.id
    private var tvDetail = TvItemDummy.getTvDetail()
    private var tvId = tvDetail.id

    @Before
    fun setUp(){
        viewModel = DetailViewModel(repo)
    }

    @Test
    fun getDetailMovie() {
        movieId?.let { viewModel?.setSelectedItem(it) }
        val dummyDetailMovie = Resource.success(movieDetail)
        val detailMovie = MutableLiveData<Resource<MovieEntity>>()
        detailMovie.value = dummyDetailMovie
        `when`(repo.getMovieDetail(movieId as Int)).thenReturn(detailMovie)
        val observer = mock(Observer::class.java) as Observer<in Resource<MovieEntity>>
        viewModel?.detailMovie?.observeForever(observer )
        Assert.assertEquals(dummyDetailMovie.data?.id,  viewModel?.detailMovie?.value?.data?.id)
    }

    @Test
    fun getWrongMovieDetail(){
        movieId?.let { viewModel?.setSelectedItem(it) }
        val dummyDetailMovie = Resource.success(movieDetail)
        val detailMovie = MutableLiveData<Resource<MovieEntity>>()
        detailMovie.value = dummyDetailMovie
        `when`(repo.getMovieDetail(231)).thenReturn(detailMovie)
        val observer = mock(Observer::class.java) as Observer<in Resource<MovieEntity>>
        viewModel?.detailMovie?.observeForever(observer )
        Assert.assertNotEquals(dummyDetailMovie.data?.id,  viewModel?.detailMovie?.value?.data?.id)
    }
    @Test
    fun getDetailTv() {
        tvId?.let { viewModel?.setSelectedItem(it) }
        val dummyDetailTv = Resource.success(tvDetail)
        val detailTv = MutableLiveData<Resource<TvEntity>>()
        detailTv.value = dummyDetailTv
        `when`(repo.getTvDetail(tvId as Int)).thenReturn(detailTv)
        val observer = mock(Observer::class.java) as Observer<in Resource<TvEntity>>
        viewModel?.detailTv?.observeForever(observer )
        Assert.assertNotNull(dummyDetailTv.data)
        Assert.assertEquals(dummyDetailTv.data?.id,  viewModel?.detailTv?.value?.data?.id)
    }

    @Test
    fun getWrongTvDetail(){
//        tvId?.let { viewModel?.setSelectedItem(it) }
        val dummyDetailTv = Resource.success(tvDetail)
        val detailTv = MutableLiveData<Resource<TvEntity>>()
        detailTv.value = dummyDetailTv
        `when`(repo.getTvDetail(231)).thenReturn(detailTv)
        val observer = mock(Observer::class.java) as Observer<in Resource<TvEntity>>
        viewModel?.detailTv?.observeForever(observer )
        Assert.assertNotEquals(dummyDetailTv.data?.id,  viewModel?.detailTv?.value?.data?.id)
    }

}