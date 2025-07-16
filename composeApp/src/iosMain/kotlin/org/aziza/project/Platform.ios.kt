package org.aziza.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.platform.Font
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource
import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import kotlin.collections.getOrPut


class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    
    override fun logError(message: String) {
        NSLog("JustCheck Error: %@", message)
    }
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getEngine(): HttpClientEngine = Darwin.create()

@OptIn(ExperimentalResourceApi::class)
@Composable

actual fun fontResources(font: String): Font {
    val cache: MutableMap<String, Font> = mutableMapOf()
    return cache.getOrPut(font) {
        val byteArray = runBlocking {
            resource("font/$font.ttf").readBytes()
        }
        Font(font, byteArray)
    }
}

