package org.aziza.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform