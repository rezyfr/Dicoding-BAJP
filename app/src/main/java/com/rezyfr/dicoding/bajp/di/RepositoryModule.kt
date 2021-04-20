package com.rezyfr.dicoding.bajp.di

import com.rezyfr.dicoding.bajp.data.IMainRepository
import com.rezyfr.dicoding.bajp.data.MainRepository
import com.rezyfr.dicoding.bajp.data.source.local.LocalDataSource
import com.rezyfr.dicoding.bajp.data.source.local.room.MovieDao
import com.rezyfr.dicoding.bajp.data.source.local.room.TvDao
import com.rezyfr.dicoding.bajp.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.bajp.data.source.remote.network.ApiService
import com.rezyfr.dicoding.bajp.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun provideAppExecutors(): AppExecutors =
        AppExecutors()

    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
        RemoteDataSource(apiService)

    @Provides
    fun provideLocalDataSource(movieDao: MovieDao, tvDao: TvDao): LocalDataSource =
        LocalDataSource(movieDao, tvDao)

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        appExecutors: AppExecutors
    ): IMainRepository =
        MainRepository(remoteDataSource, localDataSource, appExecutors)

}