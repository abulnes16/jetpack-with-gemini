package com.abulnes16.jetpack_with_gemini.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abulnes16.jetpack_with_gemini.ui.screens.chat.ChatScreen
import com.abulnes16.jetpack_with_gemini.ui.screens.welcome.WelcomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetpackWithGeminiNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val snackBarState = remember {
        SnackbarHostState()
    }
    Scaffold(snackbarHost = { SnackbarHost(snackBarState) } ) {
        NavHost(navController = navController, startDestination = Welcome.route, modifier = modifier.padding(it)) {
            composable(Welcome.route) {
                WelcomeScreen(
                    onClickContinue = { navController.navigate(Chat.route) }
                )
            }

            composable(Chat.route) {
                ChatScreen(
                    snackBarHostState = snackBarState
                )
            }
        }
    }


}