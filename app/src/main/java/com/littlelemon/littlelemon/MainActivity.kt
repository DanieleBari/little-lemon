package com.littlelemon.littlelemon
import android.util.Log
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import io.ktor.http.ContentType
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import androidx.lifecycle.lifecycleScope
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                },
                contentType = ContentType.Text.Plain
            )
        }
    }

    private val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            if (database.menuItemDao().isEmpty()) {
                val menuNetwork: MenuNetwork =
                    httpClient.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
                        .body()

                val menuItemsRoom = menuNetwork.menu.map { it.toMenuItemRoom() }

                database.menuItemDao().insertAll(menuItemsRoom)
                Log.d("LITTLE_LEMON", "Items salvati nel database: ${menuItemsRoom.size}")

            }
            val items = database.menuItemDao().getAllDirect()

            Log.d("LITTLE_LEMON", "Numero items nel DB: ${items.size}")

            items.forEach {
                Log.d("LITTLE_LEMON", it.toString())
            }
        }


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
                        isUserRegistered = isUserRegistered,
                        database = database
                    )
                }
            }

        }
    }
}