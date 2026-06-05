package com.littlelemon.littlelemon

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.littlelemon.littlelemon.components.Logo
import com.littlelemon.littlelemon.data.handleRegistration
import com.littlelemon.littlelemon.model.UserInfo
import com.littlelemon.littlelemon.ui.theme.LLDark
import com.littlelemon.littlelemon.ui.theme.LLGreen
import com.littlelemon.littlelemon.ui.theme.LLYellow
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Onboarding(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
)
{
    val context = LocalContext.current
    var userInfo by remember { mutableStateOf(
        UserInfo(
            firstName = "",
            lastName = "",
            email = ""
        )
    )
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Logo(
            modifier = Modifier
                .height(80.dp)
                .width(220.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(LLGreen)
                .padding(horizontal = 24.dp, vertical = 28.dp)
        ){
            Text(
                text = "Let's get to know you",
                style = MaterialTheme.typography.headlineMedium,
                color = LLYellow
            )
        }
        Spacer(
            modifier = Modifier
                .height(32.dp)
        )
        Column {


            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                OnBoardingForm(userInfo = userInfo, onUserInfoChange = { userInfo = it})
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )
                Button(
                    onClick = {
                        when (val result = handleRegistration(
                            context = context,
                            userInfo = userInfo
                        )) {

                            is RegistrationResult.Error -> {
                                Toast.makeText(
                                    context,
                                    result.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            RegistrationResult.Success -> {
                                Toast.makeText(
                                    context,
                                    "Registration successful",
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController?.navigate(HomeDestination.route) {
                                    popUpTo("onboarding") {
                                        inclusive = true
                                    }
                                }
                            }
                        }
                    }
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LLYellow
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Register",
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
fun OnboardingPreview(){
    LittleLemonTheme {
        Onboarding()
    }
}
