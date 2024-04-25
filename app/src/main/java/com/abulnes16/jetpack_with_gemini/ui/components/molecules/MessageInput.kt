package com.abulnes16.jetpack_with_gemini.ui.components.molecules


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.jetpack_with_gemini.R
import com.abulnes16.jetpack_with_gemini.ui.components.atoms.BodyText
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme
import com.abulnes16.jetpack_with_gemini.ui.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageInput(
    value: String,
    onValueChange: (String) -> Unit,
    onSendMessage: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    cardModifier: Modifier = Modifier,

    ) {
    Card(
        modifier = cardModifier,
        shape = RoundedCornerShape(100.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier.fillMaxWidth(0.8f),
                placeholder = {
                    BodyText(text = placeholder)
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.width(Spacing.md))
            IconButton(onClick = { onSendMessage(value) }) {
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = null,
                    tint = if (value.isBlank()) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MessageInputPreview() {
    JetpackWithGeminiTheme {
        MessageInput(
            value = "",
            onValueChange = {},
            placeholder = stringResource(id = R.string.ask_me_anything),
            onSendMessage = {}
        )
    }

}