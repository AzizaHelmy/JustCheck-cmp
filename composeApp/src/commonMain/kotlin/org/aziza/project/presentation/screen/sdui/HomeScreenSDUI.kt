package org.aziza.project.presentation.screen.sdui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import org.aziza.project.util.toColorInt


/**
 * Created by Aziza Helmy on 06/07/2025.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenSDUI() {
    val screen = remember { parseSDUIScreen(sduiJson) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        screen.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            )
        }) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(vertical = 16.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(screen.components) { component ->
                RenderUIComponent(component)
            }
        }

    }
}


@Composable
fun RenderUIComponent(component: UIComponent) {
    when (component) {
        is TextComponent -> SDUIText(component)
        is ButtonComponent -> SDUIButton(component)
        is ImageComponent -> SDUIImage(component)
        is ListComponent -> SDUILazyColumn(component)
        is CardComponent -> SDUICard(component)

    }
}


@Composable
fun SDUIText(component: TextComponent) {
    Text(
        text = component.text,
        fontSize = component.fontSize.sp,
        color = Color(component.color.toColorInt().toLong()),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
private fun SDUIButton(component: ButtonComponent) {
    val backgroundColor = component.backgroundColor?.let { Color(it.toColorInt().toLong()) }
        ?: MaterialTheme.colorScheme.primary
    val textColor = component.textColor?.let { Color(it.toColorInt().toLong()) } ?: Color.White
    val borderColor =
        component.borderColor?.let { Color(it.toColorInt().toLong()) } ?: Color.Transparent
    val borderWidth = (component.borderWidth ?: 0).dp
    val cornerRadius = (component.cornerRadius ?: 4).dp
    val textSize = (component.textSize ?: 16).sp

    val modifier = Modifier
        .padding(8.dp)
        .then(
            if (component.width != null && component.height != null) {
                Modifier
                    .width(component.width.dp)
                    .height(component.height.dp)
            } else Modifier
        )
        .border(borderWidth, borderColor, RoundedCornerShape(cornerRadius))

    Button(
        onClick = {
            if (component.action == "log_click") {
                println("Button clicked!")
            }
        },
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = component.text,
            fontSize = textSize,
            color = textColor
        )
    }
}

@Composable
private fun SDUIImage(component: ImageComponent) {
    val borderColor =
        component.borderColor?.let { Color(it.toColorInt().toLong()) } ?: Color.Transparent
    val borderWidth = (component.borderWidth ?: 0).dp

    val modifier = Modifier
        .then(
            if (component.width != null && component.height != null) {
                Modifier
                    .width(component.width.dp)
                    .height(component.height.dp)
            } else Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        .padding(8.dp)
        .border(
            width = borderWidth,
            color = borderColor,
            shape = when (component.shape) {
                "circle" -> CircleShape
                "rounded" -> RoundedCornerShape(12.dp)
                else -> RectangleShape
            }
        )
        .then(
            when (component.shape) {
                "circle" -> Modifier.clip(CircleShape)
                "rounded" -> Modifier.clip(RoundedCornerShape(12.dp))
                else -> Modifier
            }
        )
    Image(
        painter = rememberImagePainter(url = component.url),
        contentDescription = component.contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
private fun SDUILazyColumn(component: ListComponent) {
    component.items.forEach { item ->
        RenderUIComponent(item)
    }
}

@Composable
private fun SDUICard(component: CardComponent) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            component.children.forEach { child ->
                RenderUIComponent(child)
            }
        }
    }
}


