@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.sample.myapplication.uilayer.components.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.sample.myapplication.R
import com.sample.myapplication.uilayer.components.atoms.TextTitle
import com.sample.myapplication.uilayer.theme.Theme
import com.sample.myapplication.uilayer.theme.color_black
import com.sample.myapplication.uilayer.theme.color_white

@Composable
fun TopAppBarMain(title: String, titleColor: Color = color_white, back: @Composable (() -> Unit) = {},
                  actions: @Composable RowScope.() -> Unit = {}) {
    CenterAlignedTopAppBar(
        title = { TextTitle(text = title, color = titleColor) },
        modifier = Modifier.testTag(title),
        navigationIcon = back,
        actions = actions,
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun TopAppBarDetail(title: String,
                    textColor: Color = color_white,
                    onBack: () -> Unit,
                    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { TextTitle(text = title, color = textColor) },
        actions = actions,
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                    contentDescription = "Back Navigation", tint = textColor
                )
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

@Preview
@Composable
private fun PreviewTopAppBarMain() {
    Theme {
        TopAppBarMain(title = "Main")
    }
}

@Preview
@Composable
private fun PreviewTopAppBarDetail() {
    Theme {
        TopAppBarDetail(title = "Details", onBack = {})
    }
}
