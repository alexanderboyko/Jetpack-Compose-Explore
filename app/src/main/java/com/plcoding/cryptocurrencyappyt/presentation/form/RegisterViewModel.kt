package com.plcoding.cryptocurrencyappyt.presentation.form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var password by mutableStateOf("")
    var email by mutableStateOf("")
    var dateOfBirth by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
}