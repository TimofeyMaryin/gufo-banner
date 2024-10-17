package com.gufo.presentation_composable.shapes

import android.text.TextPaint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BlobShapeView(
    color: Color,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
    ) {

        val width = size.width
        val height = size.height

        // Определяем форму волнообразного овала с помощью Path, используя динамичные размеры
        val path = Path().apply {
            moveTo(width * 0.1f, height * 0.4f)
            // Создаем волны по верхней части
            cubicTo(
                width * 0.3f, height * 0.2f,
                width * 0.5f, height * 0.5f,
                width * 0.7f, height * 0.4f
            )
            cubicTo(
                width * 0.9f, height * 0.2f,
                width * 1.1f, height * 0.6f,
                width * 0.9f, height * 0.8f
            )
            // Плавный переход вниз
            cubicTo(
                width * 0.7f, height * 1.0f,
                width * 0.3f, height * 1.0f,
                width * 0.1f, height * 0.8f
            )
            // Создаем волны по нижней части
            cubicTo(
                width * -0.1f, height * 0.6f,
                width * 0.0f, height * 0.5f,
                width * 0.1f, height * 0.4f
            )
            close()
        }

        // Рисуем волнообразный овал
        drawPath(
            path = path,
            color = color
        )
    }
}


@Composable
fun BlobShapeView(
    brush: Brush,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
    ) {

        val width = size.width
        val height = size.height

        // Определяем форму волнообразного овала с помощью Path, используя динамичные размеры
        val path = Path().apply {
            moveTo(width * 0.1f, height * 0.4f)
            // Создаем волны по верхней части
            cubicTo(
                width * 0.3f, height * 0.2f,
                width * 0.5f, height * 0.5f,
                width * 0.7f, height * 0.4f
            )
            cubicTo(
                width * 0.9f, height * 0.2f,
                width * 1.1f, height * 0.6f,
                width * 0.9f, height * 0.8f
            )
            // Плавный переход вниз
            cubicTo(
                width * 0.7f, height * 1.0f,
                width * 0.3f, height * 1.0f,
                width * 0.1f, height * 0.8f
            )
            // Создаем волны по нижней части
            cubicTo(
                width * -0.1f, height * 0.6f,
                width * 0.0f, height * 0.5f,
                width * 0.1f, height * 0.4f
            )
            close()
        }

        // Рисуем волнообразный овал
        drawPath(
            path = path,
            brush = brush
        )
    }

}


@Preview
@Composable
fun PreviewBlobShapeView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center,
    ) {
        BlobShapeView(color = Color.Red, modifier = Modifier
            .fillMaxWidth(.9f)
            .height(400.dp))
    }
}
