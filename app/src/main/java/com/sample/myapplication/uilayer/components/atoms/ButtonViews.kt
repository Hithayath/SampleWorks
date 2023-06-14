package com.sample.myapplication.uilayer.components.atoms

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonDialog(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(onClick = onClick,
        modifier = modifier
            .wrapContentSize()
            .semantics {
                contentDescription = "Button"
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        TextValue(text)
    }
}

@Preview
@Composable
private fun PreviewButtonDialog() {
    ButtonDialog(text = "Button", onClick = {})
}