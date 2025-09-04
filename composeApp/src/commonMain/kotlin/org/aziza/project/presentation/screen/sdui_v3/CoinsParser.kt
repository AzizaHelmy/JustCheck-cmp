package org.aziza.project.presentation.screen.sdui_v3

import justcheck_cmp.composeapp.generated.resources.Res
import justcheck_cmp.composeapp.generated.resources.ic_arrow_down
import justcheck_cmp.composeapp.generated.resources.ic_arrow_right_black
import justcheck_cmp.composeapp.generated.resources.ic_coins
import justcheck_cmp.composeapp.generated.resources.ic_gift_box
import justcheck_cmp.composeapp.generated.resources.ic_info
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.aziza.project.presentation.screen.sdui_v2.Category
import org.jetbrains.compose.resources.DrawableResource

/**
 * Created by Aziza Helmy on 17/08/2025.
 */

object ComponentStyleSerializer : KSerializer<ComponentStyle?> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("ComponentStyle")

    override fun deserialize(decoder: Decoder): ComponentStyle? {
        val input = decoder as? JsonDecoder ?: error("Only works with JSON")
        val element = input.decodeJsonElement()

        return when (element) {
            is JsonPrimitive -> if (element.isString && element.content.isBlank()) null else null
            is JsonObject -> Json { ignoreUnknownKeys = true }
                .decodeFromJsonElement(ComponentStyleSurrogate.serializer(), element)
                .toReal()
            else -> null
        }
    }

    override fun serialize(encoder: Encoder, value: ComponentStyle?) {
        if (value == null) {
            encoder.encodeString("")
        } else {
            encoder.encodeSerializableValue(
                ComponentStyleSurrogate.serializer(),
                ComponentStyleSurrogate.fromReal(value)
            )
        }
    }
}

/**
 * Serializer that accepts:
 *   - components: [ {...}, {...} ]  ✅ array
 *   - components: { ... }           ✅ single object
 *   - components: "" or null        ✅ empty
 */
object ComponentsListSerializer : KSerializer<List<SDUIComponent>?> {
    private val listSerializer = ListSerializer(SDUIComponent.serializer())
    override val descriptor: SerialDescriptor = listSerializer.descriptor

    override fun deserialize(decoder: Decoder): List<SDUIComponent>? {
        val input = decoder as? JsonDecoder ?: error("Only works with JSON")
        return when (val element = input.decodeJsonElement()) {
            is JsonArray -> input.json.decodeFromJsonElement(listSerializer, element)
            is JsonObject -> listOf(input.json.decodeFromJsonElement(SDUIComponent.serializer(), element))
            is JsonPrimitive -> null // e.g. blank string
            else -> null
        }
    }

    override fun serialize(encoder: Encoder, value: List<SDUIComponent>?) {
        if (value == null) {
            encoder.encodeNull()
        } else {
            encoder.encodeSerializableValue(listSerializer, value)
        }
    }
}
sealed class ImageSource {
    data class Url(val url: String) : ImageSource()
    data class DrawableRes(val resId: DrawableResource) : ImageSource()   // remove @DrawableRes
    object None : ImageSource()
}


// -----------------------------
// Data Registry
// -----------------------------
class CoinsDataRegistry(private val response: CoinsResponse) {
    private val attributes: Map<String, String> by lazy {
        response.data.customerProfileResponse.responseAttributes.responseAttribute
            .associate { it.key to it.attributeValue.value }
    }

    val categories: List<Category> by lazy {
        response.data.customerProfileResponse.Categories.Category
    }
    // For text
    fun value(key: String?): String {
        if (key.isNullOrBlank()) return ""
        return attributes[key] ?: ""
    }


    fun imageValue(key: String?): ImageSource {
        if (key.isNullOrBlank()) return ImageSource.None
        return when (key) {
            "gift_icon" -> ImageSource.DrawableRes(Res.drawable.ic_gift_box)
            "img_coins" -> ImageSource.Url("https://example.com/coins_icon.png")
            "ic_info" -> ImageSource.DrawableRes(Res.drawable.ic_info)
            "ic_arrow_forward" -> ImageSource.DrawableRes(Res.drawable.ic_arrow_right_black)
            "ic_arrow_down" -> ImageSource.DrawableRes(Res.drawable.ic_arrow_down)
            "ic_coins" -> ImageSource.DrawableRes(Res.drawable.ic_coins)
            else -> attributes[key]?.let { ImageSource.Url(it) } ?: ImageSource.None
        }
    }
}

// Main Parsing Function
// -----------------------------
fun parseCoinsScreen(json: String): CoinsUiScreen {
    val jsonConfig = Json { ignoreUnknownKeys = true }
    val response = jsonConfig.decodeFromString(CoinsResponse.serializer(), json)

    return CoinsUiScreen(
        title = response.views.title,
        flowId = response.views.flowId,
        components = response.views.components
    )
}


