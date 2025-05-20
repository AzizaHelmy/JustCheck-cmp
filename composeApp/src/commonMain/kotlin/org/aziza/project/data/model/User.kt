package org.aziza.project.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: Name,
    val email: String,
    val picture: Picture
)

@Serializable
data class Name(
    val title: String,
    val first: String,
    val last: String
)

@Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

@Serializable
data class UserResponse(
    val results: List<User>
) 