package com.abulnes16.jetpack_with_gemini.ui.components.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme

@Composable
fun Heading(text: String, modifier: Modifier = Modifier, fontSize: TextUnit = 23.sp) {
    Text(
        text = text,
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize
    )
}

@Preview(showBackground = true)
@Composable
fun HeadingPreview() {
    JetpackWithGeminiTheme {
        Heading(text = "Your AI Assistant")
    }

}