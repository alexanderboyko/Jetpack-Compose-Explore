package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.R
import com.plcoding.cryptocurrencyappyt.presentation.Screen

@Composable
fun GreetingsDialog(
    navController: NavController,
    onDialogVisibility: (Boolean) -> Unit
) {
    Dialog(
        onDismissRequest = {
            onDialogVisibility(false)
        },
        content = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f),
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 32.dp
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        fontSize = TextUnit.Unspecified,
                        fontWeight = FontWeight.Medium,
                        text = stringResource(R.string.greetings),
                        color = MaterialTheme.colors.onSurface
                    )
                    Spacer(modifier = Modifier.padding(32.dp))
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        items((1 until 100).toList()) { text ->
                            Card(
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(40.dp)
                            ) {
                                Text(text = text.toString())
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(32.dp))
                    Row {
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

                        Spacer(modifier = Modifier.width(32.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                            onClick = {
                                onDialogVisibility(false)
                                navController.navigate(Screen.RegisterScreen.route)
                            }) {
                            Text(
                                modifier = Modifier
                                    .padding(10.dp), text = "Register"
                            )
                        }
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