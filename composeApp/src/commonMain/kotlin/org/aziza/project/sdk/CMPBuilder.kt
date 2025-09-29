package org.aziza.project.sdk

import org.aziza.project.domain.model.User

/**
 * Created by Aziza Helmy on 2/22/2025.
 */

data class HomeScreenConfig(
    val screenTitle: String,
    val language: String = "ar",
    val initialData: List<User> = emptyList()
)
