package com.rezyfr.dicoding.bajp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity

@Dao
interface MovieDao: BaseDao<MovieEntity> {
    @Query("SELECT * FROM movie")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>


    @Query("SELECT * FROM movie")
    fun getMovieList(): List<MovieEntity>

    @RawQuery(observedEntities = [MovieEntity::class])
    fun getFavoriteMovies(query: SupportSQLiteQuery): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>
}