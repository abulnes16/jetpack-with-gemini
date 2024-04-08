package com.abulnes16.jetpack_with_gemini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abulnes16.jetpack_with_gemini.ui.JetpackWithGeminiApp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           JetpackWithGeminiApp()
        }
    }
}

