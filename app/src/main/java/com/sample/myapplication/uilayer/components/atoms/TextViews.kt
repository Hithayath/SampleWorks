package com.sample.myapplication.uilayer.components.atoms

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.myapplication.uilayer.theme.color_black
import com.sample.myapplication.uilayer.theme.color_grey
import com.sample.myapplication.uilayer.theme.color_white

@Composable
fun TextTitle(text: String, color: Color = color_white) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextLabel(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(2.dp),
        color = color_black,
        style = MaterialTheme.typography.caption,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextValue(text: String, color: Color = color_grey, align: TextAlign = TextAlign.Right) {
    Text(
        text = text,
        modifier = Modifier.padding(2.dp),
        color = color,
        style = MaterialTheme.typography.caption,
        fontWeight = FontWeight.Normal,
        textAlign = align
    )
}

@Preview
@Composable
private fun PreviewTextTitle() {
    TextTitle(text = "Title")
}

@Preview
@Composable
private fun PreviewTextLabel() {
    TextLabel(text = "Label")
}

@Preview
@Composable
private fun PreviewTextValue() {
    TextValue(text = "Value")
}