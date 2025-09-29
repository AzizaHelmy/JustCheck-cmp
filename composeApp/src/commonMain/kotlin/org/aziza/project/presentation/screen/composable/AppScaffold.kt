package org.aziza.project.presentation.screen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Created by Aziza Helmy on 16/07/2025.
 */

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppScaffold(
    screenTitle: String,
    onBackPressed: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        containerColor = Color(0xFFF4F4F4),
        topBar = {
            GradientTopAppBar(title = screenTitle) {
                onBackPressed()
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.TopCenter
        ) {
            content(padding)
        }
    }
}

