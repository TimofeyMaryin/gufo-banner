package com.gufo.presentation_composable

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val bg = Color.White
val containerBg = Color(0xFFB9B9B9)
val gray = Color.Gray
val textColor = Color.Black
val selectedColor = Color.Blue


val selectedBush = Brush.horizontalGradient(
    listOf(
        Color(0xff009FFF),
        Color(0xffec2F4B)
    )
)