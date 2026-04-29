package com.littlelemon.littlelemon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.littlelemon.littlelemon.ui.theme.LLDark
import com.littlelemon.littlelemon.ui.theme.LLYellow

@Composable
fun Home(navController: NavHostController? = null) {
//    val activity = LocalContext.current as? Activity
    Box (
        modifier = Modifier
            .fillMaxSize()
    ){
        Button(onClick = {
            navController?.navigate("profile")
        },
            modifier = Modifier.align(Alignment.Center),
            colors = ButtonDefaults.buttonColors(
                containerColor = LLYellow
            )
            ){
            Text(
                text = "Profile",
                color = LLDark,
                style = MaterialTheme.typography.bodyMedium
            )
        }
//        Button(onClick = {
//            activity?.moveTaskToBack(true)
//        },
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(bottom = 24.dp)
//            ){
//            Text(
//                text = "Exit",
//                color = LLYellow,
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
    }
}

@Composable
fun HomePreview(){
    Home()
}