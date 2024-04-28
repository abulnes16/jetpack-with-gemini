package com.abulnes16.jetpack_with_gemini.ui.screens.chat

import com.abulnes16.jetpack_with_gemini.data.models.Message

data class ChatUiState(
    val messages: List<Message> = mutableListOf(),
    val loading: Boolean = false,
    val prompt: String = "",
)