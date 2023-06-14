package com.sample.myapplication.domainlayer

import com.sample.myapplication.datalayer.ListData
import com.sample.myapplication.datalayer.local.ListItem
import com.sample.myapplication.datalayer.repository.ListRepository
import com.sample.myapplication.uilayer.ListUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ListUseCase @Inject constructor(
    private val repository: ListRepository
) {
    operator fun invoke(): Flow<ListUiState> {
        return repository.getListsStream().map {
            if(it.isEmpty()) {
                ListUiState.NoData
            } else {
                ListUiState.Items(list = mapListDataList(it))
            }
        }.catch {
            ListUiState.Error(exception = it)
        }
    }

    private fun mapListDataList(list: List<ListData>): List<ListItem> {
        return list.map {
            mapListItem(it)
        }
    }

    private fun mapListItem(listData: ListData): ListItem {
        return ListItem(listData.id, listData.title, listData.description)
    }
}