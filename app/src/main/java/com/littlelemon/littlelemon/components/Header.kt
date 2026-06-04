package com.littlelemon.littlelemon.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Header(navController: NavHostController? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Logo(
            modifier = Modifier
                .height(80.dp)
                .width(220.dp)
                .align(Alignment.Center)
        )

        ProfileIcon(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            onClick = {
                navController?.navigate("profile")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview(){
    Header()
}