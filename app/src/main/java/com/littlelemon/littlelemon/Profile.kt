package com.littlelemon.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.littlelemon.littlelemon.components.Logo
import com.littlelemon.littlelemon.data.clearUser
import com.littlelemon.littlelemon.data.getUser
import com.littlelemon.littlelemon.ui.theme.LLDark
import com.littlelemon.littlelemon.ui.theme.LLYellow
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    val context = LocalContext.current
    val userInfo = remember { getUser(context) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Logo()
        Spacer(
            modifier = Modifier
                .height(32.dp)
        )
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ProfileForm(userInfo = userInfo)
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )
                Button(
                    onClick = {
                        clearUser(context)
                        navController?.navigate("onboarding")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LLYellow
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Logout",
                        color = LLDark,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    LittleLemonTheme {
        Profile()
    }
}
