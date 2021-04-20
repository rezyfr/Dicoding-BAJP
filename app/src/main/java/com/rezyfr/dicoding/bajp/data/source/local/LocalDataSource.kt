package com.rezyfr.dicoding.bajp.data.source.local

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.local.room.MovieDao
import com.rezyfr.dicoding.bajp.data.source.local.room.TvDao
import com.rezyfr.dicoding.bajp.data.source.utils.SortUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao, private val tvDao: TvDao) {

    fun getMovies(): DataSource.Factory<Int, MovieEntity>{
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("LocalDataSource: ", "${movieDao.getMovieList().size}")
        }
        return movieDao.getMovies()
    }

    fun getDetailMovie(movieId: Int): LiveData<MovieEntity> =
        movieDao.getMovieById(movieId)

    fun getFavoriteMovies(sort: String): DataSource.Factory<Int, MovieEntity> {
        val query = SortUtils.getMoviesSortedQuery(sort)
        return movieDao.getFavoriteMovies(query)
    }

    fun insertMovies(movies: List<MovieEntity>) = movieDao.insertAll(movies)

    fun insertMovie(movie: MovieEntity) = movieDao.insert(movie)

    fun setMovieFavorite(movie: MovieEntity, isFavorite: Boolean) {
        movie.isFavorite = isFavorite
        movieDao.update(movie)
    }

    fun getTvList(): DataSource.Factory<Int, TvEntity> = tvDao.getTv()

    fun getFavoriteTvs(sort: String): DataSource.Factory<Int, TvEntity> {
        val query = SortUtils.getTvShowsSortedQuery(sort)
        return tvDao.getFavoriteTv(query)
    }

    fun getTvDetail(id: Int): LiveData<TvEntity> =
        tvDao.getTvById(id)

    fun insertTvs(tvShows: List<TvEntity>) = tvDao.insertAll(tvShows)

    fun insertTv(tv: TvEntity) =
        tvDao.insert(tv)

    fun setTvFavorite(tv: TvEntity, isFavorite: Boolean) {
        tv.isFavorite = isFavorite
        tvDao.update(tv)
    }
}