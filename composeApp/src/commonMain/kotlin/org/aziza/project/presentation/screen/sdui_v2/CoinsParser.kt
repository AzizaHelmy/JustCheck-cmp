package org.aziza.project.presentation.screen.sdui_v2

import kotlinx.serialization.json.Json

// UI models used by the SDUI renderer
sealed class CoinsUiComponent { abstract val id: String }

data class CoinsBannerUi(
    override val id: String,
    val imageUrl: String,
    val coins: String,
    val description: String
) : CoinsUiComponent()

data class CoinsGiftCardUi(
    override val id: String,
    val imageUrl: String,
    val title: String
) : CoinsUiComponent()

data class CoinsProductCardUi(
    override val id: String,
    val imageUrl: String,
    val title: String,
    val priceRange: String,
    val subProducts: List<CoinsSubProductUi>
) : CoinsUiComponent()

data class CoinsExpandableUi(
    override val id: String,
    val headerTitle: String,
    val headerBadge: String?,
    val items: List<CoinsProductCardUi>
) : CoinsUiComponent()

data class CoinsSubProductUi(
    val id: String,
    val title: String,
    val imageUrl: String,
    val giftId: String,
    val quota: String,
    val fees: String,
    val validity: String
)

data class CoinsUiScreen(
    val title: String,
    val flowId: String,
    val components: List<CoinsUiComponent>
)

// Registry to resolve values by keys from the top-level data section
private class CoinsDataRegistry(private val response: CoinsResponse) {
    private val attributes: Map<String, String> by lazy {
        response.data.customerProfileResponse.responseAttributes.responseAttribute
            .associate { it.key to it.attributeValue.value }
    }

    val categories: List<Category> by lazy {
        response.data.customerProfileResponse.Categories.Category
    }

    fun value(key: String?): String? {
        if (key.isNullOrBlank()) return null
        return attributes[key]
    }
}

// Public API: parse json and return a UI screen
fun parseCoinsScreen(json: String): CoinsUiScreen {
    val jsonConfig = Json { ignoreUnknownKeys = true }
    val response = jsonConfig.decodeFromString(CoinsResponse.serializer(), json)
    val registry = CoinsDataRegistry(response)

    val components = buildList {
        response.views.components.forEach { comp ->
            when (comp.type) {
                "card_banner_coins" -> add(
                    CoinsBannerUi(
                        id = "coins_banner",
                        imageUrl = registry.value("IMAGE_URL") ?: "",
                        coins = registry.value("COINS") ?: "0",
                        description = registry.value("COINS_DESC") ?: ""
                    )
                )
                "card_my_gifts" -> add(
                    CoinsGiftCardUi(
                        id = "gift_card",
                        imageUrl = "https://mab.etisalat.com.eg:11003/app/mwadm/Saytar/freezone/images/imagesV2/COINS_PACKS_INQUIRY/gift_icon.png",
                        title = "My Gifts"
                    )
                )
                "list_expandable" -> addAll(buildExpandableFromCategories(registry.categories))
            }
        }
    }

    return CoinsUiScreen(
        title = response.views.title,
        flowId = response.views.flowId,
        components = components
    )
}

private fun buildExpandableFromCategories(categories: List<Category>): List<CoinsUiComponent> {
    if (categories.isEmpty()) return emptyList()
    return categories.map { category ->
        val productCards = category.products.product.map { product ->
            val subProducts = product.subProducts.subProduct.map { sp ->
                CoinsSubProductUi(
                    id = sp.productId,
                    title = sp.title,
                    imageUrl = sp.itemImage,
                    giftId = sp.parameters.parameter.value,
                    quota = sp.attributes.attribute.firstOrNull { it.key == "QUOTA" }?.attributeValue?.value ?: "",
                    fees = sp.attributes.attribute.firstOrNull { it.key == "GIFT_FEES" }?.attributeValue?.value ?: "",
                    validity = sp.attributes.attribute.firstOrNull { it.key == "GIFT_VALIDITY" }?.attributeValue?.value
                        ?: ""
                )
            }
            CoinsProductCardUi(
                id = "product_${'$'}{product.productId}",
                imageUrl = product.itemImage,
                title = product.title,
                priceRange = product.longDesc,
                subProducts = subProducts
            )
        }
        CoinsExpandableUi(
            id = "expandable_${'$'}{category.categoryId}",
            headerTitle = category.categoryTitle,
            headerBadge = category.products.product.size.toString(),
            items = productCards
        )
    }
}