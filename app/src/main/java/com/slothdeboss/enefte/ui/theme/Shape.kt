package com.slothdeboss.enefte.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes = EnEfTeShapes()

data class EnEfTeShapes(
    val small: Shape = RoundedCornerShape(5.dp),
    val default: Shape = RoundedCornerShape(10.dp),
    val topDefault: Shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    val topLarge: Shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
)
