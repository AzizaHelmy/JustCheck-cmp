package org.aziza.project.presentation.screen.sdui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Aziza Helmy on 06/07/2025.
 */
fun Context.readJsonFromAssets(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}

@Composable
fun HomeScreenSDUI() {
    // simulate loading json from server
    val elements = remember { parsedElements }
    SDUIScreen(elements)
}

@Composable
fun SDUIScreen(elements: List<ScreenElement>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        elements.forEach { element ->
            when (element.type) {
                "text" -> {
                    Text(
                        text = element.text ?: "",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                "button" -> {
                    Button(onClick = {
                        if (element.action == "log_click") {
                            println("Button clicked!")
                        }
                    }) {
                        Text(element.text ?: "Button")
                    }
                }
                else -> {
                    // fallback
                    Text("Unknown element type: ${element.type}")
                }
            }
        }
    }
}
