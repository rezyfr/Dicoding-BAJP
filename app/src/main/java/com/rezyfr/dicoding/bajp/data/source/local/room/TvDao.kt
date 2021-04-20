package com.rezyfr.dicoding.bajp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity

@Dao
interface TvDao: BaseDao<TvEntity> {
    @Query("SELECT * FROM tv ORDER BY tvTitle DESC")
    fun getTv(): DataSource.Factory<Int, TvEntity>

    @RawQuery(observedEntities = [MovieEntity::class])
    fun getFavoriteTv(query: SupportSQLiteQuery): DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tv WHERE id = :id")
    fun getTvById(id: Int): LiveData<TvEntity>
}