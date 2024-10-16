package com.gufo.presentation_composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ColumnScope.Container(
    weight: Float,
    align: Alignment = Alignment.Center,
    content: @Composable () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize().weight(weight), contentAlignment = align) {
        content()
    }

}