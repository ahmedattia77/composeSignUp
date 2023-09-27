package com.example.movies_task30.di


import com.example.compose.data.remot.ApiService
import com.example.compose.data.remot.ApiServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideApiServiceImpl (api :ApiService) = ApiServiceImp(api)
}