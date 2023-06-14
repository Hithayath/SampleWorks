package com.sample.myapplication.uilayer.components.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.myapplication.uilayer.components.atoms.TextLabel
import com.sample.myapplication.uilayer.components.atoms.TextValue

@Composable
fun LabelValueInfo(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(2.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Box(contentAlignment = Alignment.TopStart) {
            TextLabel(label)
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 22.dp),
            contentAlignment = Alignment.CenterEnd) {
            TextValue(text = value)
        }
    }
}



@Preview
@Composable
private fun PreviewLabelValueInfo() {
    LabelValueInfo(label = "Label", value = "Value")
}
