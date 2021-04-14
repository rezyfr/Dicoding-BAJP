package com.rezyfr.dicoding.bajp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.rezyfr.dicoding.bajp.data.source.MainRepository
import com.rezyfr.dicoding.bajp.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.bajp.ui.utils.LiveDataTestUtil
import com.rezyfr.dicoding.bajp.ui.utils.MovieItemDummy
import com.rezyfr.dicoding.bajp.ui.utils.TvItemDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class MainRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val mainRepository = MainRepository(remote)

    private val movieListResponse = MovieItemDummy.getMovieListResponse()
    private val movieId = MovieItemDummy.getMovieListResponse().results?.get(0)?.id ?: 791373 //first item id
    private val movieDetail = MovieItemDummy.getMovieDetail()

    private val tvListResponse = TvItemDummy.getTvListResponse()
    private val tvId = TvItemDummy.getTvListResponse().results?.get(0)?.id ?: 2558742 //first item id
    private val tvDetail = TvItemDummy.getTvDetail()

    @Test
    fun getMovieList() {
        doAnswer { invocation ->
            movieListResponse.results?.let {
                (invocation.arguments[0] as RemoteDataSource.GetMovieListCallback)
                    .onResponse(it)
            }
            null
        }.`when`(remote).getMovieList(any())
        val movieEntities = LiveDataTestUtil.getValue(mainRepository.getMovieList())
        verify(remote).getMovieList(any())
        assertNotNull(movieEntities)
        assertEquals(movieListResponse.results?.size?.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getTvList() {
        doAnswer { invocation ->
            tvListResponse.results?.let {
                (invocation.arguments[0] as RemoteDataSource.GetTvListCallback)
                    .onResponse(it)
            }
            null
        }.`when`(remote).getTvList(any())
        val tvEntities = LiveDataTestUtil.getValue(mainRepository.getTvList())
        verify(remote).getTvList(any())
        assertNotNull(tvEntities)
        assertEquals(tvListResponse.results?.get(0)?.id, tvEntities[0].id)
    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            movieDetail.let {
                (invocation.arguments[0] as RemoteDataSource.GetMovieDetailCallback)
                    .onResponse(it)
            }
            null
        }.`when`(remote).getMovieDetail(any(), eq(movieId ))
        val movieEntity = LiveDataTestUtil.getValue(mainRepository.getMovieDetail(movieId))
        verify(remote).getMovieDetail(any(), anyInt())
        assertNotNull(movieEntity)
        assertEquals(movieDetail.id, movieEntity.id)
    }

    @Test
    fun getTvDetail() {
        doAnswer { invocation ->
            tvDetail.let {
                (invocation.arguments[0] as RemoteDataSource.GetTvDetailCallback)
                    .onResponse(it)
            }
            null
        }.`when`(remote).getTvDetail(any(), eq(tvId ))
        val tvEntity = LiveDataTestUtil.getValue(mainRepository.getTvDetail(tvId))
        verify(remote).getTvDetail(any(), anyInt())
        assertNotNull(tvEntity)
        assertEquals(tvDetail.id, tvEntity.id)
    }

}