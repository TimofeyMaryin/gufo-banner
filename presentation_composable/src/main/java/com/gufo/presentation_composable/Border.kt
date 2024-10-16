package com.gufo.presentation_composable

import android.graphics.RectF
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.dottedBorder(
    color: Color,
    dotSize: Dp = 4.dp,
    dotSpacing: Dp = 4.dp,
    strokeWidth: Dp = 2.dp,
    cornerRadius: Dp = 0.dp
) = this.drawBehind {
    val dotWidth = dotSize.toPx()
    val spacingPx = dotSpacing.toPx()
    val strokePx = strokeWidth.toPx()
    val cornerRadiusPx = cornerRadius.toPx()

    val path = Path().apply {
        addRoundRect(
            RoundRect(
                rect = androidx.compose.ui.geometry.Rect(
                    0f,
                    0f,
                    size.width,
                    size.height
                ),
                cornerRadius = CornerRadius(cornerRadiusPx)
            )
        )
    }

    clipPath(path) {
        // Draw top border
        drawDottedLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            dotWidth = dotWidth,
            spacing = spacingPx,
            strokeWidth = strokePx,
            isHorizontal = true
        )

        // Draw bottom border
        drawDottedLine(
            color = color,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            dotWidth = dotWidth,
            spacing = spacingPx,
            strokeWidth = strokePx,
            isHorizontal = true
        )

        // Draw left border
        drawDottedLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            dotWidth = dotWidth,
            spacing = spacingPx,
            strokeWidth = strokePx,
            isHorizontal = false
        )

        // Draw right border
        drawDottedLine(
            color = color,
            start = Offset(size.width, 0f),
            end = Offset(size.width, size.height),
            dotWidth = dotWidth,
            spacing = spacingPx,
            strokeWidth = strokePx,
            isHorizontal = false
        )
    }
}

private fun DrawScope.drawDottedLine(
    color: Color,
    start: Offset,
    end: Offset,
    dotWidth: Float,
    spacing: Float,
    strokeWidth: Float,
    isHorizontal: Boolean
) {
    val totalLength = if (isHorizontal) end.x - start.x else end.y - start.y
    val dotAndSpaceLength = dotWidth + spacing
    var currentPosition = 0f

    while (currentPosition < totalLength) {
        val rectStart = if (isHorizontal) {
            Offset(start.x + currentPosition, start.y)
        } else {
            Offset(start.x, start.y + currentPosition)
        }

        val size = if (isHorizontal) {
            Size(width = dotWidth, height = strokeWidth)
        } else {
            Size(width = strokeWidth, height = dotWidth)
        }

        drawRect(
            color = color,
            topLeft = rectStart,
            size = size
        )
        currentPosition += dotAndSpaceLength
    }
}


val stroke = Stroke(width = 2f,
    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
)

fun Modifier.dashedBorder(strokeWidth: Dp, color: Color, cornerRadiusDp: Dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerRadiusPx = density.run { cornerRadiusDp.toPx() }

        this.then(
            Modifier.drawWithCache {
                onDrawBehind {
                    val stroke = Stroke(
                        width = strokeWidthPx,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )

                    drawRoundRect(
                        color = color,
                        style = stroke,
                        cornerRadius = CornerRadius(cornerRadiusPx)
                    )
                }
            }
        )
    }
)

@Preview(showBackground = true)
@Composable
fun DottedBorderPreview() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .size(200.dp)
            .background(Color.White)
            .dottedBorder(
                color = Color.Blue,
                dotSize = 2.dp,
                dotSpacing = 6.dp,
                strokeWidth = 2.dp,
                cornerRadius = 20.dp
            )
    )
}



