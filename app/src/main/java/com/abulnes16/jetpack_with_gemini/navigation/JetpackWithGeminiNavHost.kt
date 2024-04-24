package com.abulnes16.jetpack_with_gemini.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abulnes16.jetpack_with_gemini.ui.screens.chat.ChatScreen
import com.abulnes16.jetpack_with_gemini.ui.screens.welcome.WelcomeScreen

@Composable
fun JetpackWithGeminiNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = Welcome.route, modifier = modifier) {
        composable(Welcome.route) {
            WelcomeScreen(
                onClickContinue = { navController.navigate(Chat.route) }
            )
        }

        composable(Chat.route) {
            ChatScreen()
        }
    }

}