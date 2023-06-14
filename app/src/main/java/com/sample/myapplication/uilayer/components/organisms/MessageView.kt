package com.sample.myapplication.uilayer.components.organisms

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.sample.myapplication.uilayer.components.molecules.DialogMessage

@Composable
fun ShowError(exception: Throwable) {
    exception.message?.let { message ->
        val(showDialog, setShowDialog) = remember {
            mutableStateOf(true)
        }
        DialogMessage(
            message = message,
            showDialog = showDialog,
            setShowDialog = setShowDialog
        )
    }
}

@Composable
fun ShowMessage(message: String, onClick: () -> Unit) {
    val(showDialog, setShowDialog) = remember {
        mutableStateOf(true)
    }
    DialogMessage(
        message = message,
        showDialog = showDialog,
        setShowDialog = setShowDialog,
        onDismiss = onClick
    )
}

@Preview
@Composable
private fun PreviewShowError() {
    ShowError(exception = Exception("Error show like this."))
}

@Preview
@Composable
private fun PreviewShowMessage() {
    ShowMessage(message = "Message show like this.", onClick = {})
}