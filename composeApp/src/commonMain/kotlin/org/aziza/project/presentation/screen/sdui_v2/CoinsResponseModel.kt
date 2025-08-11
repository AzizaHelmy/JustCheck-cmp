package org.aziza.project.presentation.screen.sdui_v2

import kotlinx.serialization.Serializable
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonPrimitive

/**
 * Created by Aziza Helmy on 06/08/2025.
 */

// --- Generic helper to accept either a single object or a list ---
private class ListOrSingleSerializer<T>(
    private val elementSerializer: KSerializer<T>
) : KSerializer<List<T>> {
    override val descriptor: SerialDescriptor = listSerialDescriptor(elementSerializer.descriptor)

    override fun deserialize(decoder: Decoder): List<T> {
        val input = decoder as? JsonDecoder
            ?: throw IllegalStateException("ListOrSingleSerializer only works with JSON")
        val element: JsonElement = input.decodeJsonElement()
        return when (element) {
            is JsonArray -> element.map { input.json.decodeFromJsonElement(elementSerializer, it) }
            is JsonObject -> listOf(input.json.decodeFromJsonElement(elementSerializer, element))
            else -> emptyList()
        }
    }

    override fun serialize(encoder: Encoder, value: List<T>) {
        // Simple array serialization
        val jsonEncoder = encoder as? JsonDecoder
        // Fallback to default list serialization by encoding the array manually is omitted for brevity
        throw NotImplementedError("Serialization not needed for this use-case")
    }
}

private object ProductListSerializer : KSerializer<List<Product>> by ListOrSingleSerializer(Product.serializer())
private object SubProductListSerializer : KSerializer<List<SubProduct>> by ListOrSingleSerializer(SubProduct.serializer())
private object AttributeListSerializer : KSerializer<List<Attribute>> by ListOrSingleSerializer(Attribute.serializer())

// --- Data Classes for the JSON Structure ---

@Serializable
data class CoinsResponse(
    val data: CoinsData,
    val views: Views
)

@Serializable
data class CoinsData(
    val customerProfileResponse: CustomerProfileResponse
)

@Serializable
data class CustomerProfileResponse(
    val status: String,
    val responseAttributes: ResponseAttributes,
    val Categories: Categories
)

@Serializable
data class ResponseAttributes(
    val responseAttribute: List<Attribute>
)

@Serializable
data class Attribute(
    val key: String,
    val attributeValue: AttributeValue
)

@Serializable
data class AttributeValue(
    val value: String
)

@Serializable
data class Categories(
    val Category: List<Category>
)

@Serializable
data class Category(
    val categoryDesc: String,
    val categoryId: String,
    val categoryImg: String,
    val categoryTitle: String,
    val products: Products
)

@Serializable
data class Products(
    @Serializable(with = ProductListSerializer::class)
    val product: List<Product>
)

@Serializable
data class Product(
    val productId: String,
    val productStatus: String,
    val subscriptionSteps: String,
    val title: String,
    val itemImage: String,
    val longDesc: String,
    val shortDesc: String,
    val fees: String,
    val operations: Operations,
    val subProducts: SubProducts
)

@Serializable
data class Operations(
    val operation: Operation
)

@Serializable
data class Operation(
    val operationCategories: String,
    val operationId: String,
    val operationName: String,
    val operationOrder: String
)

@Serializable
data class SubProducts(
    @Serializable(with = SubProductListSerializer::class)
    val subProduct: List<SubProduct>
)

@Serializable
data class SubProduct(
    val productId: String,
    val productStatus: String,
    val subscriptionSteps: String,
    val title: String,
    val itemImage: String,
    val parameters: Parameters,
    val attributes: SubProductAttributes
)

@Serializable
data class Parameters(
    val parameter: Parameter
)

@Serializable
data class Parameter(
    val name: String,
    val value: String
)

@Serializable
data class SubProductAttributes(
    @Serializable(with = AttributeListSerializer::class)
    val attribute: List<Attribute>
)

// --- Views JSON classes ---
@Serializable
data class Views(
    val title: String,
    val flowId: String,
    val components: List<ViewComponentRaw>
)

// Replace sealed class with a raw component carrier to avoid polymorphic setup for now
@Serializable
data class ViewComponentRaw(
    val type: String,
    val style: String? = null,
    val dataKey: String? = null,
    val components: List<ViewComponentRaw>? = null
)

@Serializable
data class ViewAction(
    val actionType: String,
    val screenId: String? = null,
    val link: String? = null,
    val parameters: Map<String, String>? = null
)

@Serializable
data class ViewAnalytics(
    val id: String,
    val name: String,
    val event: String? = null,
)

@Serializable
enum class ComponentType {
    TEXT,
    ICON,
    IMAGE,
    BUTTON,
    CARD,
    LIST,
    EXPANDABLE_LIST
}