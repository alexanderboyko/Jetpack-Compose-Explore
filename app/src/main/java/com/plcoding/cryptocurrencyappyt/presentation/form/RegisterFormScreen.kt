package com.plcoding.cryptocurrencyappyt.presentation.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.cryptocurrencyappyt.R
import com.plcoding.cryptocurrencyappyt.presentation.form.components.AppTextInput

@Composable
fun RegisterFormScreen(appFormViewModel: RegisterViewModel = hiltViewModel()) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .background(color = MaterialTheme.colors.surface)
    ) {
        AppTextInput(
            text = appFormViewModel.firstName,
            placeholder = "First Name",
            keyBoardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            onChange = {
                appFormViewModel.firstName = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppTextInput(
            text = appFormViewModel.lastName,
            placeholder = "Last Name",
            keyBoardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            onChange = {
                appFormViewModel.lastName = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        var isPasswordVisible by remember { mutableStateOf(false) }
        AppTextInput(
            text = appFormViewModel.password,
            placeholder = stringResource(R.string.password),
            leadingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = stringResource(R.string.password_visibility)
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password,
            keyBoardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            onChange = {
                appFormViewModel.password = it
            }
        )
    }
}