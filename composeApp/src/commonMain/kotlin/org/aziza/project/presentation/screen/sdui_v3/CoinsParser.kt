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
import org.aziza.project.presentation.screen.sdui_v2.Product
import org.aziza.project.presentation.screen.sdui_v2.SubProduct
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

    private val categoriesById: Map<String, Category> by lazy {
        categories.associateBy { it.categoryId }
    }

    val products: List<Product> by lazy {
        categories.flatMap { it.products.product }
    }

    private val productsById: Map<String, Product> by lazy {
        products.associateBy { it.productId }
    }

    private val productsByCategory: Map<String, List<Product>> by lazy {
        categories.associate { category ->
            category.categoryId to category.products.product
        }
    }

    val subProducts: List<SubProduct> by lazy {
        products.flatMap { it.subProducts.subProduct }
    }

    private val subProductsById: Map<String, SubProduct> by lazy {
        subProducts.associateBy { "${it.productId}_${it.parameters.parameter.value}" }
    }

    private val subProductsByProduct: Map<String, List<SubProduct>> by lazy {
        products.associate { product ->
            product.productId to product.subProducts.subProduct
        }
    }

    private val attributesBySubProduct: Map<String, Map<String, String>> by lazy {
        subProducts.associate { subProduct ->
            val key = "${subProduct.productId}_${subProduct.parameters.parameter.value}"
            key to subProduct.attributes.attribute.associate { it.key to it.attributeValue.value }
        }
    }

    private val giftsByProduct: Map<String, Map<String, SubProduct>> by lazy {
        products.associate { product ->
            product.productId to product.subProducts.subProduct.associateBy { 
                it.parameters.parameter.value 
            }
        }
    }

    private val lists: Map<String, List<Any>> by lazy {
        mapOf(
            "CATEGORIES" to categories,
            "PRODUCTS" to products,
            "SUB_PRODUCTS" to subProducts
        )
    }

    fun <T> listValue(key: String?): List<T> {
        if (key.isNullOrBlank()) return emptyList()
        @Suppress("UNCHECKED_CAST")
        return lists[key] as? List<T> ?: emptyList()
    }

    fun getCategoryById(categoryId: String): Category? = categoriesById[categoryId]
    
    fun getProductById(productId: String): Product? = productsById[productId]
    
    fun getProductsByCategory(categoryId: String): List<Product> = productsByCategory[categoryId] ?: emptyList()
    
    fun getSubProductById(productId: String, giftId: String): SubProduct? = subProductsById["${productId}_${giftId}"]
    
    fun getSubProductsByProduct(productId: String): List<SubProduct> = subProductsByProduct[productId] ?: emptyList()
    
    fun getSubProductAttributes(productId: String, giftId: String): Map<String, String> = 
        attributesBySubProduct["${productId}_${giftId}"] ?: emptyMap()
    
    fun getSubProductAttribute(productId: String, giftId: String, attributeKey: String): String = 
        getSubProductAttributes(productId, giftId)[attributeKey] ?: ""
    
    fun getGiftsByProduct(productId: String): Map<String, SubProduct> = 
        giftsByProduct[productId] ?: emptyMap()
    
    fun getGift(productId: String, giftId: String): SubProduct? = 
        getGiftsByProduct(productId)[giftId]

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

sealed class ImageSource {
    data class Url(val url: String) : ImageSource()
    data class DrawableRes(val resId: DrawableResource) : ImageSource()   // remove @DrawableRes
    object None : ImageSource()
}


// Extension functions for optimized data access
// -----------------------------
fun SubProduct.getAttributeValue(registry: CoinsDataRegistry, key: String): String {
    return registry.getSubProductAttribute(this.productId, this.parameters.parameter.value, key)
}

fun SubProduct.getAllAttributes(registry: CoinsDataRegistry): Map<String, String> {
    return registry.getSubProductAttributes(this.productId, this.parameters.parameter.value)
}

fun Product.getGifts(registry: CoinsDataRegistry): Map<String, SubProduct> {
    return registry.getGiftsByProduct(this.productId)
}

fun Product.getGift(registry: CoinsDataRegistry, giftId: String): SubProduct? {
    return registry.getGift(this.productId, giftId)
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


