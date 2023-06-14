package com.sample.myapplication.uilayer.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sample.myapplication.R
import com.sample.myapplication.datalayer.local.DetailItem
import com.sample.myapplication.uilayer.components.molecules.LabelValueInfo
import com.sample.myapplication.uilayer.components.molecules.TopAppBarDetail
import com.sample.myapplication.uilayer.theme.color_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopupDetailsScreen(
    modifier: Modifier = Modifier,
    title: String,
    item: DetailItem,
    onBack: () -> Unit
) {
    val topBar: @Composable () -> Unit = {
        TopAppBarDetail(title = title, onBack = onBack)
    }

    Scaffold(
        topBar = { topBar() }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(color_white),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Spacer(modifier = modifier.height(4.dp))

                    LabelValueInfo(
                        label = stringResource(id = R.string.label_first_name),
                        value = item.firstName
                    )
                    Spacer(modifier = modifier.height(4.dp))

                    LabelValueInfo(
                        label = stringResource(id = R.string.label_last_name),
                        value = item.lastName
                    )
                    Spacer(modifier = modifier.height(4.dp))

                    LabelValueInfo(
                        label = stringResource(id = R.string.label_dob),
                        value = item.dob
                    )
                    Spacer(modifier = modifier.height(4.dp))

                    LabelValueInfo(
                        label = stringResource(id = R.string.label_address),
                        value = item.address
                    )
                    Spacer(modifier = modifier.height(4.dp))

                    LabelValueInfo(
                        label = stringResource(id = R.string.label_contact_number),
                        value = item.phone
                    )

                }
            }
        }
    }
}