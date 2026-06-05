package com.littlelemon.littlelemon

sealed class RegistrationResult {
    data class Error(val message: String) : RegistrationResult()
    data object Success : RegistrationResult()
}