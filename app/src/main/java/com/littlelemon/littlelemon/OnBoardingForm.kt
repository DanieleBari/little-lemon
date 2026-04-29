package com.littlelemon.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.littlelemon.littlelemon.model.UserInfo
import com.littlelemon.littlelemon.ui.theme.LLDark
import com.littlelemon.littlelemon.ui.theme.LLGreen
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun OnBoardingForm(
    userInfo: UserInfo,
    onUserInfoChange: (UserInfo) -> Unit
)
{
    Column{
        Text(
            text = "Personal Information",
            color = LLDark,
            style = MaterialTheme.typography.headlineMedium
        )
        OnBoardingTextField(
            value = userInfo.firstName,
            onValueChange = { onUserInfoChange(userInfo.copy(firstName = it)) },
            label = "First Name",
            placeholder = "John"
        )
        OnBoardingTextField(
            value = userInfo.lastName,
            onValueChange = { onUserInfoChange(userInfo.copy(lastName = it)) },
            label = "Last Name",
            placeholder = "Doe"
        )
        OnBoardingTextField(
            value = userInfo.email,
            onValueChange = { onUserInfoChange(userInfo.copy(email = it)) },
            label = "E-mail",
            placeholder = "E-mail"
        )
    }
}

@Composable
private fun OnBoardingTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String
){
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = LLDark
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodyMedium)
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LLGreen,
                unfocusedBorderColor = LLDark.copy(alpha = 0.4f),
                cursorColor = LLGreen
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
fun OnBoardingFilledFormPreview() {
    LittleLemonTheme {
        OnBoardingForm(
            userInfo = UserInfo(
                firstName = "John",
                lastName = "Doe",
                email = "pippo@pluto.com"
            ),
            onUserInfoChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingEmptyFormPreview() {
    LittleLemonTheme {
        OnBoardingForm(
            userInfo = UserInfo(
                firstName = "",
                lastName = "",
                email = ""
            ),
            onUserInfoChange = {}
        )
    }
}