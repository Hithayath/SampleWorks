package com.sample.myapplication.datalayer.di

import com.sample.myapplication.datalayer.network.NetworkDataSource
import com.sample.myapplication.datalayer.network.retrofit.RetrofitNetwork
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
    fun provideRetrofit(): NetworkDataSource = RetrofitNetwork()
}