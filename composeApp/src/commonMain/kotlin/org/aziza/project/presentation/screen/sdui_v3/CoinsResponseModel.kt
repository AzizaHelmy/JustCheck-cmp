package org.aziza.project.presentation.screen.sdui_v3
import kotlinx.serialization.Serializable
import org.aziza.project.presentation.screen.sdui_v2.CoinsData
/**
 * Created by Aziza Helmy on 17/08/2025.
 */


@Serializable
data class CoinsResponse(
    val data: CoinsData,
    val views: CoinsViews
)

@Serializable
data class CoinsViews(
    val title: String,
    val flowId: String,
    val style: ComponentStyle? = null,
    val components: List<SDUIComponent>
)

@Serializable
data class SDUIComponent(
    val type: String,
    val style: ComponentStyle? = null,
    val dataKey: String? = null,
    val data: String? = null,
    val action: ViewAction? = null,
    @Serializable(with = ComponentsListSerializer::class)
    val components: List<SDUIComponent>? = null
)

@Serializable(with = ComponentStyleSerializer::class)
data class ComponentStyle(
    val shape: String? = null,
    val elevation: Int? = null,
    val backgroundColor: List<String>? = null,
    val padding: Padding? = null,
    val margin: Margin? = null,
    val width: String? = null,
    val height: Int? = null,
    val size: Int? = null,
    val font: String? = null,
    val color: String? = null,
    val textAlign: String? = null,
    val arrangement: String? = null,
    val alignment: String? = null,
    val weight: Float? = null,
    val offset: Int? = null,
    val maxItemsInEachRow: Int? = null,
    val horizontalSpacing: Int? = null,
    val verticalSpacing: Int? = null,
    val border: BorderStyle? = null,
    val contentScale: String? = null,
    val frame: FrameSize? = null
)

@Serializable
data class Padding(val top: Int = 0, val bottom: Int = 0, val left: Int = 0, val right: Int = 0)

@Serializable
data class Margin(val top: Int = 0, val bottom: Int = 0, val left: Int = 0, val right: Int = 0)

@Serializable
data class BorderStyle(val color: String, val width: Int)

@Serializable
data class FrameSize(val width: Int, val height: Int)

@Serializable
data class ViewAction(
    val actionType: String? = null,
    val screenId: String? = null,
    val link: String? = null,
    val extras: List<ActionExtra>? = null
)

@Serializable
data class ActionExtra(val key: String, val value: String? = null, val dataKey: String? = null)

// UI Screen Model
data class CoinsUiScreen(
    val title: String,
    val flowId: String,
    val components: List<SDUIComponent>
)

// -----------------------------
// Surrogate for ComponentStyle
// -----------------------------
@Serializable
data class ComponentStyleSurrogate(
    val shape: String? = null,
    val elevation: Int? = null,
    val backgroundColor: List<String>? = null,
    val padding: Padding? = null,
    val margin: Margin? = null,
    val width: String? = null,
    val height: Int? = null,
    val size: Int? = null,
    val font: String? = null,
    val color: String? = null,
    val textAlign: String? = null,
    val arrangement: String? = null,
    val alignment: String? = null,
    val weight: Float? = null,
    val offset: Int? = null,
    val maxItemsInEachRow: Int? = null,
    val horizontalSpacing: Int? = null,
    val verticalSpacing: Int? = null,
    val border: BorderStyle? = null,
    val contentScale: String? = null,
    val frame: FrameSize? = null
) {
    fun toReal(): ComponentStyle = ComponentStyle(
        shape, elevation, backgroundColor, padding, margin,
        width, height, size, font, color, textAlign,
        arrangement, alignment, weight, offset,
        maxItemsInEachRow, horizontalSpacing, verticalSpacing,
        border, contentScale, frame
    )

    companion object {
        fun fromReal(real: ComponentStyle): ComponentStyleSurrogate = ComponentStyleSurrogate(
            real.shape, real.elevation, real.backgroundColor, real.padding, real.margin,
            real.width, real.height, real.size, real.font, real.color, real.textAlign,
            real.arrangement, real.alignment, real.weight, real.offset,
            real.maxItemsInEachRow, real.horizontalSpacing, real.verticalSpacing,
            real.border, real.contentScale, real.frame
        )
    }
}