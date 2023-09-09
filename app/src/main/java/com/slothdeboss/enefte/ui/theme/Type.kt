package com.slothdeboss.enefte.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.slothdeboss.enefte.R

val Typography = EnEfTeTypography(
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.gilroy_bold)),
        fontSize = 31.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.gilroy_bold)),
        fontSize = 24.sp
    ),
    body = TextStyle(
        fontFamily = FontFamily(Font(R.font.gilroy_regular)),
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily(Font(R.font.gilroy_medium)),
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily(Font(R.font.gilroy_light)),
        fontSize = 12.sp
    ),
    smallCaption = TextStyle(
        fontFamily = FontFamily(Font(R.font.gilroy_light)),
        fontSize = 10.sp
    )
)

@Immutable
class EnEfTeTypography(
    val h1: TextStyle = TextStyle.Default,
    val h2: TextStyle = TextStyle.Default,
    val body: TextStyle = TextStyle.Default,
    val button: TextStyle = TextStyle.Default,
    val caption: TextStyle = TextStyle.Default,
    val smallCaption: TextStyle = TextStyle.Default,
)
