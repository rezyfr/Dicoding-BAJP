package com.rezyfr.dicoding.bajp.di

import com.rezyfr.dicoding.bajp.data.source.IMainRepository
import com.rezyfr.dicoding.bajp.data.source.MainRepository
import com.rezyfr.dicoding.bajp.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.bajp.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
        RemoteDataSource(apiService)

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource
    ): IMainRepository =
        MainRepository(remoteDataSource)

}