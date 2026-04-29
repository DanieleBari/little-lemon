package com.littlelemon.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.littlelemon.littlelemon.R


val Markazi = FontFamily(
    Font(R.font.markazi_text_regular, FontWeight.Medium)
)
val Karla = FontFamily(
    Font(R.font.karla_regular, FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Markazi,
        fontWeight = FontWeight.Medium,
        fontSize = 48.sp,
        lineHeight = 52.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Markazi,
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp,
        lineHeight = 40.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Markazi,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 32.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.sp
    )
)