import androidx.compose.ui.graphics.Color

data class PrimaryColor(
    val primaryBackground: Color = Color(0xFFFCE6E5),
    val primary200: Color = Color(0xFFF9CECC),
    val primary300: Color = Color(0xFFDB9391),
    val primary400: Color = Color(0xFFE9524D),
    val primaryDefault: Color = Color(0xFFE00800),
    val primary600: Color = Color(0xFF9C1301),
    val primary700: Color = Color(0xFF700400),
    val primary800: Color = Color(0xFF430200),
    val primary900: Color = Color(0xFF160100),
)

data class NaturalColor(
    val naturalGrayBackground: Color = Color(0xFFF2F2F2),
    val naturalGray200: Color = Color(0xFFCCCCCC),
    val naturalGray300: Color = Color(0xFFB3B3B3),
    val naturalGray400: Color = Color(0xFF999999),
    val naturalGrayDefault: Color = Color(0xFF000000),
    val naturalGray600: Color = Color(0xFF666666),
    val naturalGray700: Color = Color(0xFF4D4D4D),
    val naturalGray800: Color = Color(0xFF333333),
    val naturalGray900: Color = Color(0xFF0D0D0D),
)

data class FunctionalSuccessColor(
    val functionalSuccessBackground: Color = Color(0xFFF7FFF0),
    val functionalSuccess200: Color = Color(0xFFE6FFD1),
    val functionalSuccess300: Color = Color(0xFFC2F2A0),
    val functionalSuccess400: Color = Color(0xFF7CD94A),
    val functionalSuccessDefault: Color = Color(0xFF58CB24),
    val functionalSuccess600: Color = Color(0xFF3EA616),
    val functionalSuccess700: Color = Color(0xFF28800A),
    val functionalSuccess800: Color = Color(0xFF155903),
    val functionalSuccess900: Color = Color(0xFF0A3301),
)

data class FunctionalWarningColor(
    val functionalWarningBackground: Color = Color(0xFFFFFEE6),
    val functionalWarning200: Color = Color(0xFFFFF9B8),
    val functionalWarning300: Color = Color(0xFFFFE866),
    val functionalWarning400: Color = Color(0xFFFFDB3D),
    val functionalWarningDefault: Color = Color(0xFFFAC714),
    val functionalWarning600: Color = Color(0xFFD4A006),
    val functionalWarning700: Color = Color(0xFFAD7C00),
    val functionalWarning800: Color = Color(0xFF875C00),
    val functionalWarning900: Color = Color(0xFF613F00),
)

data class FunctionalErrorColor(
    val functionalErrorBackground: Color = Color(0xFFFFEFED),
    val functionalError200: Color = Color(0xFFFFA19C),
    val functionalError300: Color = Color(0xFFFF7573),
    val functionalError400: Color = Color(0xFFFF4A4D),
    val functionalErrorDefault: Color = Color(0xFFFF222E),
    val functionalError600: Color = Color(0xFFD91122),
    val functionalError700: Color = Color(0xFFB3051A),
    val functionalError800: Color = Color(0xFF8C0015),
    val functionalError900: Color = Color(0xFF660013),
)

data class Colors(
    val primary: PrimaryColor = PrimaryColor(),
    val naturalColor: NaturalColor = NaturalColor(),
    val successColor: FunctionalSuccessColor = FunctionalSuccessColor(),
    val warningColor: FunctionalWarningColor = FunctionalWarningColor(),
    val errorColor: FunctionalErrorColor = FunctionalErrorColor(),
)
