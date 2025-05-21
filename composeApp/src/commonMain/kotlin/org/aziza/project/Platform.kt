package org.aziza.project

interface Platform {
    val name: String
    fun logError(message: String) {}
}

expect fun getPlatform(): Platform