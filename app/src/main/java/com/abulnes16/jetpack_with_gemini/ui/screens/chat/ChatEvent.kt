package com.abulnes16.jetpack_with_gemini.ui.screens.chat

sealed class ChatEvent {
    data class OnChangePrompt(val prompt: String): ChatEvent()
    object OnSendPrompt: ChatEvent()
}