package org.aziza.project

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import io.ktor.client.engine.cio.CIO

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun getEngine() = CIO.create()

@SuppressLint("DiscouragedApi")
@Composable
actual fun fontResources( font: String): Font {
    val context = LocalContext.current
    val fontRes = context.resources.getIdentifier(font, "font", context.packageName)
    return Font(fontRes)
}
