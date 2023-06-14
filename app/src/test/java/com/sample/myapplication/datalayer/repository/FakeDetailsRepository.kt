package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.ListData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/*
class FakeDetailsRepository: DetailsRepository {
    override suspend fun getDetailsStream(id: String): Flow<ListData?> {
        return flowOf(allDetailsData())
    }

    private fun allDetailsData(): ListData {
        return ListData(
            id = "0",
            firstName = "First Name - 0",
            lastName = "Last Name - 0",
            dob = "Dob - 0",
            address = "Address - 0",
            contact = "Contact - 0",
        )
    }
}*/
