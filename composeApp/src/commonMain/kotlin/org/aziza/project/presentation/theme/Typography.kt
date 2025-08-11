package org.aziza.project.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import justcheck_cmp.composeapp.generated.resources.Res
import justcheck_cmp.composeapp.generated.resources.sf_pro_display_bold
import justcheck_cmp.composeapp.generated.resources.sf_pro_display_medium
import justcheck_cmp.composeapp.generated.resources.sf_pro_display_regular
import org.jetbrains.compose.resources.Font

/**
 * Created by Aziza Helmy on 16/07/2025.
 */

data class Typography(
    val head: HeadingStyles = HeadingStyles,
    val body: BodyStyles = BodyStyles,
    val button: ButtonStyles = ButtonStyles,
    val field: FieldStyles = FieldStyles,
)

// Base text style builder
fun buildTextStyle(
    fontFamily: FontFamily,
    fontWeight: FontWeight,
    fontSize: Int,
    lineHeight: Int,
    //todo: Option To add color with each type of text, but need designer confirmation
    letterSpacing: Double = 0.0,
) = TextStyle(
    fontFamily = fontFamily,
    fontWeight = fontWeight,
    fontSize = fontSize.sp,
    // color = Color.Black,
    lineHeight = lineHeight.sp,
    letterSpacing = letterSpacing.sp
)

object HeadingStyles {
    @Composable
    fun head1Bold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 32,
        lineHeight = 40
    )

    @Composable
    fun head2Bold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 28,
        lineHeight = 38
    )

    @Composable
    fun head3Bold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 24,
        lineHeight = 32
    )

    @Composable
    fun head4Bold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 20,
        lineHeight = 28
    )

    @Composable
    fun head5Bold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 18,
        lineHeight = 24
    )

    @Composable
    fun head6Bold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 16,
        lineHeight = 20
    )
}

object ButtonStyles {
    @Composable
    fun normalBold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 18,
        lineHeight = 24
    )

    @Composable
    fun normalRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 18,
        lineHeight = 24
    )

    @Composable
    fun linkNormalMedium() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 18,
        lineHeight = 24
    )

    @Composable
    fun linkMediumRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16,
        lineHeight = 20
    )

    @Composable
    fun linkMediumBold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 16,
        lineHeight = 20
    )

    @Composable
    fun linkMediumMedium() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 16,
        lineHeight = 20
    )

    @Composable
    fun smallBold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 14,
        lineHeight = 16
    )

    @Composable
    fun smallRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14,
        lineHeight = 16
    )

    @Composable
    fun smallMedium() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 14,
        lineHeight = 16
    )
}

object BodyStyles {
    @Composable
    fun largeRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 18,
        lineHeight = 27
    )

    @Composable
    fun largeMedium() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 18,
        lineHeight = 27
    )

    @Composable
    fun mediumRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16,
        lineHeight = 24
    )

    @Composable
    fun mediumMedium() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 16,
        lineHeight = 24
    )

    @Composable
    fun smallRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14,
        lineHeight = 21
    )

    @Composable
    fun smallMedium() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 14,
        lineHeight = 21
    )

    @Composable
    fun extraSmallBold() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 12,
        lineHeight = 18
    )

    @Composable
    fun extraSmallMedium() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 12,
        lineHeight = 18
    )
}

object FieldStyles {
    @Composable
    fun normalRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 18,
        lineHeight = 24
    )

    @Composable
    fun mediumRegular() = buildTextStyle(
        fontFamily = FontFamily(Font(Res.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16,
        lineHeight = 20
    )
}

object LinkStyles {
    //todo:same as ButtonStyles so discuss with designer first!
}
