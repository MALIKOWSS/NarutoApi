package com.example.rickandmortyapi.di.network

import com.example.narutoapi.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiService() = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideCharacterApiService()
}