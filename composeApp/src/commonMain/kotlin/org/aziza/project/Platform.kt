package org.aziza.project

import io.ktor.client.engine.HttpClientEngine

interface Platform {
    val name: String
    fun logError(message: String) {}
}

expect fun getPlatform(): Platform
expect fun getEngine(): HttpClientEngine