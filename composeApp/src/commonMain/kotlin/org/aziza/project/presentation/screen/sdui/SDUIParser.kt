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
      "type": "image",
      "id": "image1",
      "url": "https://www.usetiful.com/build/images/web/feature8.png",
      "height": 200,
      "borderColor": "#000000",
      "borderWidth": 1
    },
    {
      "type": "text",
      "id": "text1",
      "text": "Hello SDUI!",
      "fontSize": 20,
      "color": "#000000"
    },
    {
      "type": "text",
      "id": "text2",
      "text": "Hello SDUI!, I'm just trying to add a long text to check how it will be displaying!",
      "fontSize": 16,
      "color": "#000000"
    },
    {
      "type": "button",
      "id": "button1",
      "width": 200,
      "height": 48,
      "text": "Click me",
      "action": "log_click",
      "textColor": "#FFFFFF",
      "textSize": 16,
      "backgroundColor": "#D0BCFF",
      "cornerRadius": 12,
      "borderColor": "#888888",
      "borderWidth": 2
    },
    {
      "type": "list",
      "id": "list1",
      "items": [
        {
          "type": "image",
          "id": "list_image_1",
          "url": "https://www.usetiful.com/build/images/web/feature8.png",
          "width": 60,
          "height": 60,
          "shape": "circle",
          "borderColor": "#000000",
          "borderWidth": 2
        },
        {
          "type": "text",
          "id": "list_text_1",
          "text": "List item 1",
          "fontSize": 14,
          "color": "#000000"
        },
        {
          "type": "image",
          "id": "list_image_2",
          "url": "https://www.usetiful.com/build/images/web/feature8.png",
          "width": 90,
          "height": 90,
          "shape": "circle"
        },
        {
          "type": "text",
          "id": "list_text_1",
          "text": "List item 2",
          "fontSize": 14,
          "color": "#000000"
        },
        {
          "type": "image",
          "id": "list_image_3",
          "url": "https://www.usetiful.com/build/images/web/feature8.png",
          "width": 90,
          "height": 90,
          "shape": "circle"
        },
        {
          "type": "text",
          "id": "list_text_2",
          "text": "List item 3",
          "fontSize": 14,
          "color": "#000000"
        },
        {
          "type": "image",
          "id": "list_image_3",
          "url": "https://www.usetiful.com/build/images/web/feature8.png",
          "width": 90,
          "height": 90,
          "shape": "circle"
        },
        {
          "type": "text",
          "id": "list_text_2",
          "text": "List item 4",
          "fontSize": 14,
          "color": "#000000"
        },
        {
          "type": "image",
          "id": "list_image_3",
          "url": "https://www.usetiful.com/build/images/web/feature8.png",
          "width": 90,
          "height": 90,
          "shape": "circle"
        },
        {
          "type": "text",
          "id": "list_text_2",
          "text": "List item 5",
          "fontSize": 14,
          "color": "#000000"
        }
      ]
    }
  ]
}
""".trimIndent()

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
    return when (obj["type"]?.jsonPrimitive?.content) {
        "text" -> TextComponent(
            id = obj["id"]?.jsonPrimitive?.content?:"",
            text = obj["text"]?.jsonPrimitive?.content?:"",
            fontSize = obj["fontSize"]?.jsonPrimitive?.intOrNull ?: 16,
            color = obj["color"]?.jsonPrimitive?.content ?: "#000000"
        )

        "button" -> ButtonComponent(
            id = obj["id"]?.jsonPrimitive?.content?:"",
            text = obj["text"]?.jsonPrimitive?.content?:"",
            action = obj["action"]?.jsonPrimitive?.content?:"",
            textColor = obj["textColor"]?.jsonPrimitive?.contentOrNull,
            textSize = obj["textSize"]?.jsonPrimitive?.intOrNull,
            backgroundColor = obj["backgroundColor"]?.jsonPrimitive?.contentOrNull,
            cornerRadius = obj["cornerRadius"]?.jsonPrimitive?.intOrNull,
            borderColor = obj["borderColor"]?.jsonPrimitive?.contentOrNull,
            borderWidth = obj["borderWidth"]?.jsonPrimitive?.intOrNull,
            width = obj["width"]?.jsonPrimitive?.intOrNull,
            height = obj["height"]?.jsonPrimitive?.intOrNull
        )

        "image" -> ImageComponent(
            id = obj["id"]?.jsonPrimitive?.content?:"",
            url = obj["url"]?.jsonPrimitive?.content?:"",
            contentDescription = obj["contentDescription"]?.jsonPrimitive?.contentOrNull,
            width = obj["width"]?.jsonPrimitive?.intOrNull,
            height = obj["height"]?.jsonPrimitive?.intOrNull,
            shape = obj["shape"]?.jsonPrimitive?.contentOrNull,
            borderColor = obj["borderColor"]?.jsonPrimitive?.contentOrNull
        )

        "list" -> {
            val itemsArray = obj["items"]?.jsonArray ?: JsonArray(emptyList())
            val items = itemsArray.map { parseUIComponent(it.jsonObject) }
            ListComponent(
                id = obj["id"]?.jsonPrimitive?.content?:"",
                items = items
            )
        }

        "card" -> {
            val childrenArray = obj["children"]?.jsonArray ?: JsonArray(emptyList())
            val children = childrenArray.map { parseUIComponent(it.jsonObject) }
            CardComponent(
                id = obj["id"]?.jsonPrimitive?.content?:"",
                children = children
            )
        }

        else -> throw IllegalArgumentException("Unknown type: ${obj["type"]?.jsonPrimitive?.content}")
    }
}
