package org.aziza.project.presentation.screen.sdui

import kotlinx.serialization.json.*

/**
 * Created by Aziza Helmy on 06/07/2025.
 */

val sduiJson = """
{
  "title": "Home Screen",
  "flowId": "generalOffer",
  "components": [
    {
      "type": "image_normal",
      "id": "image1",
      "data": "https://www.usetiful.com/build/images/web/feature8.png"
    },
    {
      "type": "text_head4",
      "id": "text1",
      "data": "Win 1 GB per GoalGoal GoalGoal GoalGoal GoalGoalGoalGoal! 🇪🇬"
    },
    {
      "type": "text_body_medium_regular",
      "id": "text2",
      "data": "Hello SDUI!, I'm just trying to add a long text to check how it will be displaying!"
    },
    {
      "type": "text_body_small_regular",
      "id": "text3",
      "data": "valid till 20/9/2025"
    },
    {
      "type": "button_primary_enabled",
      "id": "b2",
      "data": "Subscribe",
      "action": {
        "actionType": "link",
        "screenId": "optional if type is screenId",
        "link": "https://www.eand.com.eg/StaticFiles/portal2/etisalat/index.html",
        "parameters": {
          "param1": "value1",
          "param2": "value2"
        }
      }
    }
  ]
}
""".trimIndent()

// --- Parser ---
fun parseSDUIScreen(json: String): SDUIScreen {
    val root = Json.parseToJsonElement(json).jsonObject

    val title = root["title"]?.jsonPrimitive?.content ?: ""
    val flowId = root["flowId"]?.jsonPrimitive?.content

    val backgroundImage = root["background"]?.jsonObject?.let { bgObj ->
        val url = bgObj["data"]?.jsonPrimitive?.content
        if (url != null) BackgroundImage(url) else null
    }

    val jsonComponents = root["components"]?.jsonArray ?: JsonArray(emptyList())
    val components = jsonComponents.map { element ->
        val obj = element.jsonObject
        parseUIComponent(obj)
    }

    return SDUIScreen(
        title = title,
        flowId = flowId,
        background = backgroundImage,
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
                text = obj["data"]?.jsonPrimitive?.content ?: "",
                styleType = TextType.valueOf(style.uppercase())
            )
        }

        type.startsWith("button_") -> {
            val style = type.removePrefix("button_").uppercase()
            val actionObj = obj["action"]?.jsonObject
            val action = actionObj?.let {
                Action(
                    actionType = it["actionType"]?.jsonPrimitive?.content ?: "",
                    link = it["link"]?.jsonPrimitive?.content,
                    screenId = it["screenId"]?.jsonPrimitive?.content,
                    parameters = it["parameters"]?.jsonObject?.mapValues { entry ->
                        entry.value.jsonPrimitive.content
                    }
                )
            }

            ButtonComponent(
                id = id,
                text = obj["data"]?.jsonPrimitive?.content ?: "",
                styleType = ButtonType.valueOf(style),
                action = action
            )
        }

        type == "image_normal" -> ImageComponent(
            id = id,
            url = obj["data"]?.jsonPrimitive?.content ?: "",
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

