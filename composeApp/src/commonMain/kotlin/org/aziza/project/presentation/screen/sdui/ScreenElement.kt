package org.aziza.project.presentation.screen.sdui

/**
 * Created by Aziza Helmy on 06/07/2025.
 */

data class SDUIScreen(
    val title: String,
    val flowId: String? = null,
    val background: BackgroundImage? = null,
    val components: List<UIComponent>
)

data class BackgroundImage(
    val url: String
)

sealed class UIComponent {
    abstract val id: String
}

data class TextComponent(
    override val id: String,
    val text: String,
    val styleType: TextType,
    val action: Action? = null

) : UIComponent()

data class ButtonComponent(
    override val id: String,
    val text: String,
    val styleType: ButtonType,
    val action: Action? = null
) : UIComponent()

data class ImageComponent(
    override val id: String,
    val url: String,
    val shapeType: ImageType,
    val action: Action? = null
) : UIComponent()

data class CardComponent(
    override val id: String,
    val children: List<UIComponent>,
    val action: Action? = null
) : UIComponent()

data class ListComponent(
    override val id: String,
    val items: List<UIComponent>,
    val action: Action? = null
) : UIComponent()

data class Action(
    val actionType: String,
    val screenId: String? = null,
    val link: String? = null,
    val parameters: Map<String, String>? = null
)

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

enum class ActionType {
    LINK, SCREEN_ID, API;

    companion object {
        fun from(value: String?): ActionType? =
            ActionType.entries.firstOrNull { it.name.equals(value, ignoreCase = true) }
    }
}