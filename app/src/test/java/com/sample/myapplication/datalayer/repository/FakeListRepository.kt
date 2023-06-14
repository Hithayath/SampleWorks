package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.ListData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeListRepository: ListRepository {
    override fun getListsStream(): Flow<List<ListData>> {
        return flowOf(getListData())
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