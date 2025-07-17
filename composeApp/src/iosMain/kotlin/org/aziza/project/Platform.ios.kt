package org.aziza.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.platform.Font
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource
import platform.Foundation.NSLog
import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIDevice
import platform.UIKit.UIViewController
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

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

actual class PlatformContext(val iosController: ProvidableCompositionLocal<UIViewController>)

@Composable
actual fun getPlatformContext(): PlatformContext = PlatformContext(LocalUIViewController)

actual fun openUrl(context: Any, url: String) {
    val finalUrl = if (!url.startsWith("http://") && !url.startsWith("https://")) {
        "http://$url"
    } else {
        url
    }

    val nsUrl = NSURL.URLWithString(finalUrl)
    if (nsUrl != null) {
        dispatch_async(dispatch_get_main_queue()) {
            UIApplication.sharedApplication.openURL(nsUrl)
        }
    } else {
        println("Unable to open URL: invalid format")
    }
}


