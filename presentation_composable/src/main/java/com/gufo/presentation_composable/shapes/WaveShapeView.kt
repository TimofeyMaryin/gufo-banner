package com.gufo.presentation_composable.shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun WaveShapeView(
    color: Color,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = Modifier.fillMaxSize().then(modifier)
    ) {
        val width = size.width
        val height = size.height

        // Определяем форму волнообразного прямоугольника с помощью Path
        val path = Path().apply {
            moveTo(width * 0.1f, height * 0.2f)

            // Верхняя волна
            cubicTo(
                width * 0.3f, height * 0.05f,
                width * 0.5f, height * 0.3f,
                width * 0.7f, height * 0.2f
            )
            cubicTo(
                width * 0.9f, height * 0.1f,
                width * 1.1f, height * 0.3f,
                width * 0.9f, height * 0.5f
            )

            // Правая сторона с волной
            cubicTo(
                width * 0.95f, height * 0.7f,
                width * 0.85f, height * 0.9f,
                width * 0.7f, height * 0.8f
            )

            // Нижняя волна
            cubicTo(
                width * 0.5f, height * 1.05f,
                width * 0.3f, height * 0.7f,
                width * 0.1f, height * 0.8f
            )

            // Левая сторона с волной
            cubicTo(
                width * 0.0f, height * 0.6f,
                width * -0.05f, height * 0.4f,
                width * 0.1f, height * 0.2f
            )
            close()
        }

        // Рисуем волнообразный прямоугольник
        drawPath(
            path = path,
            color = color
        )
    }

}


@Composable
fun WaveShapeView(
    brush: Brush,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = Modifier.fillMaxSize().then(modifier)
    ) {
        val width = size.width
        val height = size.height

        // Определяем форму волнообразного прямоугольника с помощью Path
        val path = Path().apply {
            moveTo(width * 0.1f, height * 0.2f)

            // Верхняя волна
            cubicTo(
                width * 0.3f, height * 0.05f,
                width * 0.5f, height * 0.3f,
                width * 0.7f, height * 0.2f
            )
            cubicTo(
                width * 0.9f, height * 0.1f,
                width * 1.1f, height * 0.3f,
                width * 0.9f, height * 0.5f
            )

            // Правая сторона с волной
            cubicTo(
                width * 0.95f, height * 0.7f,
                width * 0.85f, height * 0.9f,
                width * 0.7f, height * 0.8f
            )

            // Нижняя волна
            cubicTo(
                width * 0.5f, height * 1.05f,
                width * 0.3f, height * 0.7f,
                width * 0.1f, height * 0.8f
            )

            // Левая сторона с волной
            cubicTo(
                width * 0.0f, height * 0.6f,
                width * -0.05f, height * 0.4f,
                width * 0.1f, height * 0.2f
            )
            close()
        }

        // Рисуем волнообразный прямоугольник
        drawPath(
            path = path,
            brush = brush
        )
    }

}
