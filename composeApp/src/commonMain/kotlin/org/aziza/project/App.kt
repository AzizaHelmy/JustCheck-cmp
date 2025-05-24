package org.aziza.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.aziza.project.di.initKoin
import org.aziza.project.presentation.screen.home.HomeScreen

@Composable
fun App() {
    remember { initKoin() }
    MaterialTheme {
        HomeScreen()
    }
}
