package com.sample.myapplication.uilayer

import com.sample.myapplication.datalayer.local.DetailItem
import com.sample.myapplication.datalayer.local.ListItem

sealed class ListUiState {
    object Initiate : ListUiState()
    object Loading : ListUiState()
    data class Items(val list: List<ListItem>): ListUiState()

    data class Error(val exception: Throwable): ListUiState()
    object NoData: ListUiState()
    object NoInternet: ListUiState()
}

sealed class PopupState {
    object Initiate : PopupState()
    object Loading : PopupState()
    data class Details(val item: DetailItem): PopupState()

    data class Error(val exception: Throwable): PopupState()
}