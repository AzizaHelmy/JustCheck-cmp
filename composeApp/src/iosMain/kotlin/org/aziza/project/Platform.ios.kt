package org.aziza.project

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import platform.UIKit.UIDevice
import platform.Foundation.NSLog

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    
    override fun logError(message: String) {
        NSLog("JustCheck Error: %@", message)
    }
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getEngine(): HttpClientEngine = Darwin.create()
