package org.aziza.project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.core.net.toUri
import io.ktor.client.engine.cio.CIO

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun getEngine() = CIO.create()

@SuppressLint("DiscouragedApi")
@Composable
actual fun fontResources(font: String): Font {
    val context = LocalContext.current
    val fontRes = context.resources.getIdentifier(font, "font", context.packageName)
    return Font(fontRes)
}

actual class PlatformContext(val androidContext: Context)

@Composable
actual fun getPlatformContext() = PlatformContext(LocalContext.current)

actual fun openUrl(context: Any, url: String) {
    try {
        val ctx = (context as? PlatformContext)?.androidContext
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = if (!url.startsWith("http://") && !url.startsWith("https://")) {
                "http://$url".toUri()
            } else {
                url.toUri()
            }
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        ctx?.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        (context as? PlatformContext)?.androidContext?.let {
            Toast.makeText(it, "unable to open webpage", Toast.LENGTH_SHORT).show()
        }
    }
}


