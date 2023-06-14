package com.sample.myapplication.uilayer.components.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PopupScaffold(
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetGesturesEnabled = false,
        sheetContent = {
            val pullRefreshState = rememberPullRefreshState(false, { })
            Box(Modifier.pullRefresh(pullRefreshState)
            ) {
                sheetContent()
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        content()
    }
}