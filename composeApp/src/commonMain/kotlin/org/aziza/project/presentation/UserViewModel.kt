package org.aziza.project.presentation

import RandomUser
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.aziza.project.data.repository.UserRepository

data class UserUiState(
    val users: List<RandomUser> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class UserViewModel(
    private val repository: UserRepository
) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    var uiState by mutableStateOf(UserUiState())
        private set

    init {
        loadUsers()
    }

    fun loadUsers() {
        coroutineScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)
            try {
                val users = repository.getUsers()
                uiState = uiState.copy(
                    users = users,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error occurred"
                )
            }
        }
    }

    fun refresh() {
        loadUsers()
    }
} 