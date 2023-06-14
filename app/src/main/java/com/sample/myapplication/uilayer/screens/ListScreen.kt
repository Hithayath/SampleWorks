@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class
)

package com.sample.myapplication.uilayer.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sample.myapplication.R
import com.sample.myapplication.uilayer.ListUiState
import com.sample.myapplication.uilayer.PopupState
import com.sample.myapplication.uilayer.components.atoms.ShowProgress
import com.sample.myapplication.uilayer.components.molecules.TopAppBarMain
import com.sample.myapplication.uilayer.components.organisms.PopupScaffold
import com.sample.myapplication.uilayer.components.organisms.ShowError
import com.sample.myapplication.uilayer.components.organisms.ShowMessage
import com.sample.myapplication.uilayer.components.template.VerticalListView
import com.sample.myapplication.uilayer.viewmodels.ListViewModel
import kotlinx.coroutines.launch

private fun loadLists(viewModel: ListViewModel
) {
    viewModel.fetchList()
}

@Composable
fun ListScreen(onBack: () -> Unit = {},
               viewModel: ListViewModel = hiltViewModel()) {
    viewModel.resetStates()
    loadLists(viewModel = viewModel)

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    var sheetState by remember { mutableStateOf(false) } // Bug: Bottom sheet weird behaviour with initial expanded state

    val closeSheet: () -> Unit = {
        viewModel.resetPopupState()
        coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.collapse() }
        sheetState = false
    }
    val openSheet: () -> Unit = {
        coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.expand() }
        sheetState = true
    }
    BackHandler {
        if(sheetState && bottomSheetScaffoldState.bottomSheetState.isExpanded) {
            closeSheet()
        } else {
            onBack()
        }
    }

    PopupScaffold(
        sheetContent = {
            val popupState by viewModel.popupState.collectAsState()
            PopupContentState(
                state = popupState,
                onBack = { closeSheet() },
                openSheet = openSheet)
        },
        content = {
            ListsContent(viewModel = viewModel,
                onListItemClick = {
                    viewModel.getDetails(it)
                },
                onBack = onBack
            )
        },
        bottomSheetScaffoldState = bottomSheetScaffoldState
    )
}

@Composable
private fun PopupContentState(state: PopupState?,
                              onBack: () -> Unit,
                              openSheet: () -> Unit
) {
    if (state is PopupState.Details) {
        PopupDetailsScreen(
            title = stringResource(id = R.string.user_details),
            item = state.item,
            onBack = onBack
        )
        openSheet()
    }
}

@Composable
private fun ListsContent(viewModel: ListViewModel,
                          onListItemClick: (String) -> Unit,
                          onBack: () -> Unit
) {
    val topBar : @Composable () -> Unit = {
        TopAppBarMain("List View", back = { onBack() })
    }

    Scaffold(
        topBar = { topBar() }
    ) { innerPadding ->
        Surface(
            Modifier.fillMaxSize()
                .padding(innerPadding)
        ) {
            val state by viewModel.listUiState.collectAsState()
            ListsState(state, onListItemClick)
        }
    }
}

@Composable
private fun ListsState(
    state: ListUiState?,
    onItemClick: (String) -> Unit,
) {
    when(state) {
        is ListUiState.Loading -> ShowProgress()
        is ListUiState.Items -> VerticalListView(listItems = state.list, onItemClick = onItemClick)
        is ListUiState.Error -> ShowError(state.exception)
        is ListUiState.NoData -> ShowMessage(stringResource(R.string.no_data), onClick = {})
        is ListUiState.NoInternet -> ShowMessage(stringResource(R.string.no_internet), onClick = {})
        else -> { /* Do nothing */ }
    }
}