package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.ListData
import com.sample.myapplication.datalayer.local.LocalDataSource
import com.sample.myapplication.datalayer.network.NetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject


interface DetailsRepository {
    /**
     * Gets the available list as a stream
     */
    suspend fun getDetailsStream(id: String): Flow<ListData?>
}


class DetailsRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
): DetailsRepository {

    override suspend fun getDetailsStream(id: String): Flow<ListData?> = withContext(ioDispatcher) {
        val allDetails = localDataSource.getListData()
        flow {
            emit(getDetailsData(allDetails, id))
        }
    }


    private fun getDetailsData(allDetails: List<ListData>, id: String): ListData? {
        return allDetails.find { it.id == id }
    }
}