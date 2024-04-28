package com.abulnes16.jetpack_with_gemini.ui.screens.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abulnes16.jetpack_with_gemini.data.models.Message
import com.abulnes16.jetpack_with_gemini.data.models.removePendingMessages
import com.abulnes16.jetpack_with_gemini.utils.UiEvent
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ChatViewModel(generativeModel: GenerativeModel) : ViewModel() {

    var state by mutableStateOf(
        ChatUiState()
    )
        private set

    private val chat = generativeModel.startChat()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ChatEvents) {
        when (event) {
            is ChatEvents.OnChangePrompt -> {
                state = state.copy(prompt = event.prompt)
            }

            is ChatEvents.OnSendPrompt -> {
                sendPrompt()
            }

        }
    }

    private fun addMessageToChat(username: String, content: String, isMine: Boolean, isPending: Boolean) {
        val newMessage = Message(username = username, content = content, isMine = isMine, isPending = isPending)
        val updatedList = state.messages + newMessage
        state = state.copy(messages = updatedList)
    }

    private fun sendPrompt() {

        viewModelScope.launch {
            try {
                val sendPrompt = state.prompt
                state = state.copy(prompt =  "")
                addMessageToChat(username = "Angel", content = sendPrompt, isMine =  true, isPending = true)
                state = state.copy(loading =  true)
                val response = chat.sendMessage(sendPrompt)

               response.text?.let { modelResponse ->
                   addMessageToChat(username = "Gemini", content = modelResponse, isMine = false, isPending = false)
               }
            } catch (e: Exception) {
                state = state.copy(messages = state.messages.removePendingMessages())
                _uiEvent.send(UiEvent.ShowSnackBar("We couldn't receive a response from the AI, please try again"))
            } finally {
                state = state.copy(loading = false)
            }
        }
    }


}