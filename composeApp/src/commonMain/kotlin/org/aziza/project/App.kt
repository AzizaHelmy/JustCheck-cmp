package org.aziza.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.aziza.project.di.initKoin
import org.aziza.project.presentation.screen.home.HomeScreen
import org.aziza.project.sdk.HomeScreenConfig

@Composable
fun App(config: HomeScreenConfig) {
    remember { initKoin() }
    MaterialTheme {


        HomeScreen(
            config = config
        )


    }
}
