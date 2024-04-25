package com.abulnes16.jetpack_with_gemini.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.jetpack_with_gemini.R
import com.abulnes16.jetpack_with_gemini.ui.components.atoms.BodyText
import com.abulnes16.jetpack_with_gemini.ui.components.atoms.CustomButton
import com.abulnes16.jetpack_with_gemini.ui.components.atoms.Heading
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme
import com.abulnes16.jetpack_with_gemini.ui.theme.Spacing

@Composable
fun WelcomeScreen(onClickContinue: ()-> Unit , modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = Spacing.lg, horizontal = Spacing.xl),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Heading(text = stringResource(id = R.string.your_ai_assistant))
            Spacer(modifier = Modifier.height(Spacing.md))
            BodyText(
                text = stringResource(id = R.string.ai_assistant_subtitle),
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(Spacing.xxl))
        Image(
            painter = painterResource(id = R.drawable.welcome),
            modifier = Modifier
                .widthIn(min = 320.dp)
                .heightIn(min = 324.dp),
            contentDescription = stringResource(
                id = R.string.welcome_image_description
            )
        )
        Spacer(modifier = Modifier.height(Spacing.xxl))
        CustomButton(
            text = stringResource(id = R.string.move_on),
            onClick = onClickContinue,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    JetpackWithGeminiTheme {
        WelcomeScreen({})
    }

}

