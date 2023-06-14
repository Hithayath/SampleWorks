package com.sample.myapplication.domainlayer

import com.sample.myapplication.datalayer.ListData
import com.sample.myapplication.datalayer.local.DetailItem
import com.sample.myapplication.datalayer.repository.DetailsRepository
import com.sample.myapplication.uilayer.PopupState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val repository: DetailsRepository
) {
    suspend fun getDetails(id: String): Flow<PopupState> {
        return repository.getDetailsStream(id).map {
            it?.let { data ->
                PopupState.Details(item = mapDetailItem(data))
            } ?: run {
                PopupState.Error(exception = Exception("Data is not available."))
            }
        }.catch {
            PopupState.Error(exception = it)
        }
    }

    private fun mapDetailItem(detailsData: ListData): DetailItem {
        return DetailItem(detailsData.id, detailsData.firstName, detailsData.lastName,
            detailsData.dob, detailsData.address, detailsData.contact)
    }
}