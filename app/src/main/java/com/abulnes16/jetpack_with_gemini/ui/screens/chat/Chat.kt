package com.abulnes16.jetpack_with_gemini.ui.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.jetpack_with_gemini.R
import com.abulnes16.jetpack_with_gemini.data.models.mockMessages
import com.abulnes16.jetpack_with_gemini.ui.components.atoms.Heading
import com.abulnes16.jetpack_with_gemini.ui.components.molecules.Message
import com.abulnes16.jetpack_with_gemini.ui.components.molecules.MessageInput
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme
import com.abulnes16.jetpack_with_gemini.ui.theme.Spacing

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = Spacing.lg, horizontal = Spacing.sm),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {
            Heading(text = "Gemini")
            Spacer(modifier = Modifier.width(Spacing.md))
            Image(
                painter = painterResource(id = R.drawable.google_gemini_icon),
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )
        }
        LazyColumn() {
            items(mockMessages) {
                Message(name = it.username, text = it.content, isMine = it.isMine)
            }
        }
        MessageInput(
            value = "",
            onValueChange = {},
            onSendMessage = {},
            placeholder = stringResource(
                id = R.string.ask_me_anything
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    JetpackWithGeminiTheme {
        ChatScreen()
    }
}