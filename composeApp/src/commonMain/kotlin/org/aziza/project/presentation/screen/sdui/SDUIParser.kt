package org.aziza.project.presentation.screen.sdui

import kotlinx.serialization.json.*

/**
 * Created by Aziza Helmy on 06/07/2025.
 */

val sduiJson = """
{
  "title": "Home Screen",
  "components": [
    {
      "type": "image_normal",
      "id": "image1",
      "url": "https://www.usetiful.com/build/images/web/feature8.png"
    },
    {
      "type": "text_head4",
      "id": "text",
      "text": "Win 1 GB per GoalGoal GoalGoal GoalGoal GoalGoalGoalGoal! 🇪🇬"
    },
    {
      "type": "text_body_medium_regular",
      "id": "text",
      "text": "Hello SDUI!, I'm just trying to add a long text to check how it will be displaying!"
    },
    {
      "type": "button_primary_enabled",
      "id": "b2",
      "text": "Redeem",
      "action": "log_click"
    }
  ]
}
""".trimIndent()

// --- Parser ---
fun parseSDUIScreen(json: String): SDUIScreen {
    val root = Json.parseToJsonElement(json).jsonObject
    val title = root["title"]?.jsonPrimitive?.content ?: ""
    val jsonComponents = root["components"]?.jsonArray ?: JsonArray(emptyList())

    val components = jsonComponents.map { element ->
        val obj = element.jsonObject
        parseUIComponent(obj)
    }

    return SDUIScreen(
        title = title,
        components = components
    )
}

fun parseUIComponent(obj: JsonObject): UIComponent {
    val type = obj["type"]?.jsonPrimitive?.content ?: throw IllegalArgumentException("Missing type")
    val id = obj["id"]?.jsonPrimitive?.content ?: ""

    return when {
        type.startsWith("text_") -> {
            val style = type.removePrefix("text_").lowercase().replace("-", "_")
            TextComponent(
                id = id,
                text = obj["text"]?.jsonPrimitive?.content ?: "",
                styleType = TextType.valueOf(style.uppercase())
            )
        }

        type.startsWith("button_") -> {
            val style = type.removePrefix("button_").lowercase().replace("-", "_")
            ButtonComponent(
                id = id,
                text = obj["text"]?.jsonPrimitive?.content ?: "",
                action = obj["action"]?.jsonPrimitive?.content ?: "",
                styleType = ButtonType.valueOf(style.uppercase())
            )
        }

        type == "image_normal" -> ImageComponent(
            id = id,
            url = obj["url"]?.jsonPrimitive?.content ?: "",
            shapeType = ImageType.valueOf(
                obj["shapeType"]?.jsonPrimitive?.content?.uppercase() ?: "NORMAL"
            )
        )


        type == "list" -> {
            val itemsArray = obj["items"]?.jsonArray ?: JsonArray(emptyList())
            val items = itemsArray.map { parseUIComponent(it.jsonObject) }
            ListComponent(
                id = id,
                items = items
            )
        }

        type == "card" -> {
            val childrenArray = obj["children"]?.jsonArray ?: JsonArray(emptyList())
            val children = childrenArray.map { parseUIComponent(it.jsonObject) }
            CardComponent(
                id = id,
                children = children
            )
        }

        else -> throw IllegalArgumentException("Unknown type: $type")
    }
}
