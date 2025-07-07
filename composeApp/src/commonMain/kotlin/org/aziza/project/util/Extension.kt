package org.aziza.project.util

/**
 * Created by Aziza Helmy on 07/07/2025.
 */


fun String.toColorInt(): ULong {
    val colorString = this.removePrefix("#")
    val color = when (colorString.length) {
        6 -> "FF$colorString"
        8 -> colorString
        else -> throw IllegalArgumentException("Invalid color string: $this")
    }
    return color.toULong(16)
}
