package org.aziza.project.presentation.screen.sdui_v2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import org.aziza.project.presentation.screen.composable.AppScaffold

@Composable
fun CoinsScreenSDUI(json: String) {
    val screen = remember(json) { parseCoinsScreen(json) }
    AppScaffold(screenTitle = screen.title) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                item {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            screen.components.forEach { component ->
                                RenderUIComponent(
                                    component = component,
                                    onNavigateToScreen = { screenId, extras ->
                                        // Handle navigation logic here
                                        // Handle navigation if needed
                                    })
                            }
                        }
                    }
                //}
            }
        }
    }
}

@Composable
fun RenderUIComponent(
    component: CoinsUiComponent,
    onNavigateToScreen: (screenId: String, extras: Map<String, String>) -> Unit = { _, _ -> }
) {
    when (component) {
        is CoinsBannerUi -> BannerCard(component)
        is CoinsGiftCardUi -> GiftCard(component)
        is CoinsExpandableUi -> ExpandableList(component)
        is CoinsProductCardUi -> ProductCard(component)
    }
}


@Composable
private fun BannerCard(component: CoinsBannerUi) {
    Card(elevation = CardDefaults.cardElevation(2.dp)) {
        Column(
            Modifier.fillMaxWidth().padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (component.imageUrl.isNotBlank()) {
                    Image(
                        painter = rememberImagePainter(component.imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .fillMaxWidth(0.1f)
                    )
                }
                Text(
                    text = component.coins.ifBlank { "0" },
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Text(
                text = component.description.ifBlank { "" },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun GiftCard(component: CoinsGiftCardUi) {
    Card(elevation = CardDefaults.cardElevation(2.dp)) {
        Row(
            Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = component.title, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
private fun ExpandableList(component: CoinsExpandableUi) {
    Card(elevation = CardDefaults.cardElevation(2.dp)) {
        Column(
            Modifier.fillMaxWidth().padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = component.headerTitle, style = MaterialTheme.typography.titleMedium)
                component.headerBadge?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            component.items.forEach { ProductCard(it) }
        }
    }
}

@Composable
private fun ProductCard(item: CoinsProductCardUi) {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = item.title, style = MaterialTheme.typography.bodyLarge)
        Text(text = item.priceRange, style = MaterialTheme.typography.bodySmall)
    }
}
