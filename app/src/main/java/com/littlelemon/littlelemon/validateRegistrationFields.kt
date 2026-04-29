package com.littlelemon.littlelemon

import com.littlelemon.littlelemon.model.UserInfo

fun validateRegistrationFields(
        userInfo: UserInfo
    ): String? {
        val isEmailValid = android.util.Patterns.EMAIL_ADDRESS
            .matcher(userInfo.email)
            .matches()

        return when {
            userInfo.firstName.isBlank() -> "First name is required"
            userInfo.lastName.isBlank() -> "Last name is required"
            userInfo.email.isBlank() -> "Email is required"
            !isEmailValid -> "Invalid email address"
            else -> null
        }
}