package com.littlelemon.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                val sharedPreferences = getSharedPreferences(
                    "LittleLemonPreferences",
                    MODE_PRIVATE
                )
                val isUserRegistered = sharedPreferences.getBoolean(
                    "userRegistered",
                    false
                )
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {padding ->
                    NavigationComposable(
                        navController = navController,
                        modifier = Modifier.padding(padding),
                        isUserRegistered
                    )
                }
            }

        }
    }
}