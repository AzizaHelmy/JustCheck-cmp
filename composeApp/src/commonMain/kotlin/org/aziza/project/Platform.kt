package org.aziza.project

import androidx.compose.runtime.Composable
import io.ktor.client.engine.HttpClientEngine

interface Platform {
    val name: String
    fun logError(message: String) {}
}

expect fun getPlatform(): Platform
expect fun getEngine(): HttpClientEngine

expect class PlatformContext

@Composable
expect fun getPlatformContext(): PlatformContext

expect fun openUrl(context: Any, url: String)


