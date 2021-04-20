package com.rezyfr.dicoding.bajp.di

import android.content.Context
import com.rezyfr.dicoding.bajp.data.source.local.room.AppDatabase
import com.rezyfr.dicoding.bajp.data.source.local.room.MovieDao
import com.rezyfr.dicoding.bajp.data.source.local.room.TvDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }


    @Provides
    @Singleton
    fun provideTvDao(appDatabase: AppDatabase): TvDao {
        return appDatabase.tvDao()
    }
}