package com.sample.myapplication.datalayer.di

import com.sample.myapplication.datalayer.repository.DetailsRepository
import com.sample.myapplication.datalayer.repository.FakeDetailsRepository
import com.sample.myapplication.datalayer.repository.FakeListRepository
import com.sample.myapplication.datalayer.repository.ListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@TestInstallIn(components = [SingletonComponent::class],
    replaces = [RepositoryModule::class])
@Module
interface FakeRepositoryModule {

    @Binds
    fun bindsListRepository(
        listsRepository: FakeListRepository
    ): ListRepository

    @Binds
    fun bindDetailsRepository(
        detailsRepository: FakeDetailsRepository
    ): DetailsRepository
}