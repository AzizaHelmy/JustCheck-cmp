package org.aziza.project.data.mapper

import RandomUser
import org.aziza.project.domain.model.User

/**
 * Created by Aziza Helmy on 3/31/2024.
 */

fun RandomUser.toEntity(): User {
    return User(
        name = firstName ?: "",
        phone = phone ?: "",
        image = image ?: "",
    )
}

fun List<RandomUser>.toEntity() = map { it.toEntity() }
