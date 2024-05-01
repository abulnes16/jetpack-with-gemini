package com.abulnes16.jetpack_with_gemini.utils

sealed class UiEvent {
    object Success: UiEvent()
    data class ShowSnackBar(val message: String): UiEvent()
}