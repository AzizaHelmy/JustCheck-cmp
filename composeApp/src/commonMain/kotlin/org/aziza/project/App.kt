package org.aziza.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.aziza.project.di.initKoin
import org.aziza.project.domain.model.User
import org.aziza.project.presentation.screen.home.HomeScreen
import org.aziza.project.sdk.HomeScreenConfig
import org.aziza.project.sdk.HomeScreenEventListener

@Composable
fun App(config: HomeScreenConfig) {
    remember { initKoin() }
    MaterialTheme {
        HomeScreen(
            config = config,
            eventListener = object : HomeScreenEventListener {
                override fun onUserSelected(user: User) {}
                override fun onRetry() {}
            }
        )
    }
}
