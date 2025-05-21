package org.aziza.project

import platform.UIKit.UIDevice
import platform.Foundation.NSLog

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    
    override fun logError(message: String) {
        NSLog("JustCheck Error: %@", message)
    }
}

actual fun getPlatform(): Platform = IOSPlatform()