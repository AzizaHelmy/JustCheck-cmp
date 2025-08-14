package org.aziza.project.presentation.screen.sdui_v2

import Colors
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import justcheck_cmp.composeapp.generated.resources.Res
import justcheck_cmp.composeapp.generated.resources.ic_arrow_down
import justcheck_cmp.composeapp.generated.resources.ic_arrow_right_black
import justcheck_cmp.composeapp.generated.resources.ic_arrow_up
import justcheck_cmp.composeapp.generated.resources.ic_coins
import justcheck_cmp.composeapp.generated.resources.ic_gift_box
import justcheck_cmp.composeapp.generated.resources.ic_info
import org.aziza.project.getPlatformContext
import org.aziza.project.openUrl
import org.aziza.project.presentation.screen.composable.AppScaffold
import org.aziza.project.presentation.screen.sdui.ActionType
import org.aziza.project.presentation.theme.FieldStyles
import org.aziza.project.presentation.theme.HeadingStyles
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun CoinsScreenSDUI(json: String) {
    val screen = remember(json) { parseCoinsScreen(json) }

    AppScaffold(screenTitle = screen.title) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        screen.components.forEach { component ->
                            RenderUIComponent(component = component)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RenderUIComponent(component: CoinsUiComponent) {
    when (component) {
        is CoinsBannerUi -> CardBannerCoins(component)
        is CoinsGiftCardUi -> CardMyGifts(component)
        is CoinsExpandableUi -> ExpandableList(component)
        is CoinsProductCardUi -> ProductCard(component)
    }
}


@Composable
private fun CardBannerCoins(component: CoinsBannerUi) {
    val context = getPlatformContext()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF000000), Color(0xFF9C1301))
                    )
                )
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "History",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                )
                IconButton(
                    onClick = { component.action?.let { handleAction(context, it) } },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_info),
                        contentDescription = "Info",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-6).dp), // small lift to connect with row
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_coins),
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp),
                        contentScale = ContentScale.Fit
                    )

                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = component.coins.ifBlank { "0" },
                        style = MaterialTheme.typography.headlineMedium.copy(color = Color.White)
                    )
                }
            }
            Text(
                text = component.description.ifBlank { "The more coins you win, the bigger the gift will be!" },
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
        }
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
private fun CardMyGifts(component: CoinsGiftCardUi) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.ic_gift_box),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = component.title,
                style = HeadingStyles.head4Bold(),
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_right_black),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ExpandableList(component: CoinsExpandableUi) {
    var expanded by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .animateContentSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .noRippleClickable { expanded = !expanded }
                    .padding(bottom = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = component.headerTitle, style = HeadingStyles.head5Bold())
                Spacer(modifier = Modifier.weight(1f))

                component.headerBadge?.let {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.Black, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            maxLines = 1
                        )
                    }
                }
                Icon(
                    painter = if (expanded) painterResource(Res.drawable.ic_arrow_up) else painterResource(
                        Res.drawable.ic_arrow_down
                    ),
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }

            if (expanded) {
                val spacing = 8.dp
                val columns = 3

                FlowRow(
                    maxItemsInEachRow = columns,
                    horizontalArrangement = Arrangement.spacedBy(spacing),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    var parentWidthPx by remember { mutableStateOf(0) }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned {
                                parentWidthPx = it.size.width
                            }) {}

                    val cellWidth = with(LocalDensity.current) {
                        ((parentWidthPx / columns) - spacing.toPx() * (columns - 1) / columns).toDp()
                    }
                    component.items.forEach { product ->
                        ProductCard(
                            product,
                            modifier = Modifier
                                .width(cellWidth)
                        )
                    }
                }
                /* LazyVerticalGrid(
                     columns = GridCells.Fixed(3),
                     verticalArrangement = Arrangement.spacedBy(12.dp),
                     horizontalArrangement = Arrangement.spacedBy(8.dp),
                     modifier = Modifier
                         .fillMaxWidth()
                         .heightIn(max = 9999.dp),
                     userScrollEnabled = false
                 ) {
                     items(component.items) { product ->
                         ProductCard(product)
                     }
                 }*/
            }
        }
    }
}


@Composable
private fun ProductCard(
    item: CoinsProductCardUi, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        //.fillMaxWidth()
        //.wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = Colors().naturalColor.naturalGrayBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp).height(140.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(item.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(50.dp)
            )

            Text(
                text = item.title,
                style = FieldStyles.mediumRegular(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(24.dp))
                    .clickable { /* action */ },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        tint = Color.Unspecified,
                        painter = painterResource(Res.drawable.ic_coins),
                        contentDescription = null
                    )
                    Text(
                        text = item.priceRange,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

        }
    }
}

fun handleAction(
    context: Any,
    action: ViewAction,
    onNavigateToScreen: (screenId: String, extras: Map<String, String>) -> Unit = { _, _ -> }
) {
    when (ActionType.from(action.actionType)) {
        ActionType.LINK -> {
            val url = action.link
            if (!url.isNullOrBlank()) {
                openUrl(context, url)
            }
        }

        ActionType.SCREEN_ID -> {
            val screenId = action.screenId
            val extras = action.parameters ?: emptyMap()
            if (!screenId.isNullOrBlank()) {
                onNavigateToScreen(screenId, extras)
            }
        }

        ActionType.API -> {
            val params = action.parameters ?: emptyMap()
            // callSubmitApi(params)
        }

        null -> {
            println("Unknown action type: ${action.actionType}")
        }
    }
}

/**
 * Helper to make clickable without ripple or shadow
 */
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) { onClick() }
}


