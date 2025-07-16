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
    val styleType: TextType
) : UIComponent() {
    override val type: String = "text"
}

data class ButtonComponent(
    override val id: String,
    val text: String,
    val action: String,
    val styleType: ButtonType
) : UIComponent() {
    override val type: String = "button"
}

data class ImageComponent(
    override val id: String,
    override val type: String = "image",
    val url: String,
    val shapeType: ImageType,
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

// --- ENUM for Types ---
enum class TextType {
    HEAD1, HEAD2, HEAD3, HEAD4, HEAD5, HEAD6,
    BODY_LARGE_REGULAR, BODY_LARGE_MEDIUM,
    BODY_MEDIUM_REGULAR, BODY_MEDIUM_MEDIUM,
    BODY_SMALL_REGULAR, BODY_SMALL_MEDIUM,
    BODY_XS_BOLD, BODY_XS_MEDIUM
}

enum class ButtonType {
    PRIMARY_ENABLED, PRIMARY_DISABLED,
    SECONDARY_ENABLED, SECONDARY_DISABLED,
    LINK_ENABLED, SMALL_ENABLED
}

enum class ImageType {
    NORMAL,
}