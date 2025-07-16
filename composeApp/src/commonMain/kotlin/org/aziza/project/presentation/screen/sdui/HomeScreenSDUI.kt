package org.aziza.project.presentation.screen.sdui

import Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import org.aziza.project.presentation.screen.composable.AppScaffold
import org.aziza.project.presentation.theme.BodyStyles
import org.aziza.project.presentation.theme.ButtonStyles
import org.aziza.project.presentation.theme.HeadingStyles


/**
 * Created by Aziza Helmy on 06/07/2025.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenSDUI() {
    val screen = remember { parseSDUIScreen(sduiJson) }

    AppScaffold(screenTitle = screen.title) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        screen.components.forEach { component ->
                            RenderUIComponent(component)
                        }
                    }
                }
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
    val textStyle = when (component.styleType) {
        TextType.HEAD1 -> HeadingStyles.head1Bold()
        TextType.HEAD2 -> HeadingStyles.head2Bold()
        TextType.HEAD3 -> HeadingStyles.head3Bold()
        TextType.HEAD4 -> HeadingStyles.head4Bold()
        TextType.HEAD5 -> HeadingStyles.head5Bold()
        TextType.HEAD6 -> HeadingStyles.head6Bold()

        TextType.BODY_LARGE_REGULAR -> BodyStyles.largeRegular()
        TextType.BODY_LARGE_MEDIUM -> BodyStyles.largeMedium()
        TextType.BODY_MEDIUM_REGULAR -> BodyStyles.mediumRegular()
        TextType.BODY_MEDIUM_MEDIUM -> BodyStyles.mediumMedium()
        TextType.BODY_SMALL_REGULAR -> BodyStyles.smallRegular()
        TextType.BODY_SMALL_MEDIUM -> BodyStyles.smallMedium()
        TextType.BODY_XS_BOLD -> BodyStyles.extraSmallBold()
        TextType.BODY_XS_MEDIUM -> BodyStyles.extraSmallMedium()

    }

    Text(
        color = if (textStyle == BodyStyles.mediumRegular())//todo: Discuss
            Colors().naturalColor.naturalGray600
        else Colors().naturalColor.naturalGrayDefault,
        text = component.text,
        style = textStyle,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SDUIButton(component: ButtonComponent) {
    val isEnabled = when (component.styleType) {
        ButtonType.PRIMARY_DISABLED, ButtonType.SECONDARY_DISABLED -> false
        else -> true
    }

    val colors = when (component.styleType) {
        ButtonType.PRIMARY_ENABLED -> ButtonDefaults.buttonColors(
            containerColor = Colors().naturalColor.naturalGrayDefault,
            contentColor = Colors().naturalColor.naturalGrayBackground
        )

        ButtonType.PRIMARY_DISABLED -> ButtonDefaults.buttonColors(
            containerColor = Colors().naturalColor.naturalGray200
        )

        ButtonType.SECONDARY_ENABLED, ButtonType.SECONDARY_DISABLED -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )

        ButtonType.LINK_ENABLED -> ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ButtonType.SMALL_ENABLED -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(
                alpha = 0.8f
            )
        )
    }

    val textStyle = when (component.styleType) {
        ButtonType.PRIMARY_ENABLED, ButtonType.PRIMARY_DISABLED -> ButtonStyles.normalBold()

        ButtonType.SECONDARY_ENABLED, ButtonType.SECONDARY_DISABLED -> ButtonStyles.normalRegular()
        ButtonType.LINK_ENABLED -> ButtonStyles.linkMediumMedium()
        ButtonType.SMALL_ENABLED -> ButtonStyles.smallMedium()
    }

    Button(
        onClick = {
            if (component.action == "log_click") println("Button clicked!")
        },
        enabled = isEnabled,
        colors = colors,
        modifier = Modifier.padding(8.dp).height(48.dp).fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = component.text,

            style = textStyle
        )
    }
}

@Composable
fun SDUIImage(component: ImageComponent) {
    val modifier = when (component.shapeType) {
        ImageType.NORMAL -> Modifier.fillMaxWidth().height(260.dp).padding(8.dp)
    }
    Image(
        painter = rememberImagePainter(component.url),
        contentDescription = null,
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
        modifier = Modifier.fillMaxWidth().padding(8.dp),
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


