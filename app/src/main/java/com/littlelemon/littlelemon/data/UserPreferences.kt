package com.littlelemon.littlelemon.data

import android.content.Context
import com.littlelemon.littlelemon.RegistrationResult
import com.littlelemon.littlelemon.model.UserInfo
import com.littlelemon.littlelemon.validateRegistrationFields
import androidx.core.content.edit

private const val PREFS_NAME = "LittleLemonPreferences"
private const val FIRST_NAME_KEY = "firstName"
private const val LAST_NAME_KEY = "lastName"
private const val EMAIL_KEY = "email"
private const val USER_REGISTERED = "userRegistered"


fun handleRegistration(
    context: Context,
    userInfo: UserInfo
): RegistrationResult {

    val validationError = validateRegistrationFields(
        userInfo = userInfo
    )

    if (validationError != null) {
        return RegistrationResult.Error(validationError)
    }

    saveUser(
        context = context,
        userInfo = userInfo
        )
    return RegistrationResult.Success
}

fun saveUser(
    context: Context,
    userInfo: UserInfo,
) {
    context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        .edit() {
            putString(FIRST_NAME_KEY, userInfo.firstName)
                .putString(LAST_NAME_KEY, userInfo.lastName)
                .putString(EMAIL_KEY, userInfo.email)
                .putBoolean(USER_REGISTERED, true)
                .apply()
        }
}

fun clearUser(context: Context) {
    context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        .edit() {
            clear()
                .apply()
        }
}

fun getUser(context: Context): UserInfo {
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    return UserInfo(
        firstName = prefs.getString(FIRST_NAME_KEY, "") ?: "",
        lastName = prefs.getString(LAST_NAME_KEY, "") ?: "",
        email = prefs.getString(EMAIL_KEY, "") ?: "",
    )
}

fun isUserLoggedIn(context: Context): Boolean{
    val user = getUser(context)
    return user.firstName.isNotBlank() && user.lastName.isNotBlank() && user.email.isNotBlank()
}