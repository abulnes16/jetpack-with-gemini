package com.abulnes16.jetpack_with_gemini.ui.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.jetpack_with_gemini.R
import com.abulnes16.jetpack_with_gemini.ui.components.atoms.Heading
import com.abulnes16.jetpack_with_gemini.ui.components.molecules.Message
import com.abulnes16.jetpack_with_gemini.ui.components.molecules.MessageInput
import com.abulnes16.jetpack_with_gemini.ui.theme.JetpackWithGeminiTheme
import com.abulnes16.jetpack_with_gemini.ui.theme.Spacing
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abulnes16.jetpack_with_gemini.ui.GenerativeViewModelFactory
import com.abulnes16.jetpack_with_gemini.utils.UiEvent
import kotlinx.coroutines.launch


@Composable
fun ChatScreen(
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    viewModel: ChatViewModel = viewModel(
        factory = GenerativeViewModelFactory
    )
) {

    val listState = rememberLazyListState()


    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(event.message)
                }

                else -> {}
            }
        }
    }


    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = Spacing.lg, horizontal = Spacing.sm),
    ) {

        LazyColumn(state = listState) {
            item {
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
            }



            items(viewModel.state.messages) {
                Message(name = it.username, text = it.content, isMine = it.isMine)
            }

            item {
                if (viewModel.state.loading) {
                    CircularProgressIndicator(modifier = Modifier.size(20.dp))
                }
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }

        }


        MessageInput(
            value = viewModel.state.prompt,
            onValueChange = { viewModel.onEvent(ChatEvents.OnChangePrompt(it)) },
            onSendMessage = {
                viewModel.onEvent(ChatEvents.OnSendPrompt)
            },
            placeholder = stringResource(
                id = R.string.ask_me_anything
            ),
            cardModifier = Modifier.align(Alignment.BottomCenter)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    val snackbarHostState = remember { SnackbarHostState() }
    JetpackWithGeminiTheme {
        ChatScreen(snackBarHostState = snackbarHostState)
    }
}