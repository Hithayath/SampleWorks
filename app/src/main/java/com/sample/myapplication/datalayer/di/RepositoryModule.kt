package com.sample.myapplication.datalayer.di

import com.sample.myapplication.datalayer.repository.DetailsRepository
import com.sample.myapplication.datalayer.repository.DetailsRepositoryImpl
import com.sample.myapplication.datalayer.repository.ListRepository
import com.sample.myapplication.datalayer.repository.ListDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsListRepository(
        listsRepository: ListDataRepository
    ): ListRepository

    @Binds
    fun bindsDetailsRepository(
        detailsRepository: DetailsRepositoryImpl
    ): DetailsRepository
}