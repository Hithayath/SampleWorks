package com.sample.myapplication.uilayer.components.template

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.sample.myapplication.datalayer.local.ListItem
import com.sample.myapplication.uilayer.components.organisms.CardItemView

@Composable
fun VerticalListView(modifier: Modifier = Modifier, listItems: List<ListItem>, onItemClick: (String) -> Unit) {
    LazyColumn(modifier.fillMaxSize().padding(top = 16.dp).testTag("Column Scroll")) {
        items(items = listItems) { item ->
            CardItemView(modifier, item,
                paddingValues = PaddingValues(start = 16.dp, bottom = 16.dp, end = 16.dp), onItemClick)
        }
    }
}