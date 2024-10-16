package com.gufo.presentation_composable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

val primaryCorner = 35.dp

val primaryCornerTop = { RoundedCornerShape(topStart = primaryCorner, topEnd = primaryCorner) }
val primaryCornerFull = { RoundedCornerShape(primaryCorner) }