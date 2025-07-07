package org.aziza.project.presentation.screen.sdui

/**
 * Created by Aziza Helmy on 06/07/2025.
 */
data class SDUIScreen(
    val title: String,
    val components: List<UIComponent>
)

sealed class UIComponent {
    abstract val id: String
    abstract val type: String
}

data class TextComponent(
    override val id: String,
    val text: String,
    val fontSize: Int = 16,
    val color: String = "#000000"
) : UIComponent() {
    override val type: String = "text"
}

data class ButtonComponent(
    override val id: String,
    val text: String,
    val action: String,
    val width: Int? = null,
    val height: Int? = null,
    val textColor: String? = null,
    val textSize: Int? = null,
    val backgroundColor: String? = null,
    val cornerRadius: Int? = null,
    val borderColor: String? = null,
    val borderWidth: Int? = null
) : UIComponent() {
    override val type: String = "button"
}

data class ImageComponent(
    override val id: String,
    override val type: String = "image",
    val url: String,
    val contentDescription: String? = null,
    val width: Int? = null,
    val height: Int? = null,
    val shape: String? = null,
    val borderColor: String? = null,
    val borderWidth: Int? = null
) : UIComponent()



data class CardComponent(
    override val id: String,
    val children: List<UIComponent>
) : UIComponent() {
    override val type: String = "card"
}

data class ListComponent(
    override val id: String,
    val items: List<UIComponent>
) : UIComponent() {
    override val type: String = "list"
}