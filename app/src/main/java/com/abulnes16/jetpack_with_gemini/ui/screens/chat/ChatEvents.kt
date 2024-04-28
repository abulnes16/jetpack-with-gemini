package com.abulnes16.jetpack_with_gemini.ui.screens.chat

sealed class ChatEvents {
    data class OnChangePrompt(val prompt: String): ChatEvents()
    object OnSendPrompt: ChatEvents()
}