package com.sample.myapplication.uilayer.components.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sample.myapplication.R
import com.sample.myapplication.uilayer.components.atoms.ButtonDialog
import com.sample.myapplication.uilayer.components.atoms.TextTitle
import com.sample.myapplication.uilayer.theme.color_black

@Composable
fun DialogMessage(message: String, showDialog: Boolean,
                  setShowDialog: (Boolean) -> Unit, onDismiss: () -> Unit = {}) {
    if (showDialog) {
        AlertDialog(
            modifier = Modifier
                .wrapContentSize(),
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                setShowDialog(false)
                onDismiss()
            },
            title = {
                TextTitle(text = message, color = color_black)
            },
            confirmButton = {
                ButtonDialog(text = stringResource(id = R.string.ok), onClick = {
                    setShowDialog(false)
                    onDismiss()
                })
            }
        )
    }
}