package org.aziza.project.presentation.screen.home

import org.aziza.project.domain.model.User


data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: String = "",
    val users: List<UserUiState> = emptyList(),
)

data class UserUiState(
    val name: String,
    val phone: String,
    val image: String
)

fun List<User>.toUserUiState(): List<UserUiState> {
    return this.map {
        UserUiState(
            name = it.name,
            phone = it.phone,
            image = it.image
        )
    }
}