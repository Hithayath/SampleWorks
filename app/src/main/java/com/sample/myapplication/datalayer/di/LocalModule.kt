package com.sample.myapplication.datalayer.di

import com.sample.myapplication.datalayer.local.LocalDataSource
import com.sample.myapplication.datalayer.local.MockDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(): LocalDataSource = MockDataSource()
}