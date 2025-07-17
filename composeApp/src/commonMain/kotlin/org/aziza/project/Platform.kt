package org.aziza.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import io.ktor.client.engine.HttpClientEngine

interface Platform {
    val name: String
    fun logError(message: String) {}
}

expect fun getPlatform(): Platform
expect fun getEngine(): HttpClientEngine

@Composable
expect fun fontResources(font: String): Font

expect class PlatformContext

@Composable
expect fun getPlatformContext(): PlatformContext

expect fun openUrl(context: Any, url: String)


