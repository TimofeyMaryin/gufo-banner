package com.gufo.presentation_create

import android.graphics.Bitmap
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity

@Deprecated("Does not work")
@Composable
fun CreateAndSaveImage(
    modifier: Modifier = Modifier,
    onImageCreated: (Bitmap) -> Unit,
    content: @Composable (Modifier) -> Unit
) {
    // Размеры изображения
    val compositionWidth = 1920
    val compositionHeight = 1080

    // Создаем пустой Bitmap для рисования
    val bitmap = remember {
        Bitmap.createBitmap(compositionWidth, compositionHeight, Bitmap.Config.ARGB_8888)
    }
    val canvas = android.graphics.Canvas(bitmap)

    // Используем ComposeView для рендеринга Composable в Bitmap
    val context = LocalContext.current
    val composeView = ComposeView(context).apply {
        setContent {
            content(modifier)
        }
    }

    LaunchedEffect(Unit) {
        // Измеряем и размещаем ComposeView с точными размерами
        composeView.measure(
            View.MeasureSpec.makeMeasureSpec(compositionWidth, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(compositionHeight, View.MeasureSpec.EXACTLY)
        )
        composeView.layout(0, 0, compositionWidth, compositionHeight)

        // Рисуем содержимое на Canvas
        composeView.draw(canvas)

        // Возвращаем готовый Bitmap через callback
        onImageCreated(bitmap)
    }
}

