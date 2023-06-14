package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.ListData
import com.sample.myapplication.datalayer.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListDataRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource
): ListRepository {

    override fun getListsStream(): Flow<List<ListData>> =
        flow {
         emit(getListData())
        }

    private fun getListData(): List<ListData> {
        val mockList = mutableListOf<ListData>()
        repeat(10) {
            mockList.add(ListData(
                id = "$it",
                title = "title - $it",
                description = "Description of data to show in the card at position - $it",
            ))
        }
        return mockList
    }
}