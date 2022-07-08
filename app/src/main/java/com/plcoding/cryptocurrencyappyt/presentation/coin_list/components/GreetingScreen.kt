package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun GreetingScreen(onDialogVisibility: (Boolean) -> Unit) {
    Dialog(
        onDismissRequest = {
            onDialogVisibility(false)
        },
        content = {
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 32.dp
            ) {
                Box {
                    Spacer(modifier = Modifier.padding(14.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                        onClick = {
                            onDialogVisibility(false)
                        }) {
                        Text(
                            modifier = Modifier
                                .padding(10.dp), text = "Got it"
                        )
                    }
                }
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    )
}