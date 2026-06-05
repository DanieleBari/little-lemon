package com.littlelemon.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.littlelemon.littlelemon.model.UserInfo
import com.littlelemon.littlelemon.ui.theme.LLDark
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme


@Composable
fun ProfileForm(
    userInfo: UserInfo
) {
    Column{
        Text(
            text = "Personal Information",
            color = LLDark,
            style = MaterialTheme.typography.headlineMedium
        )
        ProfileInfoRow(
            value = userInfo.firstName,
            label = "First Name"
        )
        ProfileInfoRow(
            value = userInfo.lastName,
            label = "Last Name"
        )
        ProfileInfoRow(
            value = userInfo.email,
            label = "E-mail"
        )
    }
}

@Composable
private fun ProfileInfoRow(
    value: String,
    label: String
){
    Column (
        modifier = Modifier.padding(bottom = 16.dp)
    ){
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = LLDark.copy(alpha =0.7f)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = LLDark
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileFormPreview(){
    val userInfo: UserInfo = UserInfo("Pippo",
    "Pluto",
    "zio@paperone.com"
    )
    LittleLemonTheme {
        ProfileForm(userInfo)
    }
}