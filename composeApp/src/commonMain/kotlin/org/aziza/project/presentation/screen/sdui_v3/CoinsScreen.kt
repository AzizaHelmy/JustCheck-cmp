package org.aziza.project.presentation.screen.sdui_v3

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import justcheck_cmp.composeapp.generated.resources.Res
import justcheck_cmp.composeapp.generated.resources.ic_arrow_down
import justcheck_cmp.composeapp.generated.resources.ic_arrow_right_black
import justcheck_cmp.composeapp.generated.resources.ic_arrow_up
import justcheck_cmp.composeapp.generated.resources.ic_coins
import justcheck_cmp.composeapp.generated.resources.ic_info
import kotlinx.serialization.json.Json
import org.aziza.project.presentation.screen.composable.AppScaffold
import org.aziza.project.presentation.screen.sdui_v2.Category
import org.aziza.project.presentation.screen.sdui_v2.Product
import org.aziza.project.presentation.screen.sdui_v2.SubProduct
import org.aziza.project.presentation.screen.sdui_v2.noRippleClickable
import org.aziza.project.presentation.theme.BodyStyles
import org.aziza.project.presentation.theme.HeadingStyles
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * Created by Aziza Helmy on 17/08/2025.
 */

@Composable
fun CoinsScreenSDUI2(json: String) {
    val screen = remember(json) { parseCoinsScreen(json) }
    val registry = remember(json) {
        val response =
            Json { ignoreUnknownKeys = true }.decodeFromString(CoinsResponse.serializer(), json)
        CoinsDataRegistry(response)
    }

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
                            RenderSDUIComponent(component = component, registry = registry)
                        }
                    }
                }
            }
        }
    }
}

// Generic Component Renderer
@Composable
fun RenderSDUIComponent(component: SDUIComponent, registry: CoinsDataRegistry) {
    when (component.type) {
        "card" -> RenderCard(component, registry)
        "column" -> RenderColumn(component, registry)
        "row" -> RenderRow(component, registry)
        "text" -> RenderText(component, registry)
        "text_underline" -> RenderText(component, registry)
        "image" -> RenderImage(component, registry)
        "icon" -> RenderIcon(component, registry)
        "spacer" -> RenderSpacer(component)
        "box" -> RenderBox(component, registry)
        "list_expandable" -> RenderExpandableList(component, registry)
        "flow_row" -> RenderFlowRow(component, registry)
        else -> {
            Text(
                text = "Unknown component: ${component.type}",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun RenderCard(component: SDUIComponent, registry: CoinsDataRegistry) {
    val style = component.style

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .applyPadding(style?.padding),
        colors = CardDefaults.cardColors(
            containerColor = style?.backgroundColor?.firstOrNull()?.parseColor()
                ?: Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = (style?.elevation ?: 0).dp),
        shape = when (style?.shape) {//todo: handle more shapes
            "rounded" -> RoundedCornerShape(12.dp)
            "rounded_16" -> RoundedCornerShape(16.dp)
            else -> RoundedCornerShape(8.dp)
        }
    ) {
        component.components?.forEach { child ->
            RenderSDUIComponent(child, registry)
        }
    }
}

@Composable
fun RenderColumn(component: SDUIComponent, registry: CoinsDataRegistry) {
    val style = component.style

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .applyHeight(style?.height)
            .applyBackground(style?.backgroundColor)
            .applyPadding(style?.padding),
        verticalArrangement = when (style?.arrangement) {
            "space-between" -> Arrangement.SpaceBetween
            "space-around" -> Arrangement.SpaceAround
            "center" -> Arrangement.Center
            "spacedBy_8" -> Arrangement.spacedBy(8.dp)
            else -> Arrangement.Top
        },
        horizontalAlignment = when (style?.alignment) {
            "center" -> Alignment.CenterHorizontally
            "start" -> Alignment.Start
            "end" -> Alignment.End
            else -> Alignment.CenterHorizontally
        }
    ) {
        component.components?.forEach { child ->
            if (child.type == "spacer") {
                val weight = child.style?.weight ?: 1f
                Spacer(Modifier.weight(weight))
            } else {
                RenderSDUIComponent(child, registry)
            }
        }
    }
}

@Composable
fun RenderRow(component: SDUIComponent, registry: CoinsDataRegistry) {
    val style = component.style
    val cornerRadius = style?.cornerRadius?.dp ?: 0.dp

    Row(
        modifier = Modifier
            .applyWidth(style?.width)
            .applyHeight(style?.height)
            .clip(RoundedCornerShape(cornerRadius))
            .applyBackground(style?.backgroundColor)
            .applyPadding(style?.padding),
        horizontalArrangement = when (style?.arrangement) {
            "space-between" -> Arrangement.SpaceBetween
            "space-around" -> Arrangement.SpaceAround
            "center" -> Arrangement.Center
            else -> Arrangement.Start
        },
        verticalAlignment = when (style?.alignment) {
            "center" -> Alignment.CenterVertically
            "top" -> Alignment.Top
            "bottom" -> Alignment.Bottom
            else -> Alignment.CenterVertically
        }
    ) {
        component.components?.forEach { child ->
            if (child.type == "spacer") {
                val weight = child.style?.weight ?: 1f
                Spacer(Modifier.weight(weight))
            } else {
                RenderSDUIComponent(child, registry)
            }
        }
    }
}

@Composable
fun RenderText(component: SDUIComponent, registry: CoinsDataRegistry) {
    val isUnderlined = component.type == "text_underline"
    val style = component.style
    val text = component.data ?: registry.value(component.dataKey)

    Text(
        text = text,
        style = when (style?.font ?: style?.toString()) {
            //todo: handle more fonts and remove hardcoded strings
            "head1" -> HeadingStyles.head1Bold()
            "head2" -> HeadingStyles.head2Bold()
            "head3" -> HeadingStyles.head3Bold()
            "head4" -> HeadingStyles.head4Bold()
            "head5" -> HeadingStyles.head5Bold()
            "head6" -> HeadingStyles.head6Bold()
            "body" -> BodyStyles.largeRegular()
            "body_small", "body_small_regular" -> BodyStyles.smallMedium()
            else -> BodyStyles.smallMedium()
        }.copy(
            textDecoration = if (isUnderlined) TextDecoration.Underline else TextDecoration.None,
            color = style?.color?.parseColor() ?: Color.Unspecified
        ),
        textAlign = when (style?.textAlign) {
            "center" -> TextAlign.Center
            "start" -> TextAlign.Start
            "end" -> TextAlign.End
            else -> TextAlign.Start
        },
        modifier = Modifier
            .applyClickAction(component.action)
            .then(if (!isUnderlined) Modifier.applyPadding(style?.padding) else Modifier)
    )
}

@Composable
fun RenderImage(component: SDUIComponent, registry: CoinsDataRegistry) {
    val style = component.style
    val source = registry.imageValue(component.dataKey)

    when (source) {
        is ImageSource.Url -> {
            Image(
                painter = rememberImagePainter(source.url),
                contentDescription = null,
                contentScale = style.toContentScale(),
                modifier = Modifier
                    .applySize(style?.size)
                    .applyClickAction(component.action)
            )
        }

        is ImageSource.DrawableRes -> {
            Image(
                painter = painterResource(source.resId),
                contentDescription = null,
                contentScale = style.toContentScale(),
                modifier = Modifier
                    .applySize(style?.size)
                    .applyClickAction(component.action)
            )
        }

        ImageSource.None -> {}
    }
}


// helper extension
private fun ComponentStyle?.toContentScale(): ContentScale = when (this?.contentScale) {
    "fillBounds" -> ContentScale.FillBounds
    "fit" -> ContentScale.Fit
    "crop" -> ContentScale.Crop
    else -> ContentScale.Fit
}


@Composable
fun RenderIcon(component: SDUIComponent, registry: CoinsDataRegistry) {
    val style = component.style
    val iconName = component.dataKey ?: "ic_coins"
    Icon(
        painter = painterResource(getDrawableResource(iconName)),
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = Modifier.applySize(style?.size)
    )
}

@Composable
fun RenderSpacer(component: SDUIComponent) {
    val style = component.style
    val weight = style?.weight
    val height = style?.height
    val width = style?.size

    Spacer(
        modifier = Modifier.then(
            when {
                height != null -> Modifier.height(height.dp)
                width != null -> Modifier.width(width.dp)
                else -> Modifier.size(8.dp) // Default spacing
            }
        )
    )
}

@Composable
fun RenderBox(component: SDUIComponent, registry: CoinsDataRegistry) {
    val style = component.style

    Box(
        modifier = Modifier
            .applyWidth(style?.width)
            .applyHeight(style?.height)
            .applyBorder(style?.border)
            .applyShape(style?.shape)
            .applyOffset(style?.offset)
            .applyClickAction(component.action),
        contentAlignment = when (style?.alignment) {
            "center" -> Alignment.Center
            "top" -> Alignment.TopCenter
            "bottom" -> Alignment.BottomCenter
            else -> Alignment.Center
        }
    ) {
        // Handle badge_count style
        if (style?.toString() == "badge_count") {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Black, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = registry.products.size.toString(),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    maxLines = 1
                )
            }
        } else {
            component.components?.forEach { child ->
                RenderSDUIComponent(child, registry)
            }
        }
    }
}

@Composable
fun RenderExpandableList(component: SDUIComponent, registry: CoinsDataRegistry) {
    registry.categories.forEach { category ->
        var expanded by remember(category.categoryId) { mutableStateOf(true) }
        val products = registry.getProductsByCategory(category.categoryId)

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
                    Text(text = category.categoryTitle, style = HeadingStyles.head5Bold())
                    Spacer(modifier = Modifier.weight(1f))

                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.Black, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = products.size.toString(),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            maxLines = 1
                        )
                    }
                    Icon(
                        painter = if (expanded) painterResource(Res.drawable.ic_arrow_up)
                        else painterResource(Res.drawable.ic_arrow_down),
                        contentDescription = if (expanded) "Collapse" else "Expand"
                    )
                }

                if (expanded) {
                    // Render flow row with products
                    component.components?.forEach { child ->
                        if (child.type == "card") {
                            RenderFlowRowWithProducts(child, registry, products)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RenderFlowRow(component: SDUIComponent, registry: CoinsDataRegistry) {
    // This will be called from within expandable list
    val style = component.style
    val spacing = (style?.horizontalSpacing ?: 8).dp
    val columns = style?.maxItemsInEachRow ?: 3

    FlowRow(
        maxItemsInEachRow = columns,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalArrangement = Arrangement.spacedBy((style?.verticalSpacing ?: 12).dp),
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
        val products: List<Product> = registry.listValue(component.dataKey)

        products.forEach { product ->
            component.components?.let { template ->
                RenderProductCardFromTemplate(template, product, Modifier.width(cellWidth), registry)
            }
        }
    }
}

@Composable
fun RenderFlowRowWithProducts(
    cardComponent: SDUIComponent,
    registry: CoinsDataRegistry,
    products: List<Product>
) {
    val flowRowComponent = findFirstComponentByType(cardComponent, "flow_row")
    val style = flowRowComponent?.style
    val spacing = (style?.horizontalSpacing ?: 8).dp
    val columns = style?.maxItemsInEachRow ?: 3

    FlowRow(
        maxItemsInEachRow = columns,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalArrangement = Arrangement.spacedBy((style?.verticalSpacing ?: 12).dp),
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

        products.forEach { product ->
            flowRowComponent?.components?.let { template ->
                RenderProductCardFromTemplate(template, product, Modifier.width(cellWidth), registry)
            }
        }
    }
}

private fun findFirstComponentByType(root: SDUIComponent, type: String): SDUIComponent? {
    if (root.type == type) return root
    root.components?.forEach { child ->
        val found = findFirstComponentByType(child, type)
        if (found != null) return found
    }
    return null
}


@Composable
fun RenderProductCardFromTemplate(
    template: List<SDUIComponent>,
    product: Product,
    modifier: Modifier,
    registry: CoinsDataRegistry? = null
) {
    // The template is the list of components that define the card structure
    // For your JSON, this should be a single card component
    val cardTemplate = template.firstOrNull { it.type == "card" } ?: template.firstOrNull()

    if (cardTemplate != null) {
        Card(
            modifier = modifier.height((cardTemplate.style?.height ?: 140).dp),
            colors = CardDefaults.cardColors(
                containerColor = cardTemplate.style?.backgroundColor?.firstOrNull()?.parseColor()
                    ?: Color(0xFFF5F5F5)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            // Render the card's children, but substitute product data where needed
            cardTemplate.components?.forEach { component ->
                RenderComponentWithProductData(component, product, registry)
            }
        }
    }
}

@Composable
fun RenderComponentWithProductData(
    component: SDUIComponent, 
    product: Product, 
    registry: CoinsDataRegistry? = null
) {
    // This function renders a component but replaces dataKey with actual product data
    when (component.type) {
        "column" -> {
            val style = component.style
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .applyPadding(style?.padding),
                verticalArrangement = when (style?.arrangement) {
                    "spacedBy_8" -> Arrangement.spacedBy(8.dp)
                    "center" -> Arrangement.Center
                    else -> Arrangement.Top
                },
                horizontalAlignment = when (style?.alignment) {
                    "center" -> Alignment.CenterHorizontally
                    else -> Alignment.CenterHorizontally
                }
            ) {
                component.components?.forEach { child ->
                    if (child.type == "spacer" && child.style?.weight != null) {
                        Spacer(modifier = Modifier.weight(child.style.weight))
                    } else {
                        RenderComponentWithProductData(child, product, registry)
                    }
                }
            }
        }

        "image" -> {
            val style = component.style
            Image(
                painter = rememberImagePainter(product.itemImage),
                contentDescription = null,
                contentScale = when (style?.contentScale) {
                    "fillBounds" -> ContentScale.FillBounds
                    else -> ContentScale.Fit
                },
                modifier = Modifier.applySize(style?.size, style?.frame)
            )
        }

        "text" -> {
            val style = component.style
            Text(
                text = when (component.dataKey) {
                    "longDesc" -> product.longDesc
                    "title" -> product.title
                    "shortDesc" -> product.shortDesc
                    "fees" -> product.fees
                    else -> product.longDesc
                },
                style = when (style?.font ?: style?.toString()) {
                    "body" -> MaterialTheme.typography.bodyMedium
                    "body_medium_regular" -> MaterialTheme.typography.bodyMedium
                    "body_small_regular" -> MaterialTheme.typography.bodySmall
                    else -> MaterialTheme.typography.bodyMedium
                },
                textAlign = when (style?.textAlign) {
                    "center" -> TextAlign.Center
                    "start" -> TextAlign.Start
                    "end" -> TextAlign.End
                    else -> TextAlign.Center
                },
                maxLines = style?.maxItemsInEachRow ?: Int.MAX_VALUE
            )
        }

        "spacer" -> {
            val weight = component.style?.weight
            if (weight != null) {
                // This will be handled by the parent Column/Row
                Spacer(modifier = Modifier.height(8.dp))
            } else {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        "box" -> {
            val style = component.style
            Box(
                modifier = Modifier
                    .applyWidth(style?.width)
                    .applyHeight(style?.height)
                    .applyBorder(style?.border)
                    .applyShape(style?.shape)
                    .applyClickAction(component.action),
                contentAlignment = Alignment.Center
            ) {
                component.components?.forEach { child ->
                    RenderComponentWithProductData(child, product)
                }
            }
        }

        "row" -> {
            val style = component.style
            Row(
                modifier = Modifier
                    .applyWidth(style?.width)
                    .applyHeight(style?.height)
                    .applyPadding(style?.padding),
                horizontalArrangement = when (style?.arrangement) {
                    "center" -> Arrangement.Center
                    else -> Arrangement.Start
                },
                verticalAlignment = when (style?.alignment) {
                    "center" -> Alignment.CenterVertically
                    else -> Alignment.CenterVertically
                }
            ) {
                component.components?.forEach { child ->
                    RenderComponentWithProductData(child, product)
                }
            }
        }

        "icon" -> {
            val style = component.style
            val iconName = component.dataKey ?: "ic_coins"
            Icon(
                painter = painterResource(getDrawableResource(iconName)),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.applySize(style?.size)
            )
        }

        else -> {
            // For any other component type, render with product data substitution
            Text(
                text = when (component.dataKey) {
                    "longDesc" -> product.longDesc
                    "title" -> product.title
                    "shortDesc" -> product.shortDesc
                    "fees" -> product.fees
                    "" -> product.longDesc
                    else -> product.title
                },
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun RenderSubProductCardFromTemplate(
    template: List<SDUIComponent>,
    subProduct: SubProduct,
    modifier: Modifier,
    registry: CoinsDataRegistry
) {
    val cardTemplate = template.firstOrNull { it.type == "card" } ?: template.firstOrNull()

    if (cardTemplate != null) {
        Card(
            modifier = modifier.height((cardTemplate.style?.height ?: 140).dp),
            colors = CardDefaults.cardColors(
                containerColor = cardTemplate.style?.backgroundColor?.firstOrNull()?.parseColor()
                    ?: Color(0xFFF5F5F5)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            cardTemplate.components?.forEach { component ->
                RenderComponentWithSubProductData(component, subProduct, registry)
            }
        }
    }
}

@Composable
fun RenderComponentWithSubProductData(
    component: SDUIComponent,
    subProduct: SubProduct,
    registry: CoinsDataRegistry
) {
    when (component.type) {
        "column" -> {
            val style = component.style
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .applyPadding(style?.padding),
                verticalArrangement = when (style?.arrangement) {
                    "spacedBy_8" -> Arrangement.spacedBy(8.dp)
                    "center" -> Arrangement.Center
                    else -> Arrangement.Top
                },
                horizontalAlignment = when (style?.alignment) {
                    "center" -> Alignment.CenterHorizontally
                    else -> Alignment.CenterHorizontally
                }
            ) {
                component.components?.forEach { child ->
                    if (child.type == "spacer" && child.style?.weight != null) {
                        Spacer(modifier = Modifier.weight(child.style.weight))
                    } else {
                        RenderComponentWithSubProductData(child, subProduct, registry)
                    }
                }
            }
        }

        "image" -> {
            val style = component.style
            Image(
                painter = rememberImagePainter(subProduct.itemImage),
                contentDescription = null,
                contentScale = when (style?.contentScale) {
                    "fillBounds" -> ContentScale.FillBounds
                    else -> ContentScale.Fit
                },
                modifier = Modifier.applySize(style?.size, style?.frame)
            )
        }

        "text" -> {
            val style = component.style
            val text = when (component.dataKey) {
                "title" -> subProduct.title
                "GIFT_FEES" -> subProduct.getAttributeValue(registry, "GIFT_FEES")
                "QUOTA" -> subProduct.getAttributeValue(registry, "QUOTA")
                "GIFT_VALIDITY" -> subProduct.getAttributeValue(registry, "GIFT_VALIDITY")
                "longDesc" -> "${subProduct.getAttributeValue(registry, "GIFT_FEES")} Coins"
                else -> subProduct.title
            }
            
            Text(
                text = text,
                style = when (style?.font ?: style?.toString()) {
                    "body_medium_regular" -> MaterialTheme.typography.bodyMedium
                    "body_small_regular" -> MaterialTheme.typography.bodySmall
                    else -> MaterialTheme.typography.bodyMedium
                },
                textAlign = when (style?.textAlign) {
                    "center" -> TextAlign.Center
                    "start" -> TextAlign.Start
                    "end" -> TextAlign.End
                    else -> TextAlign.Center
                },
                maxLines = style?.maxItemsInEachRow ?: Int.MAX_VALUE
            )
        }

        "box" -> {
            val style = component.style
            Box(
                modifier = Modifier
                    .applyWidth(style?.width)
                    .applyHeight(style?.height)
                    .applyBorder(style?.border)
                    .applyShape(style?.shape)
                    .applyClickAction(component.action),
                contentAlignment = Alignment.Center
            ) {
                component.components?.forEach { child ->
                    RenderComponentWithSubProductData(child, subProduct, registry)
                }
            }
        }

        "row" -> {
            val style = component.style
            Row(
                modifier = Modifier
                    .applyWidth(style?.width)
                    .applyHeight(style?.height)
                    .applyPadding(style?.padding),
                horizontalArrangement = when (style?.arrangement) {
                    "center" -> Arrangement.Center
                    else -> Arrangement.Start
                },
                verticalAlignment = when (style?.alignment) {
                    "center" -> Alignment.CenterVertically
                    else -> Alignment.CenterVertically
                }
            ) {
                component.components?.forEach { child ->
                    RenderComponentWithSubProductData(child, subProduct, registry)
                }
            }
        }

        "icon" -> {
            val style = component.style
            val iconName = component.dataKey ?: "ic_coins"
            Icon(
                painter = painterResource(getDrawableResource(iconName)),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.applySize(style?.size)
            )
        }

        "spacer" -> {
            val weight = component.style?.weight
            if (weight != null) {
                Spacer(modifier = Modifier.height(8.dp))
            } else {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        else -> {
            Text(
                text = subProduct.title,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

// Extension functions for applying styles
fun Modifier.applyPadding(padding: Padding?): Modifier {
    return if (padding != null) {
        this.padding(
            top = padding.top.dp,
            bottom = padding.bottom.dp,
            start = padding.right.dp,
            end = padding.left.dp
        )
    } else this
}

fun Modifier.applyWidth(width: String?): Modifier {
    return when (width) {
        "match_parent", "full" -> this.fillMaxWidth()
        else -> this.fillMaxWidth()
    }
}

fun Modifier.applyHeight(height: Int?): Modifier {
    return if (height != null) this.height(height.dp) else this
}

fun Modifier.applySize(size: Int?, frame: FrameSize? = null): Modifier {
    return when {
        frame != null -> this.size(frame.width.dp, frame.height.dp)
        size != null -> this.size(size.dp)
        else -> this
    }
}

fun Modifier.applyBackground(backgroundColor: List<String>?): Modifier {
    return if (!backgroundColor.isNullOrEmpty()) {
        if (backgroundColor.size > 1) {
            // Gradient background
            this.background(
                brush = Brush.horizontalGradient(
                    colors = backgroundColor.map { it.parseColor() }
                )
            )
        } else {
            // Single color background
            this.background(backgroundColor.first().parseColor())
        }
    } else this
}

fun Modifier.applyBorder(border: BorderStyle?): Modifier {
    return if (border != null) {
        this.border(border.width.dp, border.color.parseColor(), RoundedCornerShape(24.dp))
    } else this
}

fun Modifier.applyShape(shape: String?): Modifier {
    return when (shape) {
        "rounded_24" -> this.clip(RoundedCornerShape(24.dp))
        "rounded_16" -> this.clip(RoundedCornerShape(16.dp))
        "rounded" -> this.clip(RoundedCornerShape(12.dp))
        else -> this
    }
}

fun Modifier.applyOffset(offset: Int?): Modifier {
    return if (offset != null) this.offset(y = offset.dp) else this
}

fun Modifier.applyClickAction(action: ViewAction?): Modifier {
    return if (action != null) {
        this.clickable {
            // Handle action based on actionType
            when (action.actionType) {
                "click" -> { /* Handle click */
                }

                "screen_id" -> { /* Navigate to screen */
                }

                "link" -> { /* Open link */
                }
            }
        }
    } else this
}

// Helper functions
fun String.parseColor(): Color {
    return try {
        val colorString = this.replace("#0x", "").replace("#0X", "").replace("#", "")
        when (colorString.length) {
            6 -> {
                // RGB format (e.g., "FF0000" for red)
                val colorLong = colorString.toLong(16)
                Color(0xFF000000 or colorLong)
            }

            8 -> {
                // ARGB format (e.g., "FFFF0000" for red with full alpha)
                val colorLong = colorString.toLong(16)
                Color(colorLong)
            }

            else -> Color.Unspecified
        }
    } catch (e: Exception) {
        Color.Unspecified
    }
}

fun getDrawableResource(iconName: String): DrawableResource {
    return when (iconName) {
        "ic_info" -> Res.drawable.ic_info
        "ic_arrow_forward" -> Res.drawable.ic_arrow_right_black
        "ic_arrow_down" -> Res.drawable.ic_arrow_down
        "ic_arrow_up" -> Res.drawable.ic_arrow_up
        "ic_coins" -> Res.drawable.ic_coins
        else -> Res.drawable.ic_info // fallback
    }
}