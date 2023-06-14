package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.ListData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/*
class FakeListRepository: ListRepository {
    override suspend fun getListsStream(): Flow<List<ListData>> {
        return flowOf(getListData())
    }

    private fun getListData(): List<ListData> {
        val mockList = mutableListOf<ListData>()
        repeat(10) {
            mockList.add(ListData(
                id = "$it",
                firstName = "first",
                lastName = "last",
                dob = "dob - $it",
                address = "address - $it",
                contact = "contact - $it"
            ))
        }
        return mockList
    }
}*/
