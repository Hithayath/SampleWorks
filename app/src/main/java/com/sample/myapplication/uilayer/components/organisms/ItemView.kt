package com.sample.myapplication.uilayer.components.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sample.myapplication.datalayer.local.ListItem
import com.sample.myapplication.uilayer.components.atoms.TextLabel
import com.sample.myapplication.uilayer.components.atoms.TextValue
import com.sample.myapplication.uilayer.theme.color_white

@Composable
fun CardItemView(modifier: Modifier, item: ListItem, paddingValues: PaddingValues,
                          onItemClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(paddingValues)
            .clickable { onItemClick(item.id) },
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(color_white),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier.padding(paddingValues)) {
            TextLabel(item.name)
            Spacer(modifier.height(8.dp))
            TextValue(item.about)
            Spacer(modifier.height(8.dp))
        }
    }
}