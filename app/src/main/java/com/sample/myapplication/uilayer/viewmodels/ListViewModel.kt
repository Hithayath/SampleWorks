package com.sample.myapplication.uilayer.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.myapplication.domainlayer.DetailsUseCase
import com.sample.myapplication.domainlayer.ListUseCase
import com.sample.myapplication.uilayer.ListUiState
import com.sample.myapplication.uilayer.PopupState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listUseCase: ListUseCase,
    private val detailsUseCase: DetailsUseCase
): ViewModel() {

    private val _listUiState = MutableStateFlow<ListUiState>(ListUiState.Initiate)
    val listUiState: StateFlow<ListUiState> = _listUiState.asStateFlow()

    private val _popupState = MutableStateFlow<PopupState?>(PopupState.Initiate)
    val popupState: StateFlow<PopupState?> = _popupState

    private var fetchJob: Job? = null

    fun fetchList() {
        _listUiState.value = ListUiState.Loading
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            listUseCase.getList().collect {
                _listUiState.value = it
            }
        }
    }

    fun getDetails(id: String) {
        _popupState.value = PopupState.Initiate
        viewModelScope.launch {
            detailsUseCase.getDetails(id).collect {
                _popupState.value = it
            }
        }
    }

    fun resetPopupState() {
        _popupState.value = PopupState.Initiate
    }

    fun resetStates() {
        _listUiState.value = ListUiState.Initiate
        _popupState.value = PopupState.Initiate
    }
}