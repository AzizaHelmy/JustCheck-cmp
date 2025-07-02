package org.aziza.project.sdk

import org.aziza.project.domain.model.User

interface HomeScreenEventListener {
    fun onUserSelected(user: User)
    fun onRetry()
}
