package com.sample.myapplication.datalayer.repository

import com.sample.myapplication.datalayer.DetailsData
import com.sample.myapplication.datalayer.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface DetailsRepository {
    /**
     * Gets the available list as a stream
     */
    fun getDetailsStream(id: String): Flow<DetailsData?>
}


class DetailsRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource
): DetailsRepository {
    val mockList = mutableListOf<DetailsData>()

    init {
        allDetailsData()
    }


    override fun getDetailsStream(id: String): Flow<DetailsData?> =
        flow {
            emit(getDetailsData(id))
        }

    private fun getDetailsData(id: String): DetailsData? {
        return mockList.find { it.id == id }
    }

    private fun allDetailsData() {
        repeat(10) {
            mockList.add(
                DetailsData(
                    id = "$it",
                    firstName = "First Name - $it",
                    lastName = "Last Name - $it",
                    dob = "Dob - $it",
                    address = "Address - $it",
                    contact = "Contact - $it",
                )
            )
        }
    }
}