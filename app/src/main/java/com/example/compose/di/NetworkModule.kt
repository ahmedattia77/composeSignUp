package com.example.compose.di


import com.example.compose.data.remot.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAppApiService()
            = Retrofit.Builder().baseUrl("https://insta-integration.appssquare.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Provides
    fun provideApiService (retrofit: Retrofit)
            = retrofit.create(ApiService::class.java)

}