package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.ListData
import com.sample.myapplication.datalayer.local.LocalDataSource
import com.sample.myapplication.datalayer.network.NetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ListRepository {
    /**
     * Gets the available list as a stream
     */
    suspend fun getListsStream(): Flow<List<ListData>>
}

class ListDataRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
): ListRepository {

    override suspend fun getListsStream(): Flow<List<ListData>> = withContext(ioDispatcher) {
        flow {
            emit(localDataSource.getListData())
        }
    }
}