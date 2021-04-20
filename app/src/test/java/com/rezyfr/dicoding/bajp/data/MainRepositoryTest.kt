package com.rezyfr.dicoding.bajp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.rezyfr.dicoding.bajp.data.source.local.LocalDataSource
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.bajp.data.source.utils.Resource
import com.rezyfr.dicoding.bajp.ui.utils.LiveDataTestUtil
import com.rezyfr.dicoding.bajp.ui.utils.MovieItemDummy
import com.rezyfr.dicoding.bajp.ui.utils.PagedListUtil
import com.rezyfr.dicoding.bajp.ui.utils.TvItemDummy
import com.rezyfr.dicoding.bajp.utils.AppExecutors
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class MainRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val executors = mock(AppExecutors::class.java)
    private val mainRepository = FakeMainRepository(remote, local, executors)

    private val movieListResponse = MovieItemDummy.getMovieListResponse()
    private val movieId = movieListResponse[0].id ?: 791373 //first item id
    private val movieDetail = MovieItemDummy.getMovieDetail()

    private val tvListResponse = TvItemDummy.getTvListResponse()
    private val tvId = tvListResponse[0].id ?: 2558742 //first item id
    private val tvDetail = TvItemDummy.getTvDetail()

    @Test
    fun getMovieList() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`((local).getMovies()).thenReturn(dataSourceFactory)
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(MovieItemDummy.getMovieListResponse()))
        assertNotNull(movieEntities)
        assertEquals(movieListResponse.size, movieEntities.data?.size)
    }

    @Test
    fun getTvList() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`((local).getTvList()).thenReturn(dataSourceFactory)
        val tvEntities = Resource.success(PagedListUtil.mockPagedList(TvItemDummy.getTvListResponse()))
        assertNotNull(tvEntities)
        assertEquals(tvListResponse.size, tvEntities.data?.size)
    }

    @Test
    fun getMovieDetail() {
        val movieEntity = MutableLiveData<MovieEntity>()
        movieEntity.value = MovieItemDummy.getMovieDetail()
        `when`(local.getDetailMovie(movieId)).thenReturn(movieEntity)
        val detailMovie = LiveDataTestUtil.getValue(mainRepository.getMovieDetail(movieId))
        assertNotNull(movieEntity)
        assertEquals(movieDetail.id, detailMovie.data?.id)
    }

    @Test
    fun getTvDetail() {
        val tvEntity = MutableLiveData<TvEntity>()
        tvEntity.value = TvItemDummy.getTvDetail()
        `when`(local.getTvDetail(tvId)).thenReturn(tvEntity)
        val detailTv = LiveDataTestUtil.getValue(mainRepository.getTvDetail(tvId))
        assertNotNull(tvEntity)
        assertEquals(tvDetail.id, detailTv.data?.id)
    }

}