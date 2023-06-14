package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.DetailsData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeDetailsRepository: DetailsRepository {
    override fun getDetailsStream(id: String): Flow<DetailsData?> {
        return flowOf(allDetailsData())
    }

    private fun allDetailsData(): DetailsData {
        return DetailsData(
            id = "0",
            firstName = "First Name - 0",
            lastName = "Last Name - 0",
            dob = "Dob - 0",
            address = "Address - 0",
            contact = "Contact - 0",
        )
    }
}