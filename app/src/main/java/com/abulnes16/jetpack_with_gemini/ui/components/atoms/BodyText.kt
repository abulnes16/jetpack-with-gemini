package com.abulnes16.jetpack_with_gemini.ui.components.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme

@Composable
fun BodyText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(text = text, modifier = modifier, fontSize = fontSize, textAlign = textAlign)
}

@Preview
@Composable
fun BodyTextPreview() {
    JetpackWithGeminiTheme {
        BodyText(text = "Hello")
    }

}