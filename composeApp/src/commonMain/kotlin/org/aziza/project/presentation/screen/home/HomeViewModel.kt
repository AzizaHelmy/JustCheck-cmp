package org.aziza.project.presentation.screen.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.aziza.project.domain.usecase.GetAllUsersUseCase

class HomeViewModel(private val usersUseCase: GetAllUsersUseCase) {

    private val _state: MutableStateFlow<HomeUiState> by lazy { MutableStateFlow(HomeUiState()) }
    val state: StateFlow<HomeUiState> by lazy { _state.asStateFlow() }

    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    init {
        loadUsers()
    }

    fun loadUsers() {
        coroutineScope.launch {
            _state.update { it.copy(isLoading = true, isError = "") }
            try {
                val users = usersUseCase.invoke()
                _state.update {
                    it.copy(
                        users = users.toUserUiState(),
                        isLoading = false,
                        isError = "",
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = e.message ?: "Unknown error occurred"
                    )
                }
            }
        }
    }

    fun refresh() {
        loadUsers()
    }
}