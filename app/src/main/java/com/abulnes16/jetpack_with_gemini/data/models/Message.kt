package com.abulnes16.jetpack_with_gemini.data.models

data class Message(
    val content: String,
    val username: String = "",
    val isMine: Boolean = true
)

val mockMessages = listOf<Message>(
    Message(content = "Hola", username = "Angel", isMine = true),
    Message(content = "Hola como estas?", username = "Gemini", isMine = false),
    Message(content = "Todo bien, aprendiendo Gemini", username = "Angel", isMine = true),
    Message(content = "Que bueno, estoy para ayudarte", username = "Gemini", isMine = false),
    Message(content = "Aprendamos pues", username = "Angel", isMine = true),
    Message(content = "Si asi es", username = "Gemini", isMine = false),
)
