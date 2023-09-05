package ru.konst.bookingahotel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.konst.bookingahotel.R

// Set of Material typography styles to start with
private val SfProDisplay = FontFamily(
    Font(R.font.sfpprodisplay_regular),
    Font(R.font.sfpprodisplay_medium, FontWeight(500))
)

val BookingAHotelTypography = Typography (
    bodyLarge = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight(500),
        fontSize = 16.sp,
        lineHeight = 19.2.sp
    ),
    labelLarge = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight(500),
        fontSize = 22.sp,
        lineHeight = 26.4.sp
    ),
    labelSmall = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight(500),
        fontSize = 14.sp,
        lineHeight = 16.8.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight(600),
        fontSize = 30.sp,
        lineHeight = 36.sp
    ),
    displayLarge = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 19.2.sp
    ),
    displayMedium = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 19.2.sp
    ),
    displaySmall = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight(400),
        fontSize = 12.sp,
        lineHeight = 14.4.sp
    )

)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)