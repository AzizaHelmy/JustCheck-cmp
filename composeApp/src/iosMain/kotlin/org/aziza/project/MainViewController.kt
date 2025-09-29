package org.aziza.project

import androidx.compose.ui.window.ComposeUIViewController
import org.aziza.project.sdk.HomeScreenConfig

fun MainViewController(config: HomeScreenConfig) =
    ComposeUIViewController {
        App(config)
    }
