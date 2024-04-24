package com.abulnes16.jetpack_with_gemini.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes16.jetpack_with_gemini.navigation.JetpackWithGeminiNavHost
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme

@Composable
fun JetpackWithGeminiApp(modifier: Modifier = Modifier) {
    JetpackWithGeminiTheme {
        JetpackWithGeminiNavHost(modifier)
    }
}

@Preview
@Composable
fun JetpackWithGeminiAppPreview() {
    JetpackWithGeminiApp()
}