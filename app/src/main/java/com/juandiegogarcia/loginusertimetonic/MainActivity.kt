package com.juandiegogarcia.loginusertimetonic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juandiegogarcia.loginusertimetonic.ui.theme.LoginUserTimetonicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUserTimetonicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

//Composable function for handling navigation within the app.
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "UserScreen") {
        composable("UserScreen"){
            UserScreen {sessionKey->
                navController.navigate("BookScreen/$sessionKey")
            }
        }
        composable(route = "BookScreen/{sessionKey}"){
            val sessionKey = it.arguments?.getString("sessionKey") ?: "No name"
            BookScreen(sessionKey = sessionKey)
        }

    }
}

