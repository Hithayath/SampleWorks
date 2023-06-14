package com.sample.myapplication.uilayer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.myapplication.domainlayer.DetailsUseCase
import com.sample.myapplication.domainlayer.ListUseCase
import com.sample.myapplication.uilayer.ListUiState
import com.sample.myapplication.uilayer.PopupState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val listUseCase: ListUseCase,
    private val detailsUseCase: DetailsUseCase
): ViewModel() {

    private val _listUiState = MutableStateFlow<ListUiState>(ListUiState.Initiate)
    val listUiState: StateFlow<ListUiState> = _listUiState.asStateFlow()

    private val _popupState = MutableLiveData<PopupState?>(PopupState.Initiate)
    val popupState: LiveData<PopupState?> = _popupState

    private var fetchJob: Job? = null

    fun fetchList() {
        _listUiState.value = ListUiState.Loading
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            listUseCase().collect {
                _listUiState.value = it
            }
        }
    }

    fun getDetails(id: String) {
        _popupState.value = PopupState.Initiate
        viewModelScope.launch {
            detailsUseCase(id).collect {
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