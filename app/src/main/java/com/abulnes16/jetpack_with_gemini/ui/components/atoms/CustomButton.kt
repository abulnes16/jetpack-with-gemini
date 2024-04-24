package com.abulnes16.jetpack_with_gemini.ui.components.atoms

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme
import com.abulnes16.jetpack_with_gemini.ui.theme.Spacing

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    rightIcon: (@Composable () -> Unit)? = null,
) {
    Button(onClick = onClick, modifier = modifier) {
        BodyText(text = text)
        if (rightIcon !== null) {
            Spacer(modifier = Modifier.width(Spacing.md))
            rightIcon()
        }
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    JetpackWithGeminiTheme {
        CustomButton(text = "Continue", onClick = { /*TODO*/ })
    }
}

@Preview
@Composable
fun CustomButtonPreviewWithIcon() {
    JetpackWithGeminiTheme {
        CustomButton(text = "Continue", onClick = { /*TODO*/ }, rightIcon =  {
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription =  null)
        })
    }
}