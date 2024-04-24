package com.abulnes16.jetpack_with_gemini.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme

@Composable
fun Message(name: String, text: String, isMine: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalAlignment = if (isMine) Alignment.End else Alignment.Start
    ) {
        Card(
            shape = MessageCardShape(isMine),
            colors = CardDefaults.cardColors(
                containerColor = when {
                    isMine -> MaterialTheme.colorScheme.primary
                    else -> MaterialTheme.colorScheme.secondaryContainer
                }
            ),
            modifier = Modifier.widthIn(max = 340.dp)
        ) {
            Text(text = text, modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp))
        }
        Text(text = name, style = MaterialTheme.typography.bodyMedium, fontSize = 10.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MessagePreview() {
    JetpackWithGeminiTheme {
        Column {
            Message(name = "Gemini", text = "Hola desde Gemini", isMine = false)
            Message(name = "Angel", text = "Hola", isMine = true)
        }

    }

}

fun MessageCardShape(isMine: Boolean): Shape {
    val roundedCorners = RoundedCornerShape(16.dp)
    return when {
        isMine -> roundedCorners.copy(bottomEnd = CornerSize(0))
        else -> roundedCorners.copy(bottomStart = CornerSize(0))
    }
}